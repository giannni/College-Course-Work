//
//  ViewController.swift
//  BMI Calculator
//
//  Created by g on 2/10/20.
//  Copyright © 2020 Gianni Esposito. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var calcButton: UIButton!
    
    @IBOutlet weak var height: UISlider!
    
    @IBOutlet weak var bmiLabel: UILabel!
    
    @IBOutlet weak var displayHeight: UILabel!
    @IBOutlet weak var displayWeight: UILabel!
    @IBOutlet weak var weight: UISlider!
    
    @IBOutlet weak var categoryLabel: UILabel!
    
    @IBAction func heightSliderChanged(_ sender: UISlider)
    {
        let heightInput = Double(height.value)
        let formattedHeight = String(format: "%.1f", heightInput)
        displayHeight.text = "Height(inches): " + formattedHeight
        displayHeight.adjustsFontSizeToFitWidth = true
    }
    
    @IBAction func weightSliderChanged(_ sender: Any)
    {
        let weightInput = Double(weight.value)
        let formattedWeight = String(format: "%.1f", weightInput)
        displayWeight.text = "Weight(pounds): " + formattedWeight
        displayWeight.adjustsFontSizeToFitWidth = true
    }
    @IBAction func buttonTapped(_ sender: Any)
    {
        let heightInput = Double(height.value)
        let weightInput = Double(weight.value)
        //meters and kilograms
        //let bmi = weightInput / (heightInput * heightInput)
        //inches and pounds
        let bmi2 = weightInput / (heightInput * heightInput) * 703
        
        var category:String
        
        if bmi2 < 18.5
        {
            category = "Underweight"
            categoryLabel.textColor = UIColor.systemPink
        }
        else if bmi2 < 24.9
        {
            category = "Healthy Weight"
            categoryLabel.textColor = UIColor.blue
        }
        else if bmi2 < 29.9
        {
            category = "Overweight"
            categoryLabel.textColor = UIColor.red
        }
        else
        {
            category = "Obese"
            categoryLabel.textColor = UIColor.red
        }
        let formattedBMI = String(format: "%.1f", bmi2)
        bmiLabel.text = "BMI: " + formattedBMI
        categoryLabel.text = "Category: " + "\n \(category)"
        bmiLabel.adjustsFontSizeToFitWidth = true
        categoryLabel.adjustsFontSizeToFitWidth = true
    }
    
    @IBAction func switchThemes(_ sender: UISwitch)
    {
        if(sender.isOn)
        {
            self.view.backgroundColor = UIColor.darkGray
        }
        else
        {
            self.view.backgroundColor = UIColor.white
        }
    }
    override func viewDidLoad()
    {
        super.viewDidLoad()
        calcButton.layer.cornerRadius = 8
    }
}

