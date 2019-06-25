package jdbc_demo;
/*
    Java Database Connectivity (Here, with MySQL)
    
    Step 1 : Import the package 
    Step 2 : Load and register the driver
    Step 3 : Establish the connection
    Step 4 : Create the statement
    Step 5 : Execute the query
    Step 6 : Process the results
    Step 7 : Close the connection and statement
*/
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.*;  //Importing the package
public class JDBC_Demo {

    public static void main(String[] args) throws Exception{
    
       // String url = "jdbc:mysql://localhost:3306/jdbc_demo?zeroDateTimeBehavior=convertToNull";
        String url = "jdbc:mysql://localhost:3306/jdbc_demo?autoReconnect=true&useSSL=false";
        String user_name = "root";
        
        String pass_word = "";
        try{
            
        Class.forName("com.mysql.jdbc.Driver");    //forName is a method which will help you to load the class
        
        Connection con = DriverManager.getConnection(url, user_name, pass_word);   //We cannot create an object for an interface directly, so we need to deploy a class which implements connection
                            //or we need to search for a method which will give you the instance of conncection and that method is getConnection()
                            //and this method is available under DriverManager class
        System.out.println("Connected");
        
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM `students` WHERE userId>=3");
        
        rs.next();
        
        String answer_name = rs.getString("userName");  //either column number or column name
        
        
        System.out.println(answer_name);
        
        st.close();
        con.close();
        }
        catch(Exception e)
        {
            System.out.println("NOT Connected");
        }
        
    }
    
}
