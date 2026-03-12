import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker
{public static void main(String[] args)
{
    uc7_DequeMethod();
}
    public static void uc7_DequeMethod() {

        String input = "refer";

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {

            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC7: Deque-Based Optimized Palindrome Checker");
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println();
    }}