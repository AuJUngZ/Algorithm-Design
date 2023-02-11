package Midterm;

import java.util.Set;

public class UniqeChar {
    public static int uniqueChar(String str,int n, Set<Character> set){
        if(n == str.length()){
            return set.size();
        }else{
            set.add(str.charAt(n));
            return uniqueChar(str,n+1,set);
        }
    }
}
