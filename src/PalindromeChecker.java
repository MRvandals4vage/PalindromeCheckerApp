
public class PalindromeChecker {
    public static void main(String[] args)
    {
        String a= "madam";
        char[] b= a.toCharArray();
        int l= a.length();
        boolean flag = false;
        for(int i=0; i<l/2;i++)
        {
            if(b[i]==b[l-i])
                flag= true;
            else
                flag= false;

        }
        if (flag==true)
            System.out.println("String is Palindrome");
        else
            System.out.println("Not a Palindrome");


    }
}