public class Fibonacci {
    public static long Fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return Fib(n - 1) + Fib(n - 2);
        }
    }

    public static long topDown(int n,long[] fib){
        if(fib[n] != 0){
            return fib[n];
        } else {
            if (n == 0 || n == 1) {
                fib[n] = 1;
                return n;
            } else {
                fib[n] = topDown(n - 1,fib) + topDown(n - 2,fib);
            }
        }
        return fib[n];
    }

//    public static long buttomUp(int n){
//        long[] fib = new long[n+1];
//        fib[0] = 1;
//        fib[1] = 1;
//        for(int i = 2 ; i < n ; i++){
//            fib[i] = fib[i-1] + fib[i-2];
//        }
//        return fib[n-1];
//    }
}
