using EmailOrSMSSenderApplication.Controller;
using EmailOrSMSSenderApplication.Models;
using EmailOrSMSSenderApplication.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int id = 0;

            Console.WriteLine("Select the Email Service (Gmail) : ");
            string gmailService = Console.ReadLine();
            Console.WriteLine("Select the SMS Service (Twilio) : ");
            string smsService = Console.ReadLine();
            Console.WriteLine("Select random user by ID (1-3) : ");
            string idStr = Console.ReadLine();
            Console.WriteLine("Write the message : ");
            String message = Console.ReadLine();

            if (int.TryParse(idStr, out int number))
            {
                id = number;
            }
            else
            {
                Console.WriteLine("The input is not a valid integer.");
            }

            //Get data from database
            IReadFromDatabase textRead = new TextFileRepository();
            Customer customer = textRead.FindByID(id);

            // Call from Controller
            NotificationSender notify = new NotificationSender();
            notify.SendNotification("Gmail", "Twilio", customer, message);
        }
    }
}
