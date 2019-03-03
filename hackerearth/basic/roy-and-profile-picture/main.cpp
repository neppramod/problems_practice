#include <bits/stdc++.h>

using namespace std;

int main()
{
    int L, N;

    cin >> L;
    cin >> N;

    while (N-- > 0) {
        int W, H;
        cin >> W >> H;

        if (W < L || H < L) {
            cout << "UPLOAD ANOTHER";
        } else if (W != H) {
            cout << "CROP IT";
        } else {
            cout << "ACCEPTED";
        }

        cout << endl;
    }

    return 0;
}
