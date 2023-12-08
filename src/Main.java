import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;

public class Main implements  Runnable { // for main to use as an obj we have created it as class


    ArrayList<Customer> cusArray = new ArrayList<>();
    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;
    

     RBI objbank = null; // not used Object class bcoz it is universal, RBI is an interface so can recognise the methods



//    public static void main(String[] args) {
//        Main obj = new Main(); // once initialise
//
//
//

    Main obj = null;  // instaNCE BANAKEN USE KRA HAI

    public static void main(String[] args) {
        Main obj1 = new Main();
        obj1.obj = obj1.getInstance(obj1);
        Thread mainThread = new Thread(obj1);
        mainThread.start();
    }

    public Main getInstance(Main obj) {
        return obj;
    }
    public void run(){




//        ici ici = new ici(obj.buff,obj.isr);




        System.out.println("Enter your name");

        Customer cus = new Customer();

        try {
            cus.customerName = obj.buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cus.setCustomerName(cus.customerName);

        System.out.println("Enter your adhar note: adhar should be unique"); // for the primary key

        try {
            cus.customerAadhar = obj.buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cus.setCustomerName(cus.customerAadhar);


        boolean bl = true;
        boolean newcus = false; // check if the new cus or old
        while(bl){


            if(newcus){
                cus = new Customer();
                System.out.println("Enter your name");
                try {
                    cus.customerName = obj.buff.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                cus.setCustomerName(cus.customerName);

                System.out.println("Enter your adhar note: adhar should be unique"); // for the primary key

                try {
                    cus.customerAadhar = obj.buff.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                cus.setCustomerName(cus.customerAadhar);


            }

            // this is the case for selecting the bank
            System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC\n see total customer");

            try {
                obj.selectedBank = Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected " + obj.selectedBank);

            switch (obj.selectedBank) {

                case 1 : obj.objbank   = new ICICI(obj.buff,obj.isr); //obj.objbankl is used cause it is non static so using main class obj
                    cus.customerBankAndBalance.put("ICICI",0F);


                    obj.objbank.setCus(cus);
                    break;

                case 2: obj.objbank = new HDFC(obj.buff,obj.isr);
                    cus.customerBankAndBalance.put("HDFC",0F);
                    obj.objbank.setCus(cus);
                    break;
                case 7: System.out.println("total customer available currently is : " + obj.cusArray.size());
                    break;
            }


            // if the user wants to have a look on how many people have an acc in the bank

            System.out.println("do you want to see how many people have acc on a particular bank ? ");
            int accOnBank;
            try {
                 accOnBank = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(accOnBank == 1) {
                System.out.println("the total customer of this bank is: " );
                obj.objbank.gettallcus();
            }

            boolean blopr = true;
            while(blopr){
                System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6. see total bank acc\n7. want to open a new acc in different bank\n8. want to quit\n ");
                try {
                    obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Customer Selected " + obj.selectedOperation);
                switch (obj.selectedOperation){
                    case 1: System.out.println("enter the money to deposit");
                        try {


                            float deposit = Float.parseFloat(obj.buff.readLine());
                            cus.balance += deposit;
                            obj.objbank.depositMoney(deposit);
                            System.out.println("this is the customer class balance "+ cus.balance);
                        }
                        catch(IOException e){
                            throw  new RuntimeException();
                        }

                        break;
                    case 2 : System.out.println("how much you want to withdraw");
                        try {
                            float  withdraw = Float.parseFloat(obj.buff.readLine());
                            cus.balance -= withdraw;
                            obj.objbank.withdrawMoney(withdraw);
                        }
                        catch(IOException e){
                            throw  new RuntimeException();
                        }
                        // obj.objbank.withdrawMoney(obj.objbank.withdraw);
                        break;

                    case 3 : System.out.println("how much you want to create a fd of");
                        try{

                            float amount = Float.parseFloat(obj.buff.readLine());
                            int years = Integer.parseInt(obj.buff.readLine());
                            obj.objbank.openFD(amount, years);

                        }catch(IOException e){
                            throw  new RuntimeException();
                        }
                        break;
                    case 4 : System.out.println("how much you want to take a loan, time in years, and type  ");
                        try{
                            HashMap<Integer,String> map = new HashMap<>();
                            map.put(1,"home loan");
                            map.put(2,"education loan");
                            map.put(3,"car loan");
                            map.put(4,"personal loan");
                            float amount = Float.parseFloat(obj.buff.readLine());
                            int years = Integer.parseInt(obj.buff.readLine());
                            int type = Integer.parseInt(obj.buff.readLine());
                            String loanType = map.get(type);
                            obj.objbank.applyLoan(loanType,amount, years);
                        }catch(IOException e){
                            throw  new RuntimeException();
                        }
                        break;

                    case 6: cus.totalBank();
                        break;

                    case 7: break;

                    case 8: {

                        obj.cusArray.add(cus);
                        newcus = true; // the curr cus wants to exit and new cus comes to play
                       blopr = false;
                        break;
                    }
                    default: blopr = false;

                }
            }


        }



    }
}


// runtime poly -- > rbi r = new HDFC new ICICI
// instance method if(obj istance of ICICI)