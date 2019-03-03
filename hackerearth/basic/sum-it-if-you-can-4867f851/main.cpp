#include <bits/stdc++.h>

using namespace std;

int getsum(string line)
{
    int sum = 0;

    for (int i = 0; i < line.length(); i++) {
        sum += (line[i] - '0') * (i+1);
    }

    return sum;
}

int main()
{
    string line;
    cin >> line;

    if (line.length() != 10) {
        cout << "Illegal ISBN" << endl;
    } else {
        int sum = getsum(line);
        if (sum % 11 == 0) {
            cout << "Legal ISBN" << endl;
        } else {
            cout << "Illegal ISBN" << endl;
        }
    }

    return 0;
}
