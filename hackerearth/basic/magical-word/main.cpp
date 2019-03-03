#include <bits/stdc++.h>

#define PRIME_LIMIT 1000

using namespace std;

bool prime[PRIME_LIMIT];
int prime_count = 0;
int formatted_prime[PRIME_LIMIT];
void setup()
{

    for (int i = 0; i < PRIME_LIMIT; i++) {
        prime[i] = true;
    }

    for (int i = 2; i < PRIME_LIMIT; i++) {
        if (prime[i]) {b
            for (int j = i + i; j < PRIME_LIMIT; j+=i) {
                prime[j] = false;
            }
        }
    }

    // prime within alphabet
    int j = 0;
    for (int i = 'A'; i <= 'z'; i++) {
        if (i >= 91 && i <= 96) continue;
        if (prime[i]) {
            formatted_prime[j] = i;
            prime_count++;
            j++;
        }
    }
}

int findcloseprime(int num)
{
    int closest = formatted_prime[0];
    for (int i = 1; i < prime_count; i++) {
        if (abs(num-closest) > abs(num - formatted_prime[i])) {
            closest = formatted_prime[i];
        }
    }

    return closest;
}

int main()
{
    setup();
    int T;
    cin >> T;

    while (T-- > 0) {
        int S;
        cin >> S;

        string line;
        cin >> line;

        for (int i = 0; i < S; i++) {

            printf("%c", findcloseprime(line[i]));
        }
        printf("\n");
    }
    return 0;
}
