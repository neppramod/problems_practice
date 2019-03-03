#include <bits/stdc++.h>

using namespace std;

int main()
{
    string line;
    int K;

    cin >> line;
    cin >> K;

    for (int i = 0; i < line.size(); i++) {
        int c = line[i];

        if (c >=  'a' && c <=  'z') {
            line[i] = (c - 'a' + K) % 26 + 'a';
        } else if (c >= 'A' && c <= 'Z') {
             line[i] = (c - 'A' + K) % 26 + 'A';
        } else if (c >= '0' && c <= '9') {
             line[i] = (c - '0' + K) % 10 + '0';
        }
    }

cout << line << endl;

    return 0;
}
