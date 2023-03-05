import java.io.*;
import java.util.*;

public class DN03 {
    public static void main(String[] args) {
        // Check if the correct number of arguments are given
        if (args.length != 3) {
            System.err.println("Usage: java DN03 <filename> <length> <seed>");
            System.exit(1);
        }

        String filename = args[0];
        int length = Integer.parseInt(args[1]);
        int seed = Integer.parseInt(args[2]);

        // Read the words from the file
        try (Scanner scanner = new Scanner(new File(filename))) {
            int numWords = scanner.nextInt();
            String[] words = new String[numWords];

            for (int i = 0; i < numWords; i++) {
                words[i] = scanner.next();
            }

            // Generate the random password
            Random random = new Random(seed);
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                // Select a random word from the table
                String word = words[random.nextInt(words.length)];

                // Select a random letter from the word
                char letter = word.charAt(random.nextInt(word.length()));

                // Append the letter to the password
                password.append(letter);
            }

            // Print the password
            System.out.println(password.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            System.exit(1);
        }
    }
}
