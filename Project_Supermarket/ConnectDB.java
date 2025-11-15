import java.sql.*;
import javax.swing.*;
import java.util.*;

/**
 * Database connection and operations handler for SuperMarket Management System
 * Handles all CRUD operations for inventory management
 * 
 * @author Logicrithm
 * @version 1.1
 */
public class ConnectDB {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    // Database configuration constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "abhinav@0801"; // TODO: Move to config file

    /**
     * Constructor - Establishes database connection
     * Automatically connects to MySQL database on initialization
     */
    public ConnectDB() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = con.createStatement();

            if (con != null) {
                System.out.println("✓ Successfully connected to database!");
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("✗ MySQL Driver not found: " + ex.getMessage());
            System.err.println("Please add MySQL Connector/J to your classpath");
        } catch (SQLException ex) {
            System.err.println("✗ Database connection failed: " + ex.getMessage());
            System.err.println("Please check your database credentials and server status");
        }
    }

    /**
     * Inserts new product into inventory
     * 
     * @param item Product name
     * @param itemId Unique product identifier
     * @param cost Price per unit
     * @param quantity Available stock quantity
     * @return true if insertion successful, false otherwise
     */
    public boolean insertData(String item, int itemId, int cost, int quantity) {
        String query = "INSERT INTO Shop(ItemId, Item, Cost, Quantity) VALUES(?, ?, ?, ?)";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, itemId);
            pst.setString(2, item);
            pst.setInt(3, cost);
            pst.setInt(4, quantity);
            
            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✓ Product added successfully!");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error inserting data: " + ex.getMessage());
            if (ex.getErrorCode() == 1062) { // Duplicate key error
                System.err.println("Item ID already exists in database");
            }
        }
        return false;
    }

    /**
     * Finds and retrieves product information by name
     * 
     * @param productName Name of product to search
     * @return String array [ItemId, Item, Cost, Quantity] or null if not found
     */
    public String[] findProduct(String productName) {
        String[] row = new String[4];
        String query = "SELECT * FROM Shop WHERE Item = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, productName);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                row[0] = rs.getString("ItemId");
                row[1] = rs.getString("Item");
                row[2] = rs.getString("Cost");
                row[3] = rs.getString("Quantity");
                return row;
            } else {
                System.out.println("⚠ Product '" + productName + "' not found in inventory");
                return null;
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error searching product: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Displays all products in inventory
     * Shows ItemId, Name, Cost, and available Quantity
     */
    public void viewInventoryData() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                      INVENTORY LIST");
        System.out.println("=".repeat(70));
        System.out.printf("%-10s %-25s %-15s %-15s%n", "Item ID", "Product Name", "Cost (₹)", "Quantity");
        System.out.println("-".repeat(70));
        
        try {
            String query = "SELECT * FROM Shop ORDER BY ItemId";
            rs = st.executeQuery(query);

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                int itemId = rs.getInt("ItemId");
                String item = rs.getString("Item");
                int cost = rs.getInt("Cost");
                int quantity = rs.getInt("Quantity");

                System.out.printf("%-10d %-25s %-15d %-15d%n", itemId, item, cost, quantity);
            }
            
            if (!hasData) {
                System.out.println("No products in inventory");
            }
            
            System.out.println("=".repeat(70) + "\n");
        } catch (SQLException ex) {
            System.err.println("✗ Error retrieving inventory: " + ex.getMessage());
        }
    }

    /**
     * Updates product information in database
     * 
     * @param itemId Product ID to update
     * @param item Product name
     * @param cost New cost per unit
     * @param quantity New quantity in stock
     * @return true if update successful, false otherwise
     */
    public boolean update(int itemId, String item, int cost, int quantity) {
        String query = "UPDATE Shop SET Item = ?, Cost = ?, Quantity = ? WHERE ItemId = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, item);
            pst.setInt(2, cost);
            pst.setInt(3, quantity);
            pst.setInt(4, itemId);
            
            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✓ Product updated successfully!");
                return true;
            } else {
                System.out.println("⚠ No product found with ID: " + itemId);
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("✗ Error updating product: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Checks if database connection is active
     * 
     * @return true if connected, false otherwise
     */
    public boolean isConnected() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Closes database connection and releases resources
     * Should be called when application terminates
     */
    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
            System.out.println("✓ Database connection closed");
        } catch (SQLException ex) {
            System.err.println("✗ Error closing connection: " + ex.getMessage());
        }
    }
}
