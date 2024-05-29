using EmailOrSMSSenderApplication.Services.EmailServices;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Services.Factory
{
    internal class EmailServicesFactory
    {

        public IEmailService CreateEmailService(string serviceType)
        {
            if (serviceType.Equals("Gmail"))
            {
                return new SMTPService();
            }
            // More conditions can be added for different email services
            throw new ArgumentException("Invalid Email Service Type");
        }
    }
}
