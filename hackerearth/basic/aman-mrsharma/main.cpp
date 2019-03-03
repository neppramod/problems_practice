#include <bits/stdc++.h>

using namespace std;

int main()
{
    int toffee = 0;

    int d;
    cin >> d;
    double pie = 22.0/7;

    while (d-- > 0) {
        int r, x;
        cin >> r >> x;

        double target = 2 * pie * r;
        double capable = 100 * x;

        if (capable >= target) {
            toffee++;
        }
    }

    cout << toffee << endl;

    return 0;
}
