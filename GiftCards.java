import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiftCards {
    static NumberFormat nf = NumberFormat.getCurrencyInstance();
    Date myDate = new Date();
    String myDateFormat = "MM/dd/yyyy";
    SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);

    private double balance;
    private int cardNum;
    private String holder;
    private boolean expires;
    private char cardType;

    // Default constructor
    public GiftCards() {
    }

    // Constructor with holder, balance, cardNum, expires, and cardType
    public GiftCards(String holder, double balance, int cardNum, boolean expires, char cardType) {
        this.holder = holder;
        this.balance = balance;
        this.cardNum = cardNum;
        this.expires = expires;
        this.cardType = cardType;
    }

    public void issueGiftCard() {
        System.out.println("[ Card Issued ]");
        System.out.println("Today's Date is: " + dtToday.format(myDate));
        System.out.println("Card Holder . . . " + holder);
        System.out.println("Card Number . . . " + cardNum);
        System.out.println("Card Amount . . . " + nf.format(balance));
        if (expires) {
            System.out.println("Expires on: " + calculateExpirationDate());
        }
        System.out.println("Card Type . . . " + cardType);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public boolean isExpires() {
        return expires;
    }

    public void setExpires(boolean expires) {
        this.expires = expires;
    }

    public char getCardType() {
        return cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    public void printCurrentGiftCardInfo(double spentAmount) {
        System.out.println("[ Card Balance ]");
        System.out.println("Today's Date is: " + dtToday.format(myDate));
        System.out.println("Spent . . . . " + nf.format(spentAmount));
        System.out.println("New Card Balance . . " + nf.format(balance));
    }

    private String calculateExpirationDate() {
        // Assuming expiration is 1 year from issue date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date expirationDate = new Date(myDate.getTime() + (365L * 24 * 60 * 60 * 1000));
        return sdf.format(expirationDate);
    }
}
