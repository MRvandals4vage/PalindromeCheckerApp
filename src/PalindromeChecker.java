import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {
    public static boolean isPalindromeUsingStack(String str) {
        Stack<Character> stack = new Stack();
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < str.length(); ++i) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != (Character) stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        boolean result = false;
        result = isPalindromeUsingStack(input);
        if (result) {
            System.out.println("Result: The string IS a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }

}