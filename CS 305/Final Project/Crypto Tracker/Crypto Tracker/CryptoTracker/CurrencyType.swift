import UIKit

enum CurrencyType: String {
    case btc = "BTC",
    eth = "ETH",
    ltc = "LTC",
    xrp = "XRP",
    xmr = "XMR",
    neo = "NEO",
    eos = "EOS",
    bch = "BCH",
    xlm = "XLM",
    usdt = "USDT"
    
    var apiURL: URL? {
        let apiString = "https://min-api.cryptocompare.com/data/price?fsym=" + rawValue + "&tsyms=USD"
        return URL(string: apiString)
    }
    
    var name: String
    {
        switch self {
        case .btc:
            return "Bitcoin"
        case .eth:
            return "Ethereum"
        case .ltc:
            return "Litecoin"
        case .xrp:
            return "Ripple"
        case .xmr:
            return "Monero"
        case .neo:
            return "NEO"
        case .eos:
            return "EOS"
        case .bch:
            return "Bitcoin Cash"
        case .xlm:
            return "Stellar"
        case .usdt:
            return "Tether"
        }
    }
    
    var image: UIImage
    {
        switch self
        {
        case .btc:
            return #imageLiteral(resourceName: "Bitcoin")
        case .eth:
            return #imageLiteral(resourceName: "Ethereum")
        case .ltc:
            return #imageLiteral(resourceName: "Litecoin")
        case .xrp:
            return #imageLiteral(resourceName: "Ripple")
        case .xmr:
            return #imageLiteral(resourceName: "Monero")
        case .neo:
            return #imageLiteral(resourceName: "NEO")
        case .eos:
            return #imageLiteral(resourceName: "EOS")
        case .bch:
            return #imageLiteral(resourceName: "BitcoinCash")
        case .xlm:
            return #imageLiteral(resourceName: "Stellar")
        case .usdt:
            return #imageLiteral(resourceName: "Tether")
        }
    }
    
    func requestValue(completion: @escaping (_ value: NSNumber?) -> Void)
    {
        guard let apiURL = apiURL else
        {
            completion(nil)
            print("URL Invalid")
            return
        }
        let request = URLSession.shared.dataTask(with: apiURL) { (data, response, error) in
            guard let data = data, error == nil else
            {
                completion(nil)
                print(error?.localizedDescription ?? "")
                return
            }
            do
            {
                guard let json = try JSONSerialization.jsonObject(with: data, options: .allowFragments) as? [String: Any],
                    let value = json["USD"] as? NSNumber else
                {
                        completion(nil)
                        return
                }
                completion(value)
            }
            catch
            {
                completion(nil)
                print(error.localizedDescription)
            }
        }
        request.resume()
    }
}

