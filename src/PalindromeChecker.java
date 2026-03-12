import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern for Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy:");
        System.out.println("1) Stack Strategy");
        System.out.println("2) Deque Strategy");
        System.out.print("Enter choice (1/2): ");
        String choice = sc.nextLine().trim();

        PalindromeStrategy strategy;
        if ("2".equals(choice)) {
            strategy = new DequeStrategy();
        } else {
            strategy = new StackStrategy();
        }

        boolean result = strategy.isPalindrome(input);

        System.out.println("Strategy Used: " + strategy.name());
        System.out.println("Result: " + (result ? "Palindrome ✅" : "Not a Palindrome ❌"));

        sc.close();
    }
}

interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String name();
}

class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
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

    @Override
    public String name() {
        return "StackStrategy";
    }
}

class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char back = deque.removeLast();
            if (front != back) return false;
        }
        return true;
    }

    @Override
    public String name() {
        return "DequeStrategy";
    }
}