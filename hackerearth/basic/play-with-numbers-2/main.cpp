#include <bits/stdc++.h>
#define fast ios::sync_with_stdio(false);cin.tie(NULL)
using namespace std;

int main()
{
    int N, Q;
    cin >> N >> Q;

    long long array[N+4];
    for (int i = 0; i < N; i++) {
        cin >> array[i];
        if (i > 0) {
            array[i] = array[i] + array[i-1];
        }
    }

    while (Q-- > 0) {
        int L, R;
        cin >> L >> R;

        int range = R - L + 1;


        cout << ((array[R] - array[L-1]) / range) << endl;
    }

    return 0;
}
