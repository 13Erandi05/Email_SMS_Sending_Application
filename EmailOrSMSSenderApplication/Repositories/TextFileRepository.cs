using EmailOrSMSSenderApplication.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Repositories
{
    internal class TextFileRepository : IReadFromDatabase
    {
        //File path
        const string filePath = "D:\\Eyepax\\Task01_NotificationSender\\.NetProject\\EmailOrSMSSenderApplication\\CustomerData.txt";
        public Customer FindByID(int id)
        {
            List<Customer> allCustomers = GetAllCustomers();
            Customer customer = allCustomers.FirstOrDefault(
                c => c.ID == id);
            
            if(customer != null)
            {
                return customer;
            }

            throw new Exception();
        }

        public List<Customer> GetAllCustomers()
        {
            var customers = new List<Customer>();
            var lines = File.ReadAllLines(filePath);

            foreach (var line in lines)
            {
                var parts = line.Split(',');
                if (parts.Length == 5)
                {
                    Customer customer = new Customer
                    (int.Parse(parts[0]),
                     parts[1].Trim(),
                     parts[2].Trim(),
                     parts[3].Trim(),
                     ParsePreference(parts[4].Trim()));
                    customers.Add(customer);
                }
            }

            return customers;
        }

        private static Customer.NotificationPreference ParsePreference(string preference)
        {
            switch (preference.ToLower())
            {
                case "email": return Customer.NotificationPreference.Email;
                case "sms": return Customer.NotificationPreference.SMS;
                case "both": return Customer.NotificationPreference.Both;
                default: throw new ArgumentException("Invalid Notification Preference");
            }
        }

    }
}
