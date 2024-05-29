using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Twilio;
using Twilio.Rest.Api.V2010.Account;

namespace EmailOrSMSSenderApplication.Services.SmsServices
{
    internal class TwilioSmsService : ISmsServices
    {
        const string accountSid = "ACf0b4f3485e6299cbf3494b5fa95e0d86";
        const string authToken = "e701e31ca1f7b9ef2f7ff3598ede7d5b";
        const string phoneNumber = "+14155702630";
        public void SendMessage(string message, string recipient)
        {
            TwilioClient.Init(accountSid, authToken);

            var TwilloMessage = MessageResource.Create(
                body: message,
                from: new Twilio.Types.PhoneNumber(phoneNumber),
                to: new Twilio.Types.PhoneNumber(recipient)
            );

            Console.WriteLine($"Sending SMS via Twilio to {recipient}: {message}");
        }
    }
}
