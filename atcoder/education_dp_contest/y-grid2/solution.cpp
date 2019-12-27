#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pairs;
typedef long long ll;

const int MAXN = 2 * 1e5 + 10;
const int MOD = 1e9 + 7;
const int MAXS = 5000;
ll factorial[MAXN], invfactorial[MAXN], ans[MAXN];
vector<pairs> S;

int H, W, N;

ll expo(ll a, ll b) {
    if (b == 0) {
        return 1;
    } else if (b % 2 == 1) {
        return (a * expo(a, b-1)) % MOD;
    } else {
        long result = expo(a, b/2);
        return (result * result) % MOD;
    }
}

void calcFactorial() {
    factorial[0] = invfactorial[0] = 1;
    for (int i = 1; i < MAXN; i++) {
        factorial[i] = (factorial[i-1] * i) % MOD;
        invfactorial[i] = expo(factorial[i], MOD - 2) % MOD;
    }
}

ll binomial(ll n, ll k) {
    return ((factorial[n] * invfactorial[k] % MOD) * invfactorial[n-k]) % MOD;
}

int main()
{
    calcFactorial();
    scanf("%d %d %d", &H, &W, &N);
    S.push_back(pairs(H, W));

    for (int i = 0; i < N; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        S.push_back(pairs(x, y));
    }

    sort(S.begin(), S.end());

    for (int i = 0; i <= N; i++) {
        ans[i] = binomial(S[i].first + S[i].second - 2, S[i].first - 1);
    }

    // subtract all blocking cell paths
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j <= N; j++) {
            int x = S[j].first - S[i].first;
            int y = S[j].second - S[i].second;

            if (x < 0 || y < 0) {
                continue;
            } else {
                ans[j] = (ans[j] - ans[i] * binomial(x + y, y)) % MOD;
            }
        }
    }

    if (ans[N] < 0) ans[N] += MOD;
    cout << ans[N] << endl;
}
