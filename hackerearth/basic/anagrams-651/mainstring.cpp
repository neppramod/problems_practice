#include <bits/stdc++.h>
#define TABLE_SIZE 500

using namespace std;

int main()
{
    int T;
    cin >> T;

    while (T-- > 0) {
        string first;
        string second;

        cin >> first;
        cin >> second;

        int table[TABLE_SIZE] = {0};
        int count = 0;

        for (int i = 0; i < first.length(); i++) {
            table[first[i]]++;  // count all occurances of chars from first table
        }

        // discount matching characters, but count unique not in first
        for (int i = 0; i < second.length(); i++) {
            if (table[second[i]] > 0) {
                table[second[i]]--;
            } else {
                count++;
            }
        }

        // count the remaining from first
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i] > 0) {
                count += table[i];
            }
        }

        cout << count << endl;
    }
    return 0;
}
