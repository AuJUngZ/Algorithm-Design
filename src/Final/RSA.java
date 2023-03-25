package Final;


public class RSA {
    private final long p;
    private final long q;
    private final long[] publicKey;
    private final long[] privateKey;
    private long n;
    private long z;
    private long e;
    private long d;

    // Constructor
    public RSA(int p, int q) {
        if(p == q){
            throw new IllegalArgumentException("p and q cannot be equal");
        }
        this.p = p;
        this.q = q;
        this.findN();
        this.findZ();
        this.findE();
        this.findD();
        this.publicKey = new long[]{this.e, this.n};
        this.privateKey = new long[]{this.d, this.n};
        System.out.println("Public key: " + this.publicKey[0] + ", " + this.publicKey[1]);
        System.out.println("Private key: " + this.privateKey[0] + ", " + this.privateKey[1]);
    }

    public static int randomPrime() {
        int prime = 0;
        do {
            prime = (int) (Math.random() * 13);
        } while (!isPrime(prime));
        return prime;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long encrypt(long m) {
        return (long) Math.pow(m, this.e) % this.n;
    }

    public long decrypt(long c) {
        return (long) Math.pow(c, this.d) % this.n;
    }

    private void findN() {
        this.n = this.p * this.q;
    }

    private void findZ() {
        this.z = (this.p - 1) * (this.q - 1);
    }

    private void findE() {
        for (int i = 2; i < this.z; i++) {
            if (gcd(i, this.z) == 1) {
                this.e = i;
                break;
            }
        }
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private void findD() {
        for (int i = 1; i < this.z; i++) {
            if ((this.e * i) % this.z - 1 == 0) {
                this.d = i;
                break;
            }
        }
    }
}
