#include <bits/stdc++.h>

using namespace std;

int main()
{
    int bitset = 0;
    int p1 = 0;
    int p2;
    int N = 8;

    for (int p1 = 0; p1 < 2 * N; p1++) {
        if (!(bitset & (1 << p1))) {
            cout << "!val: " << (!(bitset & (1 << p1))) << endl;
            cout << p1 << "< p1" << endl;

        } else {
            cout << "val : " << (!(bitset & (1 << p1))) << endl;
        }
    }

    return 0;
}
