# 🛒 SuperMarket Management System

A comprehensive Java-based supermarket management system with inventory control, billing, and role-based access for administrators and customers.

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 Table of Contents
- [Features](#features)
- [System Architecture](#system-architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [Authors](#authors)

## ✨ Features

### Administrator Features
- 🔐 **Secure Login** - Password-protected administrator access
- ➕ **Inventory Management** - Add new products with ID, name, cost, and quantity
- 💰 **Price Updates** - Modify product pricing in real-time
- 📦 **Stock Management** - Update product quantities
- 📊 **Inventory Viewing** - Real-time inventory display

### Customer Features
- 🛍️ **Product Browsing** - View complete inventory with prices and availability
- 🛒 **Shopping Cart** - Add multiple items with desired quantities
- 💵 **Smart Billing** - Automatic bill generation with itemized breakdown
- 🎁 **Discount System** - Tiered discounts based on cart value
  - ₹200 off for purchases above ₹1,500
  - ₹500 off for purchases above ₹3,000
- 🧾 **GST Calculation** - Automatic CGST (4%) and SGST (4%) calculation
- ⚠️ **Stock Validation** - Real-time stock availability checking

## 🏗️ System Architecture

```
SuperMarket System
├── User Interface Layer
│   └── Console-based interaction
├── Business Logic Layer
│   ├── Administrator Module
│   ├── Customer Module
│   └── Shopping Cart Logic
└── Data Access Layer
    └── MySQL Database Connection
```

## 🔧 Prerequisites

Before running this application, ensure you have:

- **Java Development Kit (JDK)** 11 or higher
- **MySQL Server** 8.0 or higher
- **MySQL Connector/J** (JDBC Driver)
- **IDE** (Eclipse, IntelliJ IDEA, or NetBeans recommended)

## 📥 Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/Logicrithm/SuperMarket.git
cd SuperMarket/Project_Supermarket
```

### Step 2: Download MySQL Connector
Download the MySQL JDBC driver from [MySQL Official Website](https://dev.mysql.com/downloads/connector/j/) and add it to your project's classpath.

### Step 3: Configure Database Connection
1. Open `ConnectDB.java`
2. Update the following credentials:
```java
String url = "jdbc:mysql://localhost:3306/mydatabase";
String username = "your_mysql_username";
String password = "your_mysql_password";
```

## 🗄️ Database Setup

### Create Database and Table

```sql
-- Create database
CREATE DATABASE mydatabase;
USE mydatabase;

-- Create Shop table
CREATE TABLE Shop (
    ItemId INT PRIMARY KEY,
    Item VARCHAR(100) NOT NULL,
    Cost INT NOT NULL,
    Quantity INT NOT NULL
);

-- Insert sample data
INSERT INTO Shop (ItemId, Item, Cost, Quantity) VALUES
(101, 'Rice', 50, 100),
(102, 'Wheat', 40, 150),
(103, 'Sugar', 45, 80),
(104, 'Oil', 120, 50),
(105, 'Salt', 20, 200);
```

## 🚀 Usage

### Compile the Project
```bash
javac *.java
```

### Run the Application
```bash
java ShoppingApp
```

### Administrator Access
1. Select "Administrator" when prompted
2. Enter password: `1111`
3. Choose operation:
   - **Insert**: Add new products
   - **Cost Update**: Modify product prices
   - **Quantity Update**: Update stock levels

### Customer Access
1. Select "Customer" when prompted
2. Browse available products
3. Add items to cart (type product name and quantity)
4. Type "exit" to proceed to billing
5. View itemized bill with discounts and taxes

## 📁 Project Structure

```
Project_Supermarket/
├── ShoppingApp.java        # Main application entry point
├── Administrator.java      # Admin functionality
├── Customer.java          # Customer operations and billing
├── ConnectDB.java         # Database connection and operations
├── DBConnect.java         # Database connection test class
└── README.md             # Project documentation
```

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java** | Core programming language |
| **MySQL** | Database management |
| **JDBC** | Database connectivity |
| **Scanner** | User input handling |

## 📈 Future Enhancements

- [ ] **GUI Implementation** - JavaFX/Swing interface
- [ ] **User Authentication** - Customer login system
- [ ] **Sales Reports** - Generate daily/monthly reports
- [ ] **Invoice Generation** - PDF receipt generation
- [ ] **Payment Integration** - Multiple payment methods
- [ ] **Product Categories** - Organize items by category
- [ ] **Search Functionality** - Search products by name/category
- [ ] **Barcode Scanning** - Quick product lookup
- [ ] **Employee Management** - Staff role management
- [ ] **Security Improvements** - Password encryption, prepared statements

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit changes (`git commit -m 'Add YourFeature'`)
4. Push to branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

## 👥 Authors

**Logicrithm**
- GitHub: [@Logicrithm](https://github.com/Logicrithm)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact & Support

For issues, questions, or suggestions:
- Open an issue on GitHub
- Contact: [Your Email]

## 🙏 Acknowledgments

- MySQL Documentation
- Java Documentation
- Open Source Community

---

**Note**: This is an educational project demonstrating basic inventory and billing management. For production use, implement additional security measures and error handling.

**Version**: 1.0.0  
**Last Updated**: November 2025
