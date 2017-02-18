package atm.java;

/**
 * Created by MiguelHuerta on 2/17/17.
 */
public class Account
{
        private String accountHolder;
        private int accountNumber;
        private Double balance;
        private String accountType = "checking";

        public Account(String name, Double initBalance, int account)
        {
            accountHolder = name;
            balance = initBalance;
            accountNumber = account;
        }

        public void setUserName(String name)
        {
            accountHolder = name;
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

        public Double getBalance()
    {
        return balance;
    }

        public String getAccountType()
    {
        return accountType;
    }



}
