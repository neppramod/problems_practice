#include <bits/stdc++.h>

#define fast ios::sync_with_stdio(false);cin.tie(NULL)

using namespace std;

int sum(int array[], int startIndex, int count, int N)
{
    int total = 0;

    if (startIndex + count > N) return 0;

    for (int i = startIndex; i < startIndex + count; i++) {
        total += array[i];
    }

    return total;
}

int main()
{
    int N;
    cin >> N;

    int array[N];
    for (int i = 0; i < N; i++) {
        cin >> array[i];
    }

    int globalmaximum = 0;

    for (int j = 0; j < N; j++) {
        int curtotal = 0;
        int i=j;
        int count = 1;
        while (i < N) {
            int current = sum(array, i, count, N);
            curtotal += current;
            i += count;
            count++;
        }

        globalmaximum = max(curtotal, globalmaximum);
    }

    cout << globalmaximum << endl;

    return 0;
}
