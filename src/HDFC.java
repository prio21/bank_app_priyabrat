import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class HDFC implements RBI{



    // 8 - 12 - 2023 // the map implementation

    HashMap<String,Float> cusMap = new HashMap<>(); // name of cus and the balance
    ArrayList<Customer> cusList = new ArrayList<>();
    ArrayList<String> cusListAdhar = new ArrayList<>();
    BufferedReader buff;
    InputStreamReader isr;

    HashMap<String,Float> map = new HashMap<>();
    float balance = 0.0f; // this is banks balance
    int counter = 0;

    float deposit = 0.0f;
    float withdraw = 0.0f;

    float amount = 0.0f;
    float ROI = 6.2f;
    int years = 0;

    float fd = 0.0f;
    float loan = 0.0f;
    public HDFC(BufferedReader buff, InputStreamReader isr) {
        // Constructor if needed

        this.buff = buff;
        this.isr = isr;
    }
    @Override
    public void depositMoney(float deposit) {
        this.deposit = deposit;
        balance += deposit;
    }

    @Override
    public void withdrawMoney(float withdraw) {
        this.withdraw = withdraw;
        balance -= withdraw;
        if (counter > 3) {
            balance -= 0.01 * withdraw;
        }

        System.out.println("The remaining balance is " + balance);
    }

    @Override
    public void openFD(float amount, int years) {
        this.amount = amount;
        this.fd = amount;
        for (int i = 0; i < years; i++) {
            amount = amount + (ROI / 100 * amount);
        }
        System.out.println("Your profit on FD of " + fd);
        System.out.println(amount - fd);
    }

    @Override
    public void applyLoan(String loanType, float amount, int years) {
        map.put("home loan", 6.5F);
        map.put("education loan", 4.5F);
        map.put("car loan", 7.5F);
        map.put("personal loan", 6.5F);


        this.amount = amount;
        this.years = years;
        this.loan = amount;
        for (int i = 0; i < years; i++) {
            amount = amount + (map.get(loanType) / 100 * amount);
        }
        System.out.println("Your interest on loan of " + loanType + "is:   ");
        System.out.println(amount - loan);
    }

    @Override
    public void applyCreditCard() {
        // Implementation for applying a credit card in ICICI
        if(balance > 2 * amount) {
            System.out.println("you are eligible for credit card");

        }else {
            System.out.println("your are not eligible for credit card");
        }
    }

    @Override
    public float getBalance() {
        return balance;
    }
    @Override
    public void gettallcus() {
        for(Customer element : cusList){
            System.out.println(element.customerName);
        }
    }

    @Override
    public void setCus(Customer c) {

        for(int i = 0 ; i<cusList.size(); i++) {
            boolean flag = false;
            Customer mCustomer = cusList.get(i);
            if(mCustomer.getCustomerAadhar().equalsIgnoreCase(c.getCustomerAadhar())) { // adhar
                flag=true;
            }
            if( !flag ) {
                cusList.add(c);
            }
        }

//        if(!cusList.contains(c.dgged) ){
//            cusListAdhar.add(c.getCustomerAadhar());
//            cusList.add(c);
//        }

    }
}
// array list --> customer //  cuslist.contains(c.)