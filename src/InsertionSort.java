public class InsertionSort {
    public static void insertionSort(int[] A,int n){
        if(n == 0){
            return ;
        }else{
            insertionSort(A, n-1);
            moveToCorrect(A,n);
        }
    }

    private static void moveToCorrect(int[] a, int n) {
        int temp = a[n];
        int i = n-1;
        while(i >= 0 && a[i] > temp){
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = temp;
    }
}
