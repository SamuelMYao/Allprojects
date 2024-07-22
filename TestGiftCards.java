import javax.swing.JOptionPane;

public class TestGiftCards {
    public static void main(String[] args) {
        // Prompt the user for initial values
        String holderName = JOptionPane.showInputDialog(null, "Enter gift card holder's name: ");
        String strCardNum = JOptionPane.showInputDialog(null, "Enter gift card number: ");
        int cardNum = Integer.parseInt(strCardNum);
        String strInitialBalance = JOptionPane.showInputDialog(null, "Enter initial gift card balance: ");
        double initialBalance = Double.parseDouble(strInitialBalance);
        char cardType = 'R'; // Example: 'R' for Regular

        // Create a GiftCards object using the constructor with all parameters
        GiftCards gc = new GiftCards(holderName, initialBalance, cardNum, true, cardType);

        // Display opening message
        String message = "Welcome";
        JOptionPane.showMessageDialog(null, "Message: " + message, "Message", JOptionPane.PLAIN_MESSAGE);

        // Issue the gift card
        gc.issueGiftCard();

        // Use the gift card
        String strUseAmount = JOptionPane.showInputDialog(null, "Enter amount to deduct from card: ");
        double useAmount = Double.parseDouble(strUseAmount);

        // Check if enough balance to deduct
        if (useAmount > gc.getBalance()) {
            JOptionPane.showMessageDialog(null, "Insufficient balance. Transaction canceled.");
        } else {
            // Deduct amount from the card
            gc.setBalance(gc.getBalance() - useAmount);

            // Print the current card balance
            gc.printCurrentGiftCardInfo(useAmount);
        }
    }
}
