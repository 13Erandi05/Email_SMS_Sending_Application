using EmailOrSMSSenderApplication.Models;
using EmailOrSMSSenderApplication.Services.Factory;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Controller
{
    internal class NotificationSender
    {
        private readonly EmailServicesFactory emailServiceFactory;
        private readonly SmsServiceFactory smsServiceFactory;

        public NotificationSender()
        {
            emailServiceFactory = new EmailServicesFactory();
            smsServiceFactory = new SmsServiceFactory();
        }

        public void SendNotification(string EmailGateway, string smsGateway,Customer customer, string message)
        {
            switch (customer.Preference)
            {
                case Customer.NotificationPreference.Email:
                    var emailService = emailServiceFactory.CreateEmailService(EmailGateway);
                    emailService.SendMessage(message, customer);
                    break;
                case Customer.NotificationPreference.SMS:
                    var smsService = smsServiceFactory.CreateSmsService(smsGateway);
                    smsService.SendMessage(message, customer.PhoneNumber);
                    break;
                case Customer.NotificationPreference.Both:
                    var emailServiceForBoth = emailServiceFactory.CreateEmailService(EmailGateway);
                    var smsServiceForBoth = smsServiceFactory.CreateSmsService(smsGateway);
                    emailServiceForBoth.SendMessage(message, customer);
                    smsServiceForBoth.SendMessage(message, customer.PhoneNumber);
                    break;
            }
        }
    }
}
