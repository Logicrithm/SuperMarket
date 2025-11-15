import java.sql.*;

public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;

       public static void main(String args[])
     {
        DBConnect dbc=new DBConnect();
     }

    public DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "abhinav@0801";

            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement(); // Initialize the Statement object

            if (con != null) {
                System.out.println("Connected to the database!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection failed. Error: " + ex.getMessage());
        }
    }

}