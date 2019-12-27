#include <bits/stdc++.h>

using namespace std;
typedef complex<long> point;
typedef long long ll;

const int MAXN = 2e5;
point line[4 * MAXN];

int n;
ll dp[MAXN], h[MAXN], c;

long dot(point a, point b) {
    return (conj(a) * b).real();
}

long f(point a, long x) {
    return dot(a, point(x, 1));
}

void add_line(point nw, int v = 1, int l = 0, int r = MAXN) {
    int m = (l + r) / 2;
    bool lef = f(nw, l) < f (line[v], l);
    bool mid = f(nw, m) < f (line[v], m);

    if (mid) {
        swap(line[v], nw);
    } else if (lef != mid) {
        add_line(nw, 2 * v, l, m);
    } else {
        add_line(nw, 2 * v + 1, m, r);
    }
}

long get(int x, int v = 1, int l = 0, int r = MAXN) {
    int m = (l + r) / 2;
    if (r - l == 1) {
        return f(line[v], x);
    } else if (x < m) {
        return min(f(line[v], x), get(x, 2 * v, l, m));
    } else {
        return min(f(line[v], x), get(x, 2 * v + 1, m, r));
    }
}

int main()
{
    scanf("%d %lld", &n, &c);
    for (int i = 1; i <= n; i++) {
        scanf("%lld", &h[i]);
    }

    add_line()

    return 0;
}
