package atm.java;

/**
 * Created by MiguelHuerta on 2/17/17.
 */
public class Account
{
        private String firstName;
        private int accountNumber;
        private double balance;
        private String accountType = "checking";


        public Account(String name, double initBalance, int account)
        {
            firstName = name;
            balance = initBalance;
            accountNumber = account;
        }

        public void setFirstName(String name)
        {
            firstName = name;
        }

        public void setAccountNumber(int setNumber)
        {
            accountNumber = setNumber;
        }

        public void  depositAmount(double add)
    {
        balance += add;
    }

        public void withdrawAmount(double amount)
    {
        balance -= amount;
    }

        public double getBalance()
    {
        return balance;
    }

        public String getAccountType()
    {
        return accountType;
    }

        public String getFirstName() { return firstName;}


}
