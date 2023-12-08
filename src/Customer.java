import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    String customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone;
    float balance;
    BufferedReader buff;
    InputStreamReader isr;

    // 8 - 12 - 23 //

    HashMap<String,Float> customerBankAndBalance = new HashMap<>(); // banks -- > balance in that


    public Customer() {
    }

    public Customer(String customerName, String customerEmail, String customerAddress, String customerGender, String customerAadhar, String customerPhone, float balance) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
        this.customerAadhar = customerAadhar;
        this.customerPhone = customerPhone;
        this.balance = balance;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAadhar() {
        return customerAadhar;
    }

    public void setCustomerAadhar(String customerAadhar) {
        this.customerAadhar = customerAadhar;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public BufferedReader getBuff() {
        return buff;
    }

    public void setBuff(BufferedReader buff) {
        this.buff = buff;
    }

    public InputStreamReader getIsr() {
        return isr;
    }

    public void setIsr(InputStreamReader isr) {
        this.isr = isr;
    }

    public void totalBank(){
        System.out.println(customerBankAndBalance.size()); // gives the bank and corresponding balnce associated to it
        // contd the function
        for(Map.Entry<String,Float> entry : customerBankAndBalance.entrySet()){
            String key = entry.getKey();
            Float val = entry.getValue();
            System.out.println("Bank_Name: " + key + "  Bank_balance: " + val);

        }
    }
}