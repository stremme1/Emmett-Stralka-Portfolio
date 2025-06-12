import UIKit
import SpriteKit
import GameplayKit

class GameViewController: UIViewController {
    
    // MARK: - Properties
    private var gameScene: GameScene!
    private var pauseButton: UIButton!
    private var shopButton: UIButton!
    
    // MARK: - Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        setupGame()
        setupUI()
    }
    
    // MARK: - Setup
    private func setupGame() {
        if let view = self.view as! SKView? {
            gameScene = GameScene(size: view.bounds.size)
            gameScene.scaleMode = .aspectFill
            
            view.presentScene(gameScene)
            view.ignoresSiblingOrder = true
            
            #if DEBUG
            view.showsFPS = true
            view.showsNodeCount = true
            #endif
        }
    }
    
    private func setupUI() {
        // Pause Button
        pauseButton = UIButton(type: .system)
        pauseButton.setImage(UIImage(systemName: "pause.fill"), for: .normal)
        pauseButton.tintColor = .white
        pauseButton.addTarget(self, action: #selector(pauseButtonTapped), for: .touchUpInside)
        view.addSubview(pauseButton)
        
        // Shop Button
        shopButton = UIButton(type: .system)
        shopButton.setImage(UIImage(systemName: "cart.fill"), for: .normal)
        shopButton.tintColor = .white
        shopButton.addTarget(self, action: #selector(shopButtonTapped), for: .touchUpInside)
        view.addSubview(shopButton)
        
        // Layout
        pauseButton.translatesAutoresizingMaskIntoConstraints = false
        shopButton.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            pauseButton.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 16),
            pauseButton.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 16),
            pauseButton.widthAnchor.constraint(equalToConstant: 44),
            pauseButton.heightAnchor.constraint(equalToConstant: 44),
            
            shopButton.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 16),
            shopButton.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -16),
            shopButton.widthAnchor.constraint(equalToConstant: 44),
            shopButton.heightAnchor.constraint(equalToConstant: 44)
        ])
    }
    
    // MARK: - Actions
    @objc private func pauseButtonTapped() {
        // Implement pause functionality
        let isPaused = gameScene.isPaused
        gameScene.isPaused = !isPaused
        pauseButton.setImage(UIImage(systemName: isPaused ? "pause.fill" : "play.fill"), for: .normal)
    }
    
    @objc private func shopButtonTapped() {
        // Implement shop functionality
        let shopVC = ShopViewController()
        shopVC.modalPresentationStyle = .fullScreen
        present(shopVC, animated: true)
    }
    
    // MARK: - Orientation
    override var supportedInterfaceOrientations: UIInterfaceOrientationMask {
        return .portrait
    }
    
    override var prefersStatusBarHidden: Bool {
        return true
    }
} 