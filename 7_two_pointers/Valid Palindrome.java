public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int n = s.length();
        int left = 0;
        int right = n -1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (!equalChar(s.charAt(left), s.charAt(right))) {
                return false;
            } 
            left++;
            right--;
        }
        return true;
    }
    
    private boolean equalChar(char char1, char char2) {
        if (char1 == char2) {
            return true;
        }
        if (char1 <= '9' && char1 >= '0') {
            return false;
        }
        if (char2 <= '9' && char2 >= '0') {
            return false;
        }
        return ((char1 - char2 == 'a' - 'A') || (char1 - char2 == 'A' - 'a'));
    }
}
