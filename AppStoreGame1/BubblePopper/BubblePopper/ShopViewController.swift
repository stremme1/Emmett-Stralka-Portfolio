import UIKit
import StoreKit

class ShopViewController: UIViewController {
    
    // MARK: - Properties
    private let tableView = UITableView(frame: .zero, style: .grouped)
    private let products: [ShopItem] = [
        ShopItem(title: "Remove Ads", description: "Enjoy an ad-free experience", price: "$2.99", type: .removeAds),
        ShopItem(title: "Color Bomb", description: "Pop all bubbles of one color", price: "$0.99", type: .powerUp),
        ShopItem(title: "Time Freeze", description: "Freeze time for 30 seconds", price: "$0.99", type: .powerUp),
        ShopItem(title: "Coin Pack", description: "1000 coins", price: "$4.99", type: .coins)
    ]
    
    // MARK: - Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }
    
    // MARK: - Setup
    private func setupUI() {
        view.backgroundColor = .systemBackground
        title = "Shop"
        
        // Close button
        navigationItem.leftBarButtonItem = UIBarButtonItem(
            barButtonSystemItem: .close,
            target: self,
            action: #selector(closeButtonTapped)
        )
        
        // Table view setup
        tableView.delegate = self
        tableView.dataSource = self
        tableView.register(ShopItemCell.self, forCellReuseIdentifier: "ShopItemCell")
        view.addSubview(tableView)
        
        // Layout
        tableView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            tableView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            tableView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            tableView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            tableView.bottomAnchor.constraint(equalTo: view.bottomAnchor)
        ])
    }
    
    // MARK: - Actions
    @objc private func closeButtonTapped() {
        dismiss(animated: true)
    }
}

// MARK: - UITableViewDelegate & UITableViewDataSource
extension ShopViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return products.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ShopItemCell", for: indexPath) as! ShopItemCell
        let product = products[indexPath.row]
        cell.configure(with: product)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        let product = products[indexPath.row]
        handlePurchase(product)
    }
    
    private func handlePurchase(_ product: ShopItem) {
        // Implement StoreKit purchase logic here
        // This would connect to your App Store Connect products
    }
}

// MARK: - ShopItem Model
struct ShopItem {
    let title: String
    let description: String
    let price: String
    let type: ShopItemType
}

enum ShopItemType {
    case removeAds
    case powerUp
    case coins
}

// MARK: - ShopItemCell
class ShopItemCell: UITableViewCell {
    private let titleLabel = UILabel()
    private let descriptionLabel = UILabel()
    private let priceLabel = UILabel()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        setupUI()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupUI() {
        // Title label
        titleLabel.font = .systemFont(ofSize: 17, weight: .semibold)
        contentView.addSubview(titleLabel)
        
        // Description label
        descriptionLabel.font = .systemFont(ofSize: 14)
        descriptionLabel.textColor = .secondaryLabel
        contentView.addSubview(descriptionLabel)
        
        // Price label
        priceLabel.font = .systemFont(ofSize: 17, weight: .semibold)
        priceLabel.textColor = .systemBlue
        contentView.addSubview(priceLabel)
        
        // Layout
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        descriptionLabel.translatesAutoresizingMaskIntoConstraints = false
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: contentView.topAnchor, constant: 12),
            titleLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            
            descriptionLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 4),
            descriptionLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            descriptionLabel.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant: -12),
            
            priceLabel.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
            priceLabel.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16)
        ])
    }
    
    func configure(with item: ShopItem) {
        titleLabel.text = item.title
        descriptionLabel.text = item.description
        priceLabel.text = item.price
    }
} 