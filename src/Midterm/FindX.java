package Midterm;

public class FindX {
    public static boolean findX(int[][] n,int x,int I){
        if(I < 0){
            return false;
        }else{
            for(int i = 0;i < n[I].length;i++){
                if(n[I][i] == x){
                    return true;
                }
            }
            return findX(n,x,I-1);
        }
    }
}
