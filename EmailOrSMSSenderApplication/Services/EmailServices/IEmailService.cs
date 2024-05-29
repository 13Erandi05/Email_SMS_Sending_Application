using EmailOrSMSSenderApplication.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Services.EmailServices
{
    internal interface IEmailService
    {
        void SendMessage(string message,Customer recipient);
    }
}
