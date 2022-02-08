//
//  ViewController.swift
//  disco-lights
//
//  Created by g on 1/22/20.
//  Copyright © 2020 Gianni Esposito. All rights reserved.
//

import UIKit

class ViewController: UIViewController
{
    
    let colors: [UIColor] = [UIColor.red,UIColor.green,UIColor.orange,UIColor.yellow,UIColor.blue,UIColor.white]
    var i : Int = 0
    
    @IBAction func changeColors(_ sender: Any)
    {
        self.view.backgroundColor = colors[i]
        i += 1
        if (i >= colors.count)
        {
            i = 0
        }
    }
    
    @IBAction func displayLogo(_ sender: Any)
    {
        self.view.backgroundColor = UIColor(patternImage: UIImage(named: "logo.png")!)
    }
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

