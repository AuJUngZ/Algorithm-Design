package Final;

public class PolyolphabeticCipher {

    public static String encrypt(String txt,int[] key){
        StringBuilder result= new StringBuilder();
        int j=0;
        for(int i=0;i<txt.length();i++){
            if(j==key.length)
                j=0;
            result.append((char) (txt.charAt(i) + key[j]));
            j++;
        }
        return result.toString();
    }

    public static String decrypt(String txt,int[] key){
        StringBuilder result= new StringBuilder();
        int j=0;
        for(int i=0;i<txt.length();i++){
            if(j==key.length)
                j=0;
            result.append((char) (txt.charAt(i) - key[j]));
            j++;
        }
        return result.toString();
    }
}
