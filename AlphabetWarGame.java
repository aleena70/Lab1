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

    // Constructor with custom strengths
    public AlphabetWarGame(int[] leftStrengths, int[] rightStrengths) {
        this.leftStrengths = leftStrengths;
        this.rightStrengths = rightStrengths;
    }

    // Method to determine winner with one word
    public String alphabetWar(String word) {
        return alphabetWar(word, "");
    }

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
        AlphabetWarGame game = new AlphabetWarGame();

        System.out.println(game.alphabetWar("z")); // Right side wins!
        System.out.println(game.alphabetWar("zdqmwpbs")); // Let's fight again!
        System.out.println(game.alphabetWar("wwwwwwz")); // Left side wins!
    }
}