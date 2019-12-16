#include <bits/stdc++.h>

using namespace std;

typedef tuple<int, int, int> triplet;
typedef long long ll;

const int MAXN = 1e5;
const int INF = 1e9 + 10;
const int MAXW = 2*1e4 + 10;

vector<triplet> tower;
ll dp[MAXW];
int N;


void print(int arr[], int n)
{
    printf("\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

ll best(ll arr[], int n)
{
    ll ans = 0;
    for (int i = 0; i < n; i++) {
        ans = max(ans, arr[i]);
    }

    return ans;
}



int main()
{
    scanf("%d", &N);
    for (int i = 1; i <= N; i++) {
        int w, s;
        ll v;
        scanf("%d %d %lld", &w, &s, &v);
        tower.push_back(make_tuple(w + s, w, v));
    }

    sort(tower.begin(), tower.end());

    for (triplet t: tower) {
        int solid_weight = get<0>(t);
        int weight = get<1>(t);
        ll value = get<2>(t);

        for (int i = MAXW-1; i >= 0; i--) {
            if (i + weight <= solid_weight) {
                dp[i + weight] = max(dp[i + weight], dp[i] + value);
            }
        }
    }

    printf("%lld\n", best(dp, MAXW));

    return 0;
}
