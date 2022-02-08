//
//  ViewController.swift
//  Birthday Tracker
//
//  Created by g on 4/6/20.
//  Copyright © 2020 Gianni Esposito. All rights reserved.
//

import UIKit
import CoreData
import UserNotifications
class AddBirthdayViewController: UIViewController {
    
    
    @IBOutlet var firstNameTextfield: UITextField!
    @IBOutlet var lastNameTextfield: UITextField!
    @IBOutlet var birthDatePicker: UIDatePicker!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        birthDatePicker.maximumDate = Date()
    }

    @IBAction func saveTapped(_sender: UIBarButtonItem)
    {
        let birthDate = birthDatePicker.date
        let firstName = firstNameTextfield.text ?? ""
        let lastName = lastNameTextfield.text ?? ""
        
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        let context = appDelegate.persistentContainer.viewContext
        
        let newBirthday = Birthday(context: context)
        newBirthday.firstName = firstName
        newBirthday.lastName = lastName
        newBirthday.birthDate = birthDate as Date?
        newBirthday.birthdayId = UUID().uuidString
        
        if let uniqueId = newBirthday.birthdayId
        {
            print("The Birthday id is \(uniqueId)")
        }
        
        do{
            try context.save()
            let message = "Wish \(firstName) \(lastName) a Happy Birthday today!"
            let content = UNMutableNotificationContent()
            content.body = message
            content.sound = UNNotificationSound.default
            var dateComponents = Calendar.current.dateComponents([.month,.day], from: birthDate)
            dateComponents.hour = 8
            dateComponents.minute = 28
        
            let trigger = UNCalendarNotificationTrigger(dateMatching: dateComponents, repeats: true)
            if let identifier = newBirthday.birthdayId
            {
                let request = UNNotificationRequest(identifier: identifier, content: content, trigger: trigger)
                let center = UNUserNotificationCenter.current()
                center.add(request, withCompletionHandler: nil)
            }
        }catch let error
        {
            print("Could not save because of \(error)")
        }
        
        dismiss(animated: true, completion: nil)
    }

    @IBAction func cancelTapped(_sender: UIBarButtonItem)
    {
        dismiss(animated: true, completion: nil)
    }
    
}

