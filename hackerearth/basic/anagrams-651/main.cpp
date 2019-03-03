#include <bits/stdc++.h>
#define MAX_SIZE 20000
#define TABLE_SIZE 300

using namespace std;

// count common words only once


int main()
{

    int T;
    cin >> T;

    for (int k = 0; k < T; k++) {
        int count = 0;
        char first[MAX_SIZE];
        char second[MAX_SIZE];

        cin >> first;
        cin >> second;

        int table[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = 0;
        }

        // count chars from first
        int charcounter = 0;
        while (first[charcounter] != '\0') {
            table[first[charcounter]]++;
            charcounter++;
        }

        // count once overlapping chars from second, discount, or count
        charcounter = 0;
        while (second[charcounter] != '\0') {
            if (table[second[charcounter]] > 0) {
                table[second[charcounter]]--;
            } else {
                count++;
            }
            charcounter++;
        }

        // add remaining from first
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i] > 0) {
                count += table[i];
            }
        }

        cout << count << endl;

    }

    return 0;
}
