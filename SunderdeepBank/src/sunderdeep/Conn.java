
package sunderdeep;
import java.sql.*;


public class Conn {
    
    Connection c;
    public Conn()
    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql:///sunderdeep","root","Manjeet@123#");
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    
}
