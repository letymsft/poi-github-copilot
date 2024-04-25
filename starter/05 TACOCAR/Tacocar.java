//I need a java function that returns the next palindrome number in the odometer based on a given mileage

public class Tacocar {
    public static void main(String[] args) {
        System.out.println(getNextPalindrome(12321));
        System.out.println(getNextPalindrome(12345));
    }

    public static int getNextPalindrome(int mileage) {
        int nextMileage = mileage + 1;
        while (!isPalindrome(nextMileage)) {
            nextMileage++;
        }
        return nextMileage;
    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static int getNextOdometerPalindrome(int mileage) {
        int nextMileage = mileage + 1;
        while (!isPalindrome(nextMileage)) {
            nextMileage++;
        }
        return nextMileage;
    }
}