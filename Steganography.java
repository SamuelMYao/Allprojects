import javax.swing.JOptionPane;

// Moye Yao, Programmer
public class Steganography {
    public static void main(String args[]) {
        // The plaintext message
        String line1 = "Hello Stan and Marilyn!";
        String line2 = "Let us meet for lunch";
        String line3 = "at noon on Tuesday.";
        String line4 = "We will be waiting";
        String line5 = "at the East building of";
        String line6 = "train station C.";
        String line7 = "I will ask Hank, Quincy,";
        String line8 = "Denise, Eddy and Roni";
        String line9 = "to join us there!";
        String line10 = "Best Regards,";
        String line11 = "KZ";
        String message = "\n";

        // Display the plaintext message
        message += "\t" + line1 + "\n";
        message += "\t" + line2 + "\n";
        message += "\t" + line3 + "\n";
        message += "\t" + line4 + "\n";
        message += "\t" + line5 + "\n";
        message += "\t" + line6 + "\n";
        message += "\t" + line7 + "\n";
        message += "\t" + line8 + "\n";
        message += "\t" + line9 + "\n";
        message += "\t" + line10 + "\n";
        message += "\t" + line11 + "\n";

        JOptionPane.showMessageDialog(null, "Message: " + message, "Plaintext Message", JOptionPane.PLAIN_MESSAGE);

        // Convert plaintext message to lower case
        line1 = line1.toLowerCase();
        line2 = line2.toLowerCase();
        line3 = line3.toLowerCase();
        line4 = line4.toLowerCase();
        line5 = line5.toLowerCase();
        line6 = line6.toLowerCase();
        line7 = line7.toLowerCase();
        line8 = line8.toLowerCase();
        line9 = line9.toLowerCase();
        line10 = line10.toLowerCase();
        line11 = line11.toLowerCase();

        String plaintext = "\n";
        plaintext += "\t" + line1 + "\n";
        plaintext += "\t" + line2 + "\n";
        plaintext += "\t" + line3 + "\n";
        plaintext += "\t" + line4 + "\n";
        plaintext += "\t" + line5 + "\n";
        plaintext += "\t" + line6 + "\n";
        plaintext += "\t" + line7 + "\n";
        plaintext += "\t" + line8 + "\n";
        plaintext += "\t" + line9 + "\n";
        plaintext += "\t" + line10 + "\n";
        plaintext += "\t" + line11 + "\n";

        JOptionPane.showMessageDialog(null, "Message (lower case): " + plaintext, "Lower Case", JOptionPane.PLAIN_MESSAGE);

        // Define the key variable and message object
        StringBuilder s = new StringBuilder();

        try {
            // Build the secret message
            s.append("\n"); // new line
            s.append(getCharAt(line1, 7));  // s
            s.append(getCharAt(line1, 18)); // i
            s.append(getCharAt(line2, 7));  // m
            s.append(getCharAt(line2, 8));  // e
            s.append(" ");                  // space
            s.append(getCharAt(line3, 1));  // t
            s.append(getCharAt(line3, 5));  // o
            s.append(" ");                  // space
            s.append(getCharAt(line4, 5));  // l
            s.append(getCharAt(line4, 12)); // a
            s.append(getCharAt(line5, 13)); // u
            s.append(getCharAt(line5, 18)); // n
            s.append(getCharAt(line6, 14)); // c
            s.append(getCharAt(line7, 11)); // h
            s.append("\n");                 // new line
            s.append(getCharAt(line8, 0));  // d
            s.append(getCharAt(line8, 1));  // e
            s.append(getCharAt(line8, 2));  // n
            s.append(getCharAt(line8, 3));  // i
            s.append(getCharAt(line8, 4));  // s
            s.append(" ");                  // space
            s.append(getCharAt(line8, 7));  // e
            s.append(getCharAt(line9, 2));  // t
            s.append(getCharAt(line10, 0)); // b
            s.append(getCharAt(line10, 5)); // r
            s.append(getCharAt(line11, 0)); // k
            s.append(getCharAt(line11, 1)); // z
            s.append("\n");                 // new line
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while building the secret message: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Display the lengths of the messages
        String lengths = "Length of plaintext message: " + (line1.length() + line2.length() + line3.length() + line4.length() + line5.length() + line6.length() + line7.length() + line8.length() + line9.length() + line10.length() + line11.length()) +
                         "\nLength of decoded message: " + s.length();

        JOptionPane.showMessageDialog(null, lengths, "Message Lengths", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("A steganography secret: " + s);
        JOptionPane.showMessageDialog(null, "Secret Message: " + s, "Decoded", JOptionPane.PLAIN_MESSAGE);

        // Additional secret message creation
        StringBuilder newSecret = new StringBuilder();
        newSecret.append("\n"); // new line
        newSecret.append(getCharAt(line1, 0));  // h
        newSecret.append(getCharAt(line2, 2));  // t
        newSecret.append(getCharAt(line3, 0));  // a
        newSecret.append(getCharAt(line4, 0));  // w
        newSecret.append(getCharAt(line5, 0));  // a
        newSecret.append(getCharAt(line6, 0));  // t
        newSecret.append("\n");                 // new line

        JOptionPane.showMessageDialog(null, "New Secret Message: " + newSecret, "New Secret", JOptionPane.PLAIN_MESSAGE);
    }

    // Helper method to safely get character at a given index
    private static char getCharAt(String line, int index) {
        if (index < line.length()) {
            return line.charAt(index);
        } else {
            return ' ';
        }
    }
}
