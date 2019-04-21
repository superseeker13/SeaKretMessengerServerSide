package test.Account;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class AccountList {
    
    String AccountsFile;
    
    ArrayList <Account> AccountsList = new ArrayList<>();
    
     public AccountList(String string)
    {
        AccountsFile = string;
        
        try
        {
            Scanner S = new Scanner(new FileInputStream(AccountsFile));
    
            while(S.hasNext())
            {
                String accountString = S.nextLine();
                String [] accountInfo = accountString.split(",");
                String email = accountInfo[0];
                String username = accountInfo[1];
                String password = accountInfo[2];

                Account newAccount = new Account(username, password);
                newAccount.setPassword(password);

                AccountsList.add(newAccount);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file");
        }

    }
    
    public boolean containsUsername(String username)
    { 
       if(toStringFile().contains(username))
       {
           return true;
       }
       else
       return false;
    }
    
    public boolean addAccount(Account newAccount)
    {
        AccountsList.add(newAccount);
        return AccountsList.contains(newAccount);
    }
    
    public Account AuthenticateAccount(Account account)
    {
        if (AccountsList.contains(account));
        {
            String pass = account.getPassword();
            if (toStringFile().contains(pass))
              return account;  
            else
            return null;
        }
    }
    
    public void saveList() throws IOException
    {
        try (PrintWriter P = new PrintWriter("accounts.txt")) {
            P.print(toStringFile());
        }  
    }
    
    @Override
    public String toString()
    {
        StringBuilder B = new StringBuilder();
	B.append("Total Accounts: ").append(AccountsList.size()).append("\n");
	for (int i = 0; i < AccountsList.size(); i++)
        {
            B.append(AccountsList.get(i).toString()).append("\n");
        }
	return B.toString();
    }
    
    	public String toStringFile()
	{
		StringBuilder B = new StringBuilder();
		for (int i = 0; i < AccountsList.size(); i++)
                {
                   B.append(AccountsList.get(i).toStringFile());
                   B.append(System.getProperty("line.separator"));
                }	
		return B.toString();
	}
}
