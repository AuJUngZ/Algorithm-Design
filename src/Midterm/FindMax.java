package Midterm;

public class FindMax {
    public static int Incremental(int[] x,int n) {
        if(n <= 0){
            return 0;
        }else{
            return Math.max(x[n],Incremental(x,n-1));
        }
    }

    public static int divideAndConquer(int[] x,int left,int right){
        if(right == left) {
            return x[left];
        }else{
            int mid = (left + right) / 2;
            return Math.max(divideAndConquer(x,left,mid),divideAndConquer(x,mid+1,right));
        }
    }
}
