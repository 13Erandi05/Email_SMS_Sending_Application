using EmailOrSMSSenderApplication.Services.SmsServices;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Services.Factory
{
    internal class SmsServiceFactory
    {
        public ISmsServices CreateSmsService(string serviceType)
        {
            if (serviceType.Equals("Twilio"))
            {
                return new TwilioSmsService();
            }
            // More conditions can be added for different SMS services
            throw new ArgumentException("Invalid SMS Service Type");
        }
    }
}
