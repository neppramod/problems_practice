#include <bits/stdc++.h>

using namespace std;

int main()
{
    string line;
    getline(cin, line);

    for (int i = 0; i < line.length(); i++) {
        if (line[i] >= 'A' && line[i] <= 'Z') {
            line[i] = ('a' + line[i] - 'A');
        } else if (line[i] >= 'a' && line[i] <= 'z') {
            line[i] = ('A' + line[i] - 'a');
        }
    }

    cout << line << endl;

    return 0;
}
