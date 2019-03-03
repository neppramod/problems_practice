#include <bits/stdc++.h>

using namespace std;

int main()
{
    string input;
    cin >> input;

    for (int i = 0; i < input.length()/2; i++) {
        if (input[i] != input[input.length()-i-1]) {
            cout << "NO" << endl;
            return 0;
        }
    }

    cout << "YES" << endl;
    return 0;
}
