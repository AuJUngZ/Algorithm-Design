package Midterm;

public class mergeSort {
    public static void mergeSort(int[] A) {
        int length = A.length;
        if (length <= 1) return;

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for(int i = 0; i < length; i++){
            if(i < mid){
                left[i] = A[i];
            }else{
                right[i - mid] = A[i];
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, A);
    }

    public static void Exam(int[] A,int s,int e){
        if(e-s == 3){
            if(A[s] > A[s+1]){
                int temp = A[s];
                A[s] = A[s+1];
                A[s+1] = temp;
            }
            if(A[s+1] > A[s+2]){
                int temp = A[s+1];
                A[s+1] = A[s+2];
                A[s+2] = temp;
            }
            if(A[s] > A[s+1]){
                int temp = A[s];
                A[s] = A[s+1];
                A[s+1] = temp;
            }
        }else{
            int mid = (s+e)/2;
            Exam(A,s,mid);
            Exam(A,mid+1,e);
            aujungMerge(A,s,mid,e);
        }
    }
    private static void merge(int[] left, int[] right, int[] arr) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, l = 0, r = 0;

        //check condition for merging
        while(l < leftLength && r < rightLength){
            if(left[l] <= right[r]){
                arr[i++] = left[l++];
            }else {
                arr[i++] = right[r++];
            }
        }
        while(l < leftLength){
            arr[i++] = left[l++];
        }
        while(r < rightLength){
            arr[i++] = right[r++];
        }
    }

    public static void aujung(int[] A, int left, int right){
        if(left == right){
            return;
        }else{
            int mid = (left+right)/2;
            aujung(A, left, mid);
            aujung(A, mid+1, right);
            aujungMerge(A, left, mid, right);
        }
    }

    private static void aujungMerge(int[] a, int left, int mid, int right) {
        int[] leftArr = new int[mid-left+1+1];
        int[] rightArr = new int[right-mid+1];
        //copy left array
        for(int i = 0; i < mid-left+1; i++){
            leftArr[i] = a[left+i];
        }
        //copy right array
        for(int i = 0; i < right-mid; i++){
            rightArr[i] = a[mid+1+i];
        }
        //set sentinel
        leftArr[mid-left+1] = Integer.MAX_VALUE;
        rightArr[right-mid] = Integer.MAX_VALUE;
        //merge
        int i = left;
        int l = 0;
        int r = 0;
        while(i <= right){
            if(leftArr[l] <= rightArr[r]){
                a[i++] = leftArr[l++];
            }else{
                a[i++] = rightArr[r++];
            }
        }
    }
}
