public class BinarySearch {
    public static int binarySearch(int[] A, int start,int end,int key){
        if(start == end){
            if(A[start] == key){
                return start;
            }
            else{
                return -1;
            }
        }
        else{
            int mid = (start+end)/2;
            if(A[mid] == key){
                return mid;
            }
            else if(A[mid] > key){
                return binarySearch(A,start,mid-1,key);
            }
            else{
                return binarySearch(A,mid+1,end,key);
            }
        }
    }
}
