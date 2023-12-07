import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
public class Main { // for main to use as an obj we have created it as class

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
    public static void main(String[] args) {
        Main obj = new Main(); // once initialise
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);





       Customer cus = new Customer();
       System.out.println("Enter your name");
        try {
            cus.customerName = obj.buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cus.setCustomerName(cus.customerName);


//        ici ici = new ici(obj.buff,obj.isr);


        switch (obj.selectedBank) {

            case 1 : obj.objbank   = new ICICI(obj.buff,obj.isr); //obj.objbankl is used cause it is non static so using main class obj
                break;

            case 2: obj.objbank = new HDFC(obj.buff,obj.isr);
                    break;


        }



        boolean bl = true;
        while(bl){
            System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");
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
                        obj.objbank.depositMoney(deposit);
                    }
                    catch(IOException e){
                        throw  new RuntimeException();
                    }

                    break;
                case 2 : System.out.println("how much you want to withdraw");
                    try {
                        float  withdraw = Float.parseFloat(obj.buff.readLine());
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
                case 4 : System.out.println("how much you want to take a loan ");
                    try{

                        float amount = Float.parseFloat(obj.buff.readLine());
                        int years = Integer.parseInt(obj.buff.readLine());
                        obj.objbank.applyLoan("",amount, years);
                    }catch(IOException e){
                        throw  new RuntimeException();
                    }
                    break;
                default: bl = false;

            }

        }



    }
}


// runtime poly -- > rbi r = new HDFC new ICICI
// instance method if(obj istance of ICICI)