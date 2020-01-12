class Solution {

    static final int MAXN = 31;

    public static void main(String[] args) {
        System.out.println(fib(30));
    }


    public static int fib(int N) {
        int[] fib = new int[MAXN+1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= MAXN; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[N];
    }
}
