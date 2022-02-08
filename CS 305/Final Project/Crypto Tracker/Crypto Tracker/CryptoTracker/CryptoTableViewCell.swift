import UIKit

class CryptoTableViewCell: UITableViewCell
{

    @IBOutlet weak var currencyImageView: UIImageView!
    @IBOutlet weak var currencyName: UILabel!
    @IBOutlet weak var currencyPrice: UILabel!
    
    func formatCell(withCurrencyType currencyType: CurrencyType)
    {
        currencyName.text = currencyType.name
        currencyImageView.image = currencyType.image
        
        currencyType.requestValue
            { (value) in DispatchQueue.main.async
                {
                guard let value = value else
                {
                    self.currencyPrice.text = "Failed to get price"
                    return
                }
                self.currencyPrice.text = value.formattedCurrencyString
            }
        }
    }

}

private extension NSNumber
{
    
    var formattedCurrencyString: String?
    {
        let formatter = NumberFormatter()
        formatter.locale = Locale(identifier: "en_US")
        formatter.numberStyle = .currency
        
        guard let formattedCurrencyAmount = formatter.string(from: self) else
        {
            return nil
        }
        return formattedCurrencyAmount
    }
    
}
