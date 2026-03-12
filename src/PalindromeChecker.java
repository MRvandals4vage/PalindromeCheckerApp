
public class PalindromeChecker
{public static void uc8_LinkedListMethod() {

    String input = "madam";

    // Convert string to linked list
    Node head = null, tail = null;
    for (char c : input.toCharArray()) {
        Node newNode = new Node(c);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Find middle using slow & fast pointers
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse second half
    Node prev = null;
    while (slow != null) {
        Node next = slow.next;
        slow.next = prev;
        prev = slow;
        slow = next;
    }

    // Compare both halves
    Node first = head;
    Node second = prev;
    boolean isPalindrome = true;

    while (second != null) {
        if (first.data != second.data) {
            isPalindrome = false;
            break;
        }
        first = first.next;
        second = second.next;
    }

    System.out.println("UC8 Input : " + input);
    System.out.println("Is Palindrome? : " + isPalindrome + "\n");
}

    public static void main(String[]args)
    {
        uc8_LinkedListMethod();

    }

}