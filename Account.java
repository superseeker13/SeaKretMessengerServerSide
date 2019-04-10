package javaHandler;

/**
 *
 * @author Daniel
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
    
    public String toString()
    {
        StringBuffer B = new StringBuffer();
	B.append("\tUsername: " + username + "\n");
        B.append("\tPassword: " + password + "\n");
	return B.toString();
    }
    
    public String toStringFile()
	{
		StringBuffer B = new StringBuffer();
		B.append(username + ",");
                B.append(password);
		return B.toString();
	}
}