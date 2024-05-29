using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using MailKit.Net.Smtp;
using MailKit;
using MimeKit;
using EmailOrSMSSenderApplication.Models;


namespace EmailOrSMSSenderApplication.Services.EmailServices
{

    internal class SMTPService : IEmailService
    {
        const string SMTP_USERNAME = "eysarathchandra@gmail.com";
        const string SMTP_PASSWORD = "kfocuxzqusmcvxcl";


        //Send Email using Gmail STMP server
        public void SendMessage(string message, Customer recipient)
        {
            var email = new MimeMessage();

            email.From.Add(new MailboxAddress("Erandi", "eysarathchandra@gmail.com"));
            email.To.Add(new MailboxAddress(recipient.Name, recipient.Email));

            email.Subject = "Promotion Mail";
            email.Body = new TextPart(MimeKit.Text.TextFormat.Html)
            {
                Text = message
            };

            using (var smtp =  new SmtpClient())
            {
                smtp.Connect("smtp.gmail.com", 587, false);

                smtp.Authenticate(SMTP_USERNAME, SMTP_PASSWORD);

                smtp.Send(email);
                smtp.Disconnect(true);
            }

            Console.WriteLine($"Sending email via Gmail to {recipient}: {message}");
        }
    }
}
