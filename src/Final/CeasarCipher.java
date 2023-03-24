package Final;

public class CeasarCipher {

    public static String encrypt(String str, int shift){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z'){
                c = (char) (c + shift);
                if (c > 'z'){
                    c = (char) (c - 'z' + 'a' - 1);
                }
                result.append(c);
            }
            else if (c >= 'A' && c <= 'Z'){
                c = (char) (c + shift);
                if (c > 'Z'){
                    c = (char) (c - 'Z' + 'A' - 1);
                }
                result.append(c);
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String str, int shift){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z'){
                c = (char) (c - shift);
                if (c < 'a'){
                    c = (char) (c + 'z' - 'a' + 1);
                }
                result.append(c);
            }
            else if (c >= 'A' && c <= 'Z'){
                c = (char) (c - shift);
                if (c < 'A'){
                    c = (char) (c + 'Z' - 'A' + 1);
                }
                result.append(c);
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
