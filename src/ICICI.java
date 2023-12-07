import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ICICI implements RBI {


    HashMap<String,Float> map = new HashMap<>();
    BufferedReader buff;
    InputStreamReader isr;

    float balance = 1000.0f;
    int counter = 0;

    public float deposit = 0.0f;
    float withdraw = 0.0f;

    float amount = 0.0f;
    float ROI = 6.2f;


    int years = 0;

    float fd = 0.0f;
    float loan = 0.0f;
    public ICICI(BufferedReader buff, InputStreamReader isr) {
        // Constructor if needed

        this.buff = buff;
        this.isr = isr;
    }

    @Override
    public void depositMoney(float deposit) {
        this.deposit = deposit;
        balance += deposit;
        System.out.println("your balance right now is   ");
        System.out.println(balance);
    }

    @Override
    public void withdrawMoney(float withdraw) {
        if(balance > 1000) {
            counter++;
            this.withdraw = withdraw;
            balance -= withdraw;
            if (counter > 3) {
                balance -= 0.01 * withdraw;
            }

            System.out.println("The remaining balance is " + balance);
            System.out.println("The current counter " + counter);
        }
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
    float minbal = 1000.0F;
   // if(2 * minbal <= balance) {
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

        float bankprofit = amount - loan;

        System.out.println("the amount of interest ICICI needs to give RBI is " + (bankprofit - (0.01F * bankprofit)));




    }
   // }

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


}
