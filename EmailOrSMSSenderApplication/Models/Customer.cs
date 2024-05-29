using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Models
{
    internal class Customer
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public string PhoneNumber { get; set; }
        public string Email { get; set; }
        public NotificationPreference Preference { get; set; }

        public Customer(int id,string name, string pn, string email, NotificationPreference np) {
            ID = id;
            Name = name;
            PhoneNumber = pn;
            Email = email;
            Preference = np;
        }
        public enum NotificationPreference
        {
            Email,SMS,Both
        }
    }
}
