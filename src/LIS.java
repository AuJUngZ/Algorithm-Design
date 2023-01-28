public class LIS {
    public static int lis(int[] arr, int[] db, int n) {
        if(n == 0){
            db[n] = 1;
            return 1;
        }else if(db[n] != 0){
            return db[n];
        }else{
            int max = 1;
            for(int i = 0; i < n; i++){
                int temp = lis(arr, db, i);
                if(arr[i] < arr[n] && temp + 1 > max){
                    max = temp + 1;
                }
            }
            db[n] = max;
            return max;
        }
    }
}
