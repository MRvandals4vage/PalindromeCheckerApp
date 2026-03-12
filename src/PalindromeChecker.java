import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        List<BenchStrategy> strategies = new ArrayList<>();
        strategies.add(new StackBenchStrategy());
        strategies.add(new DequeBenchStrategy());
        strategies.add(new TwoPointerBenchStrategy());

        int iterations = 100000;

        System.out.printf("%-22s %-12s %-18s%n", "Algorithm", "Result", "Time (ns)");
        System.out.println("----------------------------------------------------------");

        for (BenchStrategy s : strategies) {

            for (int i = 0; i < 10000; i++) s.isPalindrome(input);

            long start = System.nanoTime();
            boolean last = false;
            for (int i = 0; i < iterations; i++) {
                last = s.isPalindrome(input);
            }
            long end = System.nanoTime();

            long duration = end - start;

            System.out.printf("%-22s %-12s %-18d%n",
                    s.name(),
                    last ? "Palindrome" : "Not",
                    duration);
        }

        sc.close();
    }
}

interface BenchStrategy {
    boolean isPalindrome(String input);
    String name();
}

class StackBenchStrategy implements BenchStrategy {

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

    public String name() {
        return "StackStrategy";
    }
}

class DequeBenchStrategy implements BenchStrategy {

    public boolean isPalindrome(String input) {
        if (input == null) return false;

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    public String name() {
        return "DequeStrategy";
    }
}

class TwoPointerBenchStrategy implements BenchStrategy {

    public boolean isPalindrome(String input) {
        if (input == null) return false;

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public String name() {
        return "TwoPointerStrategy";
    }
}