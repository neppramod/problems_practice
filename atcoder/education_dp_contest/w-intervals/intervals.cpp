#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1e5;
const int INF = 1e9 + 10;

typedef long long ll;

ll t[4 * MAXN], lazy[4 * MAXN], dp[MAXN], a[MAXN];
int m, n, li[MAXN], ri[MAXN];
vector<int> left1[MAXN], right1[MAXN];

// see https://cp-algorithms.com/data_structures/segment_tree.html for segment tree implementation
void push(int v)
{
    t[v * 2] += lazy[v];
    t[v * 2 + 1] += lazy[v];
    lazy[v * 2] += lazy[v];
    lazy[v * 2 + 1] += lazy[v];
    lazy[v] = 0;
}

void update(int v, int tl, int tr, int l, int r, long val)
{


    if (l > r) {
        return;
    } else if (l == tl && r == tr) {
        t[v] += val;
        lazy[v] += val;
    } else {
        push(v);
        int tm = (tl + tr) / 2;
        update(v * 2, tl, tm, l, min(tm, r), val);
        update(v * 2 + 1, tm + 1, tr, max(l, tm+1), r, val);
        t[v] = max(t[v * 2], t[v * 2 + 1]);
    }
}

long query(int v, int tl, int tr, int l, int r)
{
    if (l > r) {
        return -INF;
    } else if (l == tl && tr == r) {
        return t[v];
    } else {
        push(v);
        int tm = (tl + tr) / 2;
        return max(query(v * 2, tl, tm, l, min(r, tm)), query(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r));
    }
}

void print(int arr[], int n)
{
    printf("\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


int main()
{
    scanf("%d %d", &n, &m);

    for (int i = 1; i <= m; i++) {
        scanf("%d %d %lld", &li[i], &ri[i], &a[i]);
        left1[li[i]].push_back(i);
        right1[ri[i]].push_back(i);
    }

    for (int i = 1; i <= n; i++) {
        for (int j : left1[i]) {
            update(1, 0, n, 0, li[j]-1, a[j]);
        }

        dp[i] = query(1, 0, n, 0, i-1);
        update(1, 0, n, i, i, dp[i]);

        for (int j : right1[i]) {
            update(1, 0, n, 0, ri[j]-1, -a[j]);
        }
    }

    ll best = 0;
    for (int i = 1; i <= n; i++) {
        best = max(best, dp[i]);
    }

    printf("%lld\n", best);
}
