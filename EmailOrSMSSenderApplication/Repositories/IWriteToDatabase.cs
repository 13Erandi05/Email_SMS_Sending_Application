﻿using EmailOrSMSSenderApplication.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Repositories
{
    internal interface IWriteToDatabase
    {
        void AddCustomer(Customer customer);
    }
}
