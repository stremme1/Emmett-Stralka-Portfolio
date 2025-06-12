import SpriteKit
import GameplayKit

// BubbleColor enum for placeholder colors
enum BubbleColor: CaseIterable {
    case red, blue, green, yellow, purple

    var color: UIColor {
        switch self {
        case .red: return .systemRed
        case .blue: return .systemBlue
        case .green: return .systemGreen
        case .yellow: return .systemYellow
        case .purple: return .systemPurple
        }
    }
}

class GameScene: SKScene {
    // MARK: - Properties
    private var bubbles: [[Bubble?]] = []
    private var selectedBubbles: [Bubble] = []
    private var score: Int = 0
    private var combo: Int = 0
    private var scoreLabel: SKLabelNode!
    private var comboLabel: SKLabelNode!
    private var scorePanel: SKSpriteNode!
    private var pauseButton: SKSpriteNode!
    
    // Grid configuration
    private let rows = 8
    private let columns = 6
    private let bubbleSize: CGFloat = 48
    private let bubbleColors: [BubbleColor] = BubbleColor.allCases
    
    // MARK: - Scene Setup
    override func didMove(to view: SKView) {
        setupBackground()
        setupGame()
        setupUI()
    }
    
    private func setupBackground() {
        let background = SKSpriteNode(imageNamed: "panelInset_beige") // Kenney UI panel as background
        background.position = CGPoint(x: frame.midX, y: frame.midY)
        background.zPosition = -1
        background.size = self.size
        addChild(background)
    }
    
    private func setupGame() {
        // Initialize bubble grid
        for row in 0..<rows {
            var bubbleRow: [Bubble?] = []
            for col in 0..<columns {
                let color = bubbleColors.randomElement()!
                let bubble = createBubble(at: CGPoint(x: col, y: row), color: color)
                bubbleRow.append(bubble)
                addChild(bubble)
            }
            bubbles.append(bubbleRow)
        }
    }
    
    private func setupUI() {
        // Score panel using Kenney UI asset
        scorePanel = SKSpriteNode(imageNamed: "panel_brown")
        scorePanel.position = CGPoint(x: frame.midX, y: frame.maxY - 60)
        scorePanel.size = CGSize(width: 260, height: 60)
        scorePanel.zPosition = 10
        addChild(scorePanel)
        
        // Score label
        scoreLabel = SKLabelNode(fontNamed: "AvenirNext-Bold")
        scoreLabel.text = "Score: 0"
        scoreLabel.position = CGPoint(x: -60, y: -10)
        scoreLabel.fontSize = 22
        scoreLabel.fontColor = .white
        scoreLabel.zPosition = 11
        scorePanel.addChild(scoreLabel)
        
        // Combo label
        comboLabel = SKLabelNode(fontNamed: "AvenirNext-Bold")
        comboLabel.text = "Combo: x1"
        comboLabel.position = CGPoint(x: 60, y: -10)
        comboLabel.fontSize = 20
        comboLabel.fontColor = .white
        comboLabel.zPosition = 11
        scorePanel.addChild(comboLabel)
        
        // Pause button using Kenney UI asset
        pauseButton = SKSpriteNode(imageNamed: "buttonSquare_beige")
        pauseButton.name = "pauseButton"
        pauseButton.position = CGPoint(x: frame.maxX - 40, y: frame.maxY - 40)
        pauseButton.size = CGSize(width: 48, height: 48)
        pauseButton.zPosition = 20
        addChild(pauseButton)
        
        let pauseIcon = SKSpriteNode(imageNamed: "iconPause_brown")
        pauseIcon.size = CGSize(width: 32, height: 32)
        pauseIcon.position = .zero
        pauseIcon.zPosition = 21
        pauseButton.addChild(pauseIcon)
    }
    
    // MARK: - Bubble Creation
    private func createBubble(at position: CGPoint, color: BubbleColor) -> Bubble {
        let bubble = Bubble(bubbleColor: color, size: CGSize(width: bubbleSize, height: bubbleSize))
        bubble.position = calculateBubblePosition(row: Int(position.y), col: Int(position.x))
        return bubble
    }
    
    private func calculateBubblePosition(row: Int, col: Int) -> CGPoint {
        let x = CGFloat(col) * bubbleSize + bubbleSize/2 + (frame.width - CGFloat(columns) * bubbleSize)/2
        let y = CGFloat(row) * bubbleSize + bubbleSize/2 + 100
        return CGPoint(x: x, y: y)
    }
    
    // MARK: - Touch Handling
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard let touch = touches.first else { return }
        let location = touch.location(in: self)
        let node = atPoint(location)
        if node == pauseButton || node.parent == pauseButton {
            // Handle pause
            isPaused = !isPaused
            return
        }
        if let bubble = node as? Bubble {
            handleBubbleSelection(bubble)
        }
    }
    
    private func handleBubbleSelection(_ bubble: Bubble) {
        selectedBubbles.append(bubble)
        bubble.select()
        
        if selectedBubbles.count >= 3 {
            checkForMatch()
        }
    }
    
    private func checkForMatch() {
        let color = selectedBubbles[0].bubbleColor
        let isMatch = selectedBubbles.allSatisfy { $0.bubbleColor == color }
        
        if isMatch {
            popBubbles()
            updateScore()
            checkForChainReactions()
        } else {
            deselectAllBubbles()
        }
    }
    
    private func popBubbles() {
        for bubble in selectedBubbles {
            bubble.pop()
            // Remove bubble from grid
            if let index = bubbles.flatMap({ $0 }).firstIndex(where: { $0 === bubble }) {
                let row = index / columns
                let col = index % columns
                bubbles[row][col] = nil
            }
        }
        selectedBubbles.removeAll()
    }
    
    private func updateScore() {
        combo += 1
        let points = selectedBubbles.count * 10 * combo
        score += points
        
        scoreLabel.text = "Score: \(score)"
        comboLabel.text = "Combo: x\(combo)"
    }
    
    private func checkForChainReactions() {
        // Implement chain reaction logic here
        // This would check for new matches after bubbles fall
    }
    
    private func deselectAllBubbles() {
        for bubble in selectedBubbles {
            bubble.deselect()
        }
        selectedBubbles.removeAll()
        combo = 0
        comboLabel.text = "Combo: x1"
    }
}

// MARK: - Bubble Class
class Bubble: SKShapeNode {
    let bubbleColor: BubbleColor
    
    init(bubbleColor: BubbleColor, size: CGSize) {
        self.bubbleColor = bubbleColor
        super.init()
        let circle = SKShapeNode(circleOfRadius: size.width/2)
        circle.fillColor = bubbleColor.color
        circle.strokeColor = .white
        circle.lineWidth = 2
        addChild(circle)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func select() {
        run(SKAction.scale(to: 1.2, duration: 0.1))
    }
    
    func deselect() {
        run(SKAction.scale(to: 1.0, duration: 0.1))
    }
    
    func pop() {
        let scale = SKAction.scale(to: 1.3, duration: 0.08)
        let shrink = SKAction.scale(to: 0.0, duration: 0.12)
        let remove = SKAction.removeFromParent()
        run(SKAction.sequence([scale, shrink, remove]))
    }
} 
