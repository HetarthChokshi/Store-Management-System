import java.util.*;

class Login_required
{
    Scanner sc=new Scanner(System.in);
    int password=1234,pass_input,new_pass;String new_pass1;boolean valid=true;

     void Login(){
         while(valid){
         System.out.print("Enter Password: ");
         pass_input=sc.nextInt();
             if(pass_input==password) {
                 System.out.println("Login Successful!");
                 System.out.println();
                 valid = false;
             }
             else{
                System.out.println("Login Unsuccessful!");
             }
         }
     }

     void Reset_pass(){
         boolean valid1=true;
         while(valid1){
             System.out.print("Enter your new password : ");
             new_pass=sc.nextInt();
             password=new_pass;
             valid1=false;

        }
     }
}

class Store
{
    int flag=0;
    Scanner sc=new Scanner(System.in);
    String Item_name; int Item_code,quantity; double rate;


    void Add_items()
    {
        System.out.print("Enter Product Name: "); Item_name=sc.nextLine();
        System.out.print("Enter Product Code: "); Item_code=sc.nextInt();
        System.out.print("Enter Product Price: "); rate=sc.nextDouble();
        System.out.print("Enter Product Quantity: "); quantity=sc.nextInt();
        System.out.println();
    }

    void search(String name)
    {
        if(name.equals(Item_name))
        {
            System.out.println("Product Name ="+Item_name);
            System.out.println("Product Code ="+Item_code);
            System.out.println("Product Price ="+rate);
            System.out.println("Product Quantity ="+quantity); flag=1;
        }


    }

    void search(int code)
    {
        if(code==Item_code)
        {
            System.out.println("Product Name ="+Item_name);
            System.out.println("Product Code ="+Item_code);
            System.out.println("Product Price ="+rate);
            System.out.println("Product Quantity ="+quantity);
            flag=1;
        }

    }

    void search(double rate1)
    {
        if(rate1==rate)
        {
            System.out.println("Product Name ="+Item_name);
            System.out.println("Product Code ="+Item_code);
            System.out.println("Product Price ="+rate);
            System.out.println("Product Quantity ="+quantity); flag=1;
        }

    }

    void edit(int  code1)
    {
        if(code1==Item_code){
            System.out.println("Product Name ="); String name1=sc.nextLine();
            System.out.println("Product Code ="); int code2=sc.nextInt();
            System.out.println("Product Price ="); double rate1=sc.nextDouble();
            System.out.println("Product Quantity ="); int quant=sc.nextInt();
            Item_name=name1; Item_code=code2; rate=rate1; quantity=quant;

        }
    }


}




class Store_management_system
{
        public static void main(String []args)
        {
            boolean main_loop=true,main_loop1=true; int choice,i;
            Scanner sc=new Scanner(System.in);
            Store store[]=new Store[100];
            for(i=0;i<store.length;i++)
            {
                store[i]=new Store();
            }
           // System.out.println("----->> Welcome To Store Management System <<-----");
            Login_required log=new Login_required();
            while(main_loop1) {
                System.out.println("----->> Welcome To Store Management System <<-----");
                System.out.println("<< HOME >>");
                System.out.println("1.Sign in  ");
                System.out.println("2.Exit ");
                System.out.println();
                System.out.println("Enter your choice:");
                int action = sc.nextInt();
                switch (action) {
                    case 1:
                        log.Login();
                        break;
                    case 2:
                        System.out.println("");
                        main_loop1 = false;
                        break;
                    default:
                        System.out.println("Enter valid Choice");
                }

                while (main_loop) {
                    System.out.println("<< MAIN SYSTEM MENU >>");
                    System.out.println();
                    System.out.println("1.Add Items     :");
                    System.out.println("2.Edit Items    :");
                    System.out.println("3.Search Items  :");
                    System.out.println("4.Display Items :");
                    System.out.println("5.Reset Password: ");
                    System.out.println("6.Log out       :");
                    System.out.println();
                    System.out.print("Enter Your Choice : ");
                    choice = sc.nextInt();
                    int items=0;
                     int search=3;
                    switch (choice) {
                        case 1:
                            System.out.println("<< ADD ITEMS >>");
                            System.out.print("Enter how many Items you want to add :");
                             items=sc.nextInt(); search=items;

                            for(i=0;i<items;i++)
                            {

                                store[i].Add_items();

                            }sc.nextLine();

                            System.out.print(">>>");String enter=sc.nextLine();
                            System.out.println();
                            break;
                        case 2:
                            System.out.print("<< EDIT ITEMS >>");
                            System.out.print("Enter Product Code: "); int code1=sc.nextInt();
                            for(i=0;i<items;i++){
                                store[i].edit(code1);
                            }sc.nextLine();

                            System.out.print(">>>");String enter5=sc.nextLine();
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("<< SEARCH >>");
                            System.out.println("1. Search by Name");
                            System.out.println("2. Search by Product Code");
                            System.out.println("3. Search by Rate");
                            System.out.println();
                            System.out.print("Enter NO:"); int no=sc.nextInt(); sc.nextLine();
                            switch(no){
                                case 1:
                                    System.out.print("Enter Name : ");
                                    String search_input1=sc.nextLine(); int count=0;
                                    for(i=0;i< store.length;i++)
                                    {
                                        store[i].search(search_input1); count++;
                                    }sc.nextLine();
                                    System.out.print(">>>");String enter1=sc.nextLine();
                                    System.out.println();break;
                                case 2:
                                    System.out.print("Enter Code : ");
                                    int search_input2=sc.nextInt();

                                    for(i=0;i<items;i++)
                                    {
                                        store[i].search(search_input2);
                                    } sc.nextLine();
                                    System.out.print(">>>");String enter2=sc.nextLine();
                                    System.out.println();break;
                                case 3:
                                    System.out.print("Enter Price : ");
                                    Double search_input3=sc.nextDouble();

                                    for(i=0;i<items;i++)
                                    {
                                        store[i].search(search_input3);
                                    }sc.nextLine();
                                    System.out.print(">>>");String enter4=sc.nextLine();
                                    System.out.println();
                                    break;
                                default: break;
                            }
                            break;

                        case 4:
                        case 5:
                            log.Reset_pass();
                            break;
                        case 6:
                            System.out.println("You are Logged out!");
                            main_loop = false;
                            break;
                        default:
                            System.out.println("Enter valid Choice");
                            break;
                    }

                }

            }
        }
}
  