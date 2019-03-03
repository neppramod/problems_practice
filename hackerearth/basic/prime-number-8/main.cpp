#include <bits/stdc++.h>
#define PRIME_LIMIT 1050

bool prime[PRIME_LIMIT];

void formatPrime()
{
    for (int i = 2; i < PRIME_LIMIT; i++) {
        prime[i] = true;
    }

    for (int i = 2; i < PRIME_LIMIT; i++) {
        if (prime[i]) {
            for (int j = i+i; j < PRIME_LIMIT; j+=i) {
                prime[j] = false;
            }
        }
    }
}

bool isPrime(int n)
{
    return prime[n];
}

using namespace std;

int main()
{
    formatPrime();
    int N;
    cin >> N;

    for (int i = 2; i <= N; i++) {
        if (isPrime(i)) {
            cout << i << " ";
        }
    }

    cout << endl;

    return 0;
}
