import java.util.Scanner;

class ShoppingApp
    {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Administrator admin = new Administrator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Shopping App!");
         System.out.println("Enter your domain\n Administrator    or     Customer");
            String h=scanner.next();
            int c=0;
            if(h.equalsIgnoreCase("administrator"))
            {
                 System.out.println("Enter Administrator password:");
               int password = scanner.nextInt();
                if (password==1111) 
                {
                // Perform admin tasks here
                System.out.println("What do want to do\n1)Insert\n2)Quantity Update\n3)Cost Update");
                String h1=scanner.next();
                
                    if(h1.equalsIgnoreCase("insert"))
                  {
                    System.out.println("Enter no quantities to update");
                    
                    c=scanner.nextInt();
                    
                    while(c!=0)
                    {
                        admin.insert();
                        c--;
                    }
                    
                  }
                    else if(h1.equalsIgnoreCase("Cost Update"))
                  {
                    System.out.println("Enter no quantities whose cost need to be updated");
                    c=scanner.nextInt();
                    
                                        
                    while(c!=0)
                    {
                        System.out.println("Enter Item name and updated cost");
                        String prd=scanner.nextLine();
                        int cst=scanner.nextInt();
                        admin.costUpate(prd,cst);
                        c--;
                    }
                    
                  }
                    else if(h1.equalsIgnoreCase("Quantity Update"))
                  {
                    System.out.println("Enter no quantities whose quantity need to be updated");
                    c=scanner.nextInt();
                    
                                        
                    while(c!=0)
                    {
                    System.out.println("Enter Item name and updated quantity");
                    String prd=scanner.nextLine();
                    int qty=scanner.nextInt();
                    admin.QuantityUpdate(prd,qty); 
                    c--;
                    }// Update quantity of an item
                 }
                    else
                    System.out.println("Must enter valid input");
              } 
              else {
               System.out.println("Access Denied. Incorrect password.");   //incorrect password message
                }
            }
            else if(h.equalsIgnoreCase("customer"))
              {
                          customer.menu();
                          customer.cart();

        
                          customer.bill();
                          customer.billDisplay();
                  
                  
              }
            }
    }