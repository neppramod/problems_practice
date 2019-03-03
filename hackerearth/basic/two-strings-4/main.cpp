#include <bits/stdc++.h>
#define TABLE_SIZE 300

using namespace std;

// cache and recount

int main()
{
    int T;
    cin >> T;

    while (T-- > 0) {
        string line1, line2;
        cin >> line1;
        cin >> line2;

        int table1[TABLE_SIZE] = {0};
        int table2[TABLE_SIZE] = {0};

        for (int i = 0; i < line1.length(); i++) {
            table1[line1[i]]++;
        }

        for (int i = 0; i < line2.length(); i++) {
            table2[line2[i]]++;
        }

        bool matches = true;
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table1[i] != table2[i]) {
                matches = false;
                break;
            }
        }

        if (matches) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}
