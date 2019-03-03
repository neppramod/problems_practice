#include <bits/stdc++.h>

using namespace std;

int main()
{
    long N, X;
    cin >> N;
    cin >> X;

    while (N-- > 0) {
        long Y;
        cin >> Y;

        if (Y >= X) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}
