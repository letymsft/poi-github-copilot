//I need a java function to check if a string is a palindrome
//Copilot response: Here is a non-public function in Java that checks if a string is a palindrome:

public class Tacocat {
    public static void main(String[] args) {
        System.out.println(isPalindrome("tacocat"));
        System.out.println(isPalindrome("hello"));
    }

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
