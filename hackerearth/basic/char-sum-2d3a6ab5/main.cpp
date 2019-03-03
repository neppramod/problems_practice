#include <bits/stdc++.h>

using namespace std;

int sum(string line)
{
    int total = 0;
    for (int i = 0; i < line.length(); i++) {
        total += line[i] - 'a' + 1;
    }

    return total;
}

int main()
{
    string line;
    cin >> line;

    cout << sum(line) << endl;

    return 0;
}
