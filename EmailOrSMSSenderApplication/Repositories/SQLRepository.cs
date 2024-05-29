using EmailOrSMSSenderApplication.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailOrSMSSenderApplication.Repositories
{
    internal class SQLRepository : IReadFromDatabase, IWriteToDatabase
    {
        public void AddCustomer(Customer customer)
        {
            throw new NotImplementedException();
        }

        public Customer FindByID(int id)
        {
            throw new NotImplementedException();
        }

        public List<Customer> GetAllCustomers()
        {
            throw new NotImplementedException();
        }
    }
}
