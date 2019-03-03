#include <bits/stdc++.h>

using namespace std;

int main()
{
    string command;
    cin >> command;
    int X = 0, Y = 0;

    for (int i = 0; i < command.length(); i++) {
        char c = command[i];
        switch(c) {
        case 'L':
            X -= 1;
            break;
        case 'R':
            X += 1;
            break;
        case 'D':
            Y -= 1;
            break;
        case 'U':
            Y += 1;
            break;
        };
    }

    cout << X << " " << Y << endl;

    return 0;
}
