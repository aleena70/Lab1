package Lab1;
import java.util.Scanner;

public class CCV {
    private String ccno;

    // Constructor to initialize credit card number
    public CCV(String ccno) {
        this.ccno = ccno;
    }

    // Method to validate the credit card number
    public void validate() 
    {
        if (ccno.length() < 8 || ccno.length() > 9) {
            System.out.println("Invalid credit card number");
            return;
        }

        // Step a: Remove the last digit
        char lastChar = ccno.charAt(ccno.length() - 1);
        int lastDigit = lastChar - '0'; // Convert char to int
        String remainingDigits = ccno.substring(0, ccno.length() - 1);

        // Step b: Reverse the remaining digits
        String reversedDigits = "";
        for (int i = remainingDigits.length() - 1; i >= 0; i--) {
            reversedDigits += remainingDigits.charAt(i);
        }

        // Step c: Double the digits at odd positions (1-indexed)
        int sum = 0;
        for (int i = 0; i < reversedDigits.length(); i++) {
            int digit = reversedDigits.charAt(i) - '0'; // Convert char to int
            // Double the digit if it's in an odd position (1-indexed)
            if (i % 2 == 0) {
                digit *= 2;
                // Add the digits of the result if it's a double-digit number
                if (digit > 9) {
                    sum += (digit / 10) + (digit % 10);
                } else {
                    sum += digit;
                }
            } else {
                sum += digit; // Directly add even-positioned digits
            }
        }

        // Step e: Calculate the value to compare
        int result = 10 - (sum % 10);

        // Step f: Compare result with last digit
        if (result == lastDigit) {
            System.out.println("Credit card number is valid.");
        } else {
            System.out.println("Credit card number is invalid.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String ccNumber = scanner.nextLine();

        // Create an instance of SimpleCreditCardValidator
        CCV validator = new CCV(ccNumber);
        validator.validate();

        scanner.close();
    }
}