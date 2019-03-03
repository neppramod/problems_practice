#include <bits/stdc++.h>

using namespace std;

int main()
{

    int N;
    cin >> N;

    int i = 1;
    while (N >= 0) {
        N -= i;
        if ( N <= 0) {
            cout << "Patlu" << endl;
            break;
        }

        N -= 2 * i;
        if (N <= 0) {
            cout << "Motu" << endl;
            break;
        }

        i++;
    }

    return 0;
}
