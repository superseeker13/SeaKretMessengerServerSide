package javaHandler;

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
        if (AccountsList.contains(newAccount))
            return true;
        else
        return false;
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
        PrintWriter P = new PrintWriter("accounts.txt");
        
        P.print(toStringFile());
        P.close();
        
    }
    
    public String toString()
    {
        StringBuffer B = new StringBuffer();
	B.append("Total Accounts: " + AccountsList.size() + "\n");
	for (int i = 0; i < AccountsList.size(); i++)
        {
            B.append(AccountsList.get(i).toString() + "\n");
        }
	return B.toString();
    }
    
    	public String toStringFile()
	{
		StringBuffer B = new StringBuffer();
		for (int i = 0; i < AccountsList.size(); i++)
                {
                   B.append(AccountsList.get(i).toStringFile());
                   B.append(System.getProperty("line.separator"));
                }	
		return B.toString();
	}
}
