#include <bits/stdc++.h>

using namespace std;

int main()
{

    int N;
    cin >> N;

    long long product = 1L;
    long long mod = (long)pow(10, 9) + 7l;
    long long num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        product = (product * num) % mod;
    }

    cout << product << endl;

    return 0;
}
