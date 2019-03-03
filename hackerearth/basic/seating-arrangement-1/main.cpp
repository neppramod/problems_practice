#include <bits/stdc++.h>

// create sizes bigger than problem statement in arrays
// to prevent overflows

using namespace std;
#define TABLE_SIZE 15

# define WS 5000
# define MS 5001
# define AS 5002

int lookup_alternate[TABLE_SIZE];
int lookup_seat[TABLE_SIZE];

void setup()
{

    // looking below shows, i could find alternate by subtracting from 13,
    // but don't want to change original algorithm, as it does not change
    // efficiency much and this i think is easier to read

    lookup_alternate[1] = 12;
    lookup_alternate[2] = 11;
    lookup_alternate[3] = 10;
    lookup_alternate[4] = 9;
    lookup_alternate[5] = 8;
    lookup_alternate[6] = 7;
    lookup_alternate[7] = 6;
    lookup_alternate[8] = 5;
    lookup_alternate[9] = 4;
    lookup_alternate[10] = 3;
    lookup_alternate[11] = 2;
    lookup_alternate[12] = 1;

    lookup_seat[1] = WS;
    lookup_seat[2] = MS;
    lookup_seat[3] = AS;
    lookup_seat[4] = AS;
    lookup_seat[5] = MS;
    lookup_seat[6] = WS;
    lookup_seat[7] = WS;
    lookup_seat[8] = MS;
    lookup_seat[9] = AS;
    lookup_seat[10] = AS;
    lookup_seat[11] = MS;
    lookup_seat[12] = WS;
}

int main()
{
    // setup lookup table (both alternate and seat)
    // given a number, find remainder of 12, adjust for 0
    // lookup alternate or remainder
    // find difference with alternate
    // subtract that number from given number (don't change sign)
    // return the number and seat (seat is same for number and alternate)

    setup();

    int T;
    cin >> T;

    while (T > 0) {
        int N;
        cin >> N;

        int remainder = N % 12;
        if (remainder == 0) remainder = 12;
        int alternate = lookup_alternate[remainder];

        int difference = remainder - alternate;

        cout << (N - difference) << " ";

        switch (lookup_seat[alternate]) {
        case WS:
            cout << "WS";
            break;
        case MS:
            cout << "MS";
            break;
        case AS:
            cout << "AS";
            break;
        };

        cout << endl;
        --T;
    }

    return 0;
}
