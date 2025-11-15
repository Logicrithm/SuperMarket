import java.util.Scanner;

class Customer {
    String name;
    int bill[] = new int[50];
    
    String prd[] = new String[50];
    int qty[] = new int[50];
    int i = 0;
    ConnectDB cdb = new ConnectDB();

    Customer() {
        name = "";
    }

    void menu() {
        cdb.viewInventoryData();
        System.out.println("Here's an offer for you:\n  i)If the cart value is above 1500 you will get RS-200 discount\n  ii)If cart value is above 3000 you will get Rs-500 discount");
    }

    void cart() {
        Scanner in = new Scanner(System.in);
        String s;
        i = 0;
        while (true) {
            System.out.println("Enter the Item");
            s = in.next();
            
            if (s.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Enter its quantity");
                int g = in.nextInt();
                String r[] = cdb.findProduct(s);
                if (g > Integer.parseInt(r[3]) && Integer.parseInt(r[3]) != 0) {
                    System.out.println("Item Insufficient");
                } else if (g > Integer.parseInt(r[3]) && Integer.parseInt(r[3]) == 0) {
                    System.out.println("Item out of stock");
                } else {
                    prd[i] = s;
                    qty[i++] = g;
                }
            }
        }
    }

    void bill() {
        int c = i - 1;
        while (c >= 0) {
            String r[] = cdb.findProduct(prd[c]);
            bill[c] = (Integer.parseInt(r[2])) * (qty[c]);
            cdb.update(Integer.parseInt(r[0]), r[1], Integer.parseInt(r[2]), Integer.parseInt(r[3]) - qty[c]);
            c--;
        }
    }

    void billDisplay() {
        double bil = 0.00;
        System.out.println("------YOUR BILL------\n");
        System.out.println("Item                 Quantity                Cost");
        for (int j = 0; j < i; j++) {
            bil = bil + bill[j];
            System.out.println(prd[j] + "             " + qty[j] + "            " + bill[j]);
        }
        double cgst=bil*0.04;
        double sgst=bil*0.04;
        System.out.println("CGST     :"+cgst);
        System.out.println("SGST     :"+sgst);
        if(bil>1500&&bil<3000)
        {
        bil=bil-200;
        System.out.println("Discount of 200");
        }
        else if(bil>3000)
        {
        bil=bil-500;
        System.out.println("Discount of 500");
      }
       System.out.println("Total Bill--->"+(bil+cgst+sgst));
    }
}
