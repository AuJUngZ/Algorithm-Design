public class SecondSmall {
    public static int secondSmall(int[] A, int n, int min, int secondMin){
        if(n == 0){
            return secondMin;
        }else{
            if(A[n] < min){
                secondMin = min;
                min = A[n];
            }else if(A[n] < secondMin){
                secondMin = A[n];
            }
            return secondSmall(A,n-1,min,secondMin);
        }
    }

    public static int aujung(int[] A, int n, int min, int secondMin){
        if(n==0){
            return secondMin;
        }else{
           int temp = aujung(A,n-1,min,secondMin);
              if(A[n] < min){
                secondMin = min;
                min = A[n];
            }else if(A[n] < secondMin){
                secondMin = A[n];
              }
                return temp;
        }
    }
}
