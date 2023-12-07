import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface RBI {

    float balance = 0.0f;
    int counter = 0;

    public float deposit = 0;
    float withdraw = 0.0f;

    float amount = 0.0f;
    float ROI = 1.0f;
    int years = 0;

//    float loanamount = 0.0f;
//    float loanROI = 0.0f;
//    int loanyears = 0;
    float fd = 0.0f;
    float loan = 0.0f;


//    public RBI(BufferedReader buff, InputStreamReader isr) {
//        this.buff = buff;
//        this.isr = isr;
//    }
    void depositMoney(float deposit);

    void withdrawMoney(float withdraw);

    void openFD(float amount,  int years);

    void applyLoan(String loanType, float amount,  int years);

    void applyCreditCard();

    float getBalance();
}
