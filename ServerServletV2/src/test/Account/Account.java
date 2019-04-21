package test.Account;

/**
 *
 * @author Daniel
 * @author Edward
 */

public class Account {
    private String username, password;
    
    public Account(String u, String p){
        username = u;
        password = p;   
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String pass)
    {
        password = pass;
    }
    
    @Override
    public String toString()
    {
        StringBuilder B = new StringBuilder();
	B.append("\tUsername: ").append(username).append("\n");
        B.append("\tPassword: ").append(password).append("\n");
	return B.toString();
    }
    
    public String toStringFile()
	{
		StringBuilder B = new StringBuilder();
		B.append(username).append(",");
                B.append(password);
		return B.toString();
	}
}