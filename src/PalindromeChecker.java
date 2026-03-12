public class PalindromeChecker
{
    public static void uc9_RecursiveMethod() {

        String input = "racecar";

        boolean isPalindrome = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("UC9 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }
    public static void main(String [] args)
    {
        uc9_RecursiveMethod();
    }
}