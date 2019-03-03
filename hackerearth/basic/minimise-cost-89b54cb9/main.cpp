#include <bits/stdc++.h>

#define fast ios::sync_with_stdio(false);cin.tie(NULL);

using namespace std;

int main()
{
    long long N, K;

    cin >> N >> K;

    vector<int> array(N);

    for (int i = 0; i < N; i++) {
        cin >> array[i];
    }

    long long sum = 0;
    for (int i = 0; i < array.size(); ) {
        if (array[i] > 0) {
            sum += array[i];

            long long n = 1;
            for (; n <= K && n + i < array.size(); n++) {
                if (array[i+n] < 0) {
                    sum += array[i+n];
                } else {
                    break;
                }
            }

            i = i + n;
        } else {
            sum += abs(array[i]);
            i++;
        }
    }

    cout << abs(sum) << endl;

    return 0;
}
