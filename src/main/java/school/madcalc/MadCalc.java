
package school.madcalc;
import java.util.Scanner;

public class MadCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Mad Calc!");
        System.out.println("Enter a mathematical expression (with parentheses), 'sqrt <number>', 'pow2 <number>', 'cube <number>', or type 'exit' to quit:");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.trim().equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
                        } else if (input.trim().toLowerCase().startsWith("sqrt ")) {
                            try {
                                double result = calculateSquareRoot(input.trim().substring(5));
                                System.out.println("🎉 The answer is: " + result);
                            } catch (NumberFormatException e) {
                                System.out.println("Oops! 'sqrt' needs a number. Please try again with 'sqrt <number>'.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("I can only calculate the square root of positive numbers!");
                            }
                        } else if (input.trim().toLowerCase().startsWith("pow2 ")) {
                            try {
                                double result = calculatePowerOfTwo(input.trim().substring(5));
                                System.out.println("🎉 The answer is: " + result);
                            } catch (NumberFormatException e) {
                                System.out.println("Oops! 'pow2' needs a number. Please try again with 'pow2 <number>'.");
                            }
                        } else if (input.trim().toLowerCase().startsWith("cube ")) {
                            try {
                                double result = calculateCube(input.trim().substring(5));
                                System.out.println("🎉 The answer is: " + result);
                            } catch (NumberFormatException e) {
                                System.out.println("Oops! 'cube' needs a number. Please try again with 'cube <number>'.");
                            }
                        }
                        else {
                            try {
                                double result = evaluate(input);
                                System.out.println("🎉 The answer is: " + result);
                            } catch (RuntimeException e) {
                                String msg = e.getMessage();
                                if (msg != null && msg.contains("Mismatched parentheses")) {
                                    System.out.println("Oops! Your parentheses don't match. Please check and try again.");
                                } else if (msg != null && msg.contains("Unexpected")) {
                                    System.out.println("Hmm, I see something I don't understand. Please use only numbers, +, -, *, /, parentheses, square root (sqrt), power of two (pow2), and cube (cube) operations.");
                                } else {
                                    System.out.println("Oops! That doesn't look like a valid expression. Please try again.");
                                }
                            } catch (Exception e) {
                                System.out.println("Oops! That doesn't look like a valid expression. Please try again.");
                            }
                        }
                    }
        scanner.close();
    }

    // Expression evaluator supporting +, -, *, /, parentheses, and order of operations
    // Uses recursive descent parsing
    private static double evaluate(String expr) {
        return new Parser(expr).parse();
    }

    // Inner parser class
    private static class Parser {
        private final String input;
        private int pos = -1, ch;

        Parser(String input) {
            this.input = input.replaceAll("\\s+", "");
            nextChar();
        }

        void nextChar() {
            ch = (++pos < input.length()) ? input.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        double parse() {
            double x = parseExpression();
            if (pos < input.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        // Grammar:
        // expression = term | expression `+` term | expression `-` term
        // term = factor | term `*` factor | term `/` factor
        // factor = `+` factor | `-` factor | number | `(` expression `)`
        double parseExpression() {
            double x = parseTerm();
            while (true) {
                if (eat('+')) x += parseTerm();
                else if (eat('-')) x -= parseTerm();
                else return x;
            }
        }

        double parseTerm() {
            double x = parseFactor();
            while (true) {
                if (eat('*')) x *= parseFactor();
                else if (eat('/')) x /= parseFactor();
                else return x;
            }
        }

        double parseFactor() {
            if (eat('+')) return parseFactor(); // unary plus
            if (eat('-')) return -parseFactor(); // unary minus

            double x;
            int startPos = this.pos;
            if (eat('(')) { // parentheses
                x = parseExpression();
                if (!eat(')')) throw new RuntimeException("Mismatched parentheses");
            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(input.substring(startPos, this.pos));
            } else {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }
            return x;
        }
    }

    private static double calculateSquareRoot(String numberStr) {
        double num = Double.parseDouble(numberStr.trim());
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    private static double calculatePowerOfTwo(String numberStr) {
        double num = Double.parseDouble(numberStr.trim());
        return num * num;
    }

    private static double calculateCube(String numberStr) {
        double num = Double.parseDouble(numberStr.trim());
        return num * num * num;
    }
}