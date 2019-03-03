#include <bits/stdc++.h>

using namespace std;

bool isdigitsumeven(char d1, char d2) {
    int sum = 0;
    sum += d1 - '0';
    sum += d2 - '0';

    return ((sum % 2) == 0);
}

void printandexit(bool valid)
{
    if (!valid) {
        cout << "invalid" << endl;
        exit (0);
    }
}

int main()
{
    string line;
    cin >> line;

    bool valid = true;
    valid = isdigitsumeven(line[0], line[1]);
    printandexit(valid);

    int c = line[2];


    if (c == 'A' || c == 'E' || c == 'I' ||c == 'O' ||c == 'U' ||c == 'Y') {
        valid = false;
    }
    printandexit(valid);

    for (int i = 3; i < 8; i++) {  // sum of current and next
        if (i == 5 || i == 6) continue;
        valid = isdigitsumeven(line[i], line[i+1]);
        if (!valid) break;
    }
    printandexit(valid);

    if (valid) {
        cout << "valid" << endl;
    }

    return 0;
}
