package Lab1;
import java.util.Scanner;
public class AlphabetWarGame {
    // Default strengths
    private int[] leftStrengths = {4, 3, 2, 1}; // 'w', 'p', 'b', 's'
    private int[] rightStrengths = {4, 3, 2, 1}; // 'm', 'q', 'd', 'z'
    private char[] leftLetters = {'w', 'p', 'b', 's'};
    private char[] rightLetters = {'m', 'q', 'd', 'z'};

    // Constructor with default strengths
    public AlphabetWarGame() {}


    // Method to determine winner with two words
    public String alphabetWar(String leftWord, String rightWord) {
        int leftScore = calculateScore(leftWord, leftLetters, leftStrengths);
        int rightScore = calculateScore(rightWord, rightLetters, rightStrengths);

        return determineWinner(leftScore, rightScore);
    }

    // Calculate score based on the letters and their strengths
    private int calculateScore(String word, char[] letters, int[] strengths) {
        int score = 0;
        for (char ch : word.toCharArray()) {
            for (int i = 0; i < letters.length; i++) {
                if (ch == letters[i]) {
                    score += strengths[i];
                }
            }
        }
        return score;
    }

    // Determine the winner based on the scores
    private String determineWinner(int leftScore, int rightScore) {
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlphabetWarGame game = new AlphabetWarGame();


        // Input for a two-word battle (left vs right)
        System.out.print("Enter the word for the left side: ");
        String leftWord = scanner.nextLine();
        System.out.print("Enter the word for the right side: ");
        String rightWord = scanner.nextLine();
        System.out.println(game.alphabetWar(leftWord, rightWord)); // Two-word battle

        scanner.close();
    }
}
