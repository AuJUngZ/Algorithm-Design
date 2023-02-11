package Midterm;

public class SumArray {
    public static int sumArray(int[] A , int n ){
        if(n <= 1){
            return A[n] + A[n-1];
        }else{
            return A[n] + sumArray(A,n-1);
        }
    }
    //proof by induction
    //base case: n = 1 => return A[1] + A[0] is correct
    //inductive step: assume that sumArray(A,n) is correct for all n <= k
    //we want to show that sumArray(A,k+1) is correct
    //from code line 6, we have sumArray(A,k+1) = A[k+1] + sumArray(A,k)
    //from inductive hypothesis, we have sumArray(A,k) = A[k] + sumArray(A,k-1)
    //from line 6, we have sumArray(A,k+1) = A[k+1] + A[k] + sumArray(A,k-1)
    //which is correct

    public static int sumArray2(int[] A , int n ){
        if(n <= 0){
            return A[n];
        }else{
            return A[n] + sumArray2(A,n-1);
        }
    }
    //proof sumArray2 is correct by induction
    //base case: n = 0 => A[0] = 1 --> correct
    //inductive step: assume sumArray2(A,n) is correct for all n <= k
    //we want to show sumArray2(A,k+1) is correct
    //from code line 14, we have sumArray2(A,k+1) = A[k+1] + sumArray2(A,k)
    //by inductive hypothesis, sumArray2(A,k) is correct
    //so sumArray2(A,k+1) is correct

    public static int sumArray3(int[] A , int s ,int e){
        if(s == e){
            return A[s];
        }else{
            int mid = (s+e)/2;
            return sumArray3(A,s,mid) + sumArray3(A,mid+1,e);
        }
    }
}
