import java.sql.*;
import javax.swing.*;
import java.util.*;

    
public class ConnectDB
{
    private Connection con;
    private Statement st;
    private ResultSet rs;

    
    public ConnectDB() {
    try {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "abhinav@0801";

        con = DriverManager.getConnection(url, username, password);
        st = con.createStatement(); // Initialize the Statement object

        if (con != null) {
            System.out.println("Connected to the database!");
        }
    } catch (SQLException ex) {
        System.out.println("Connection failed. Error: " + ex.getMessage());
    }
}
    public void insertData(String Item,int ItemId ,int Cost,int Quantity) 
    {
        
        String query;
        try{
            query="insert into Shop(ItemId,Item,Cost,Quantity)value("+ItemId+",'"+Item+"',"+Cost+","+Quantity+")" ;
            st.executeUpdate(query);
    
        }
        catch(SQLException ex)
        {
          
        }
    }
    //Finding Product
    public String[] findProduct(String prd)
    {
        String []row=new String[4];
        String query="Select * from Shop where Item='"+prd+"'";
        try{
            rs=st.executeQuery(query);
            if(rs.next()){
                row[0]=rs.getString("ItemId");
                row[1]=rs.getString("Item");
                row[2]=rs.getString("Cost");
                row[3]=rs.getString("Quantity");
            }
        }catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null,"Error:"+ex);

           
        }
        return row;
    }
        public void viewInventoryData() {
        try {
            String query = "SELECT * FROM Shop";
            rs = st.executeQuery(query);

            while (rs.next()) {
                int itemId = rs.getInt("ItemId");
                String item = rs.getString("Item");
                int cost = rs.getInt("Cost");
                int quantity = rs.getInt("Quantity");

                System.out.println("Item ID: " + itemId);
                System.out.println("Item: " + item);
                System.out.println("Cost: " + cost);
                System.out.println("Quantity: " + quantity);
                System.out.println("------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      void update(int ItemId ,String Item,int Cost,int Quantity)
    {
        
       String query="update Shop set Quantity="+ItemId+",Item='"+Item+"',Cost="+Cost+", Quantity="+Quantity+" where ItemId="+ItemId;
       try{
           st.executeUpdate(query);
           
       }catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null,"Error:"+ex);

           
        }
    }

   
        
    }

