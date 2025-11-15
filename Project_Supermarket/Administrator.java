import java.util.*; 
class Administrator {
     private int pass;
     ConnectDB cdb=new ConnectDB();
     Administrator()
     {
         pass=0;
     }
     boolean grand(int pass)
     {
         this.pass=pass;
         if(pass==1111)
         {
             System.out.println("Access Granted...");
             return true;
         }
         else
         return false;
     }
     void insert()
     {
         Scanner in2=new Scanner(System.in);
         System.out.println("Enter the Item,Item Id,Cost,Quantity");
         String it=in2.nextLine();  //Item name
         int id=in2.nextInt();      //item id
         int ct=in2.nextInt();      //item's cost
         int qt=in2.nextInt();      //item's quantity
         cdb.insertData(it,id,ct,qt);
         cdb.viewInventoryData();
     }
     void costUpate(String prd,int cst)
     {
         String r[]=cdb.findProduct(prd);

         cdb.update(Integer.parseInt(r[0]),r[1],cst,Integer.parseInt(r[3]));
         cdb.viewInventoryData();
     }
     void QuantityUpdate(String prd,int qnt)
     {
         String r[]=cdb.findProduct(prd);

         cdb.update(Integer.parseInt(r[0]),r[1],Integer.parseInt(r[2]),qnt);
         cdb.viewInventoryData();
     }
    
}