import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeService service = new PalindromeService();
        boolean result = service.checkPalindrome(input);

        System.out.println("Result: " + (result ? "Palindrome ✅" : "Not a Palindrome ❌"));

        sc.close();
    }
}

class PalindromeService {

    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (stack.pop() != input.charAt(i)) return false;
        }
        return true;
    }
}