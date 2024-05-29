using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Services.SmsServices
{
    internal interface ISmsServices
    {
        void SendMessage(string message, string recipient);
    }
}
