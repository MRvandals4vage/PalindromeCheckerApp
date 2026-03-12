import java.util.Scanner;

public class PalindromeChecker {

    private static String normalize(String input) {
        if (input == null) return "";
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private static boolean isPalindromeTwoPointer(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String normalized = normalize(input);
        boolean result = isPalindromeTwoPointer(normalized);

        System.out.println("Normalized: " + normalized);
        System.out.println("Result: " + (result ? "Palindrome ✅" : "Not a Palindrome ❌"));

        sc.close();
    }
}