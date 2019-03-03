#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    while (N -- > 0) {
        int SH, SM, EH, EM;

        cin >> SH >> SM >> EH >> EM;

        int sm = SH * 60 + SM;
        int em = EH * 60 + EM;

        int diffmin = (int)abs(em - sm);

        int hr = diffmin / 60;
        int min = diffmin % 60;

        cout << hr << " " << min << endl;
    }

    return 0;
}
