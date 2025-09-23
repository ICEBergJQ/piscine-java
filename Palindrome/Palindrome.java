public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.toLowerCase().charAt(left) != s.toLowerCase().charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
