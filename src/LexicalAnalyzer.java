import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HT\\OneDrive\\Desktop\\FilingHelpFiles\\InventoryItem.java";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    analyzeToken(token, lineNumber);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeToken(String token, int lineNumber) {
        String[] keywords = {"if", "else", "while", "for", "int", "float", "double", "char", "void", "return"};
        String[] symbols = {"{", "}", "(", ")", "[", "]", ";", ",", "=", "==", "+", "-", "*", "/", "<", ">", "<=", ">=", "!="};

        for (String keyword : keywords) {
            if (token.equals(keyword)) {
                System.out.println("Token: KEYWORD, Lexeme: " + token + ", Line: " + lineNumber);
                return;
            }
        }

        for (String symbol : symbols) {
            if (token.equals(symbol)) {
                System.out.println("Token: SYMBOL, Lexeme: " + token + ", Line: " + lineNumber);
                return;
            }
        }

        if (token.matches("[a-zA-Z]+")) {
            System.out.println("Token: IDENTIFIER, Lexeme: " + token + ", Line: " + lineNumber);
        } else if (token.matches("[0-9]+")) {
            System.out.println("Token: NUMBER, Lexeme: " + token + ", Line: " + lineNumber);
        } else {
            System.out.println("Token: UNKNOWN, Lexeme: " + token + ", Line: " + lineNumber);
        }
    }
}
