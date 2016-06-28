static boolean isPrime(int n)
{
    if (n == 1)
        return false;

    if (n == 2)
        return true;

    for (int i = 3; i <= Math.sqrt(n); i+=2) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}
