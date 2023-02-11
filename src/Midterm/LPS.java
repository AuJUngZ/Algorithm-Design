package Midterm;

public class LPS {
    public static String longestPalindrome(String s){
        String result = "";
        int len = 0;

        for(int i = 0 ; i < s.length() ; i++){
            int left = i;
            int right = i;
            // odd length
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > len){
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // even length
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > len){
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return result;
    }
}
