package Final;


public class RSA {
    private final int p;
    private final int q;
    private int n;
    private int z;
    private int e;
    private int d;
    private final int[] publicKey;
    private final int[] privateKey;

    // Constructor
    public RSA(int p, int q) {
        this.p = p;
        this.q = q;
        this.findN();
        this.findZ();
        this.findE();
        this.findD();
        this.publicKey = new int[]{this.e, this.n};
        this.privateKey = new int[]{this.d, this.n};
    }

    public int encrypt(int m) {
        return (int) Math.pow(m, this.e) % this.n;
    }

    public int decrypt(int c) {
        return (int) Math.pow(c, this.d) % this.n;
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

    private int gcd(int a, int b) {
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
