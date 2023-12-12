import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class console_connect_database 
{
    public static void main(String[] arg )throws SQLException
    {
        Connection myCon=null;
        Statement myStat=null;
        ResultSet myRs=null;
        try
        {
         
            myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","!@#$%");
            myStat=myCon.createStatement();
            myRs=myStat.executeQuery("select * from login");
            while(myRs.next())
            {
               
                System.out.println(myRs.getString(("id"))+","+myRs.getString("username"));
                
            }
        }
        catch (SQLException ex)
         {
             ex.getStackTrace();
             }
        finally
         {
                  if(myRs!=null)
                    {
                    myRs.close();
                    }
                  if(myStat!=null)
                    {
                    myStat.close();
                    }
                    if(myCon!=null)
                    {
                    myCon.close();
                    }
                    
         }        
    }
    
}
