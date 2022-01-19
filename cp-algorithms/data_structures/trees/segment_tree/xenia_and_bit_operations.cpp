/*
https://codeforces.com/problemset/problem/339/D
*/

#include <bits/stdc++.h>

using namespace std;

const long long MOD = 1e9 + 7;
const long long INF = 1e9 + 7;

typedef long long ll;
typedef vector<int> vi;
typedef pair<int,int> ii;
typedef vector<ii> vii;
typedef vector<vi> vvi;

#define F first
#define S second
#define PB push_back
#define MP make_pair
#define MAXN 131075


typedef struct {
    int level;
    ll val;
} node;

node t[4 * MAXN];


void build(ll a[], int v, int tl, int tr)
{
    if (tl == tr) {
	t[v].val = a[tl];
	t[v].level = 1;
    } else {
	int tm = (tl + tr) / 2;

	build(a, v * 2, tl, tm);
	build(a, v * 2 + 1, tm + 1, tr);

	t[v].level = t[v * 2].level + 1;

	if (t[v].level % 2 == 0) {
	    t[v].val = t[v * 2].val | t[v * 2 + 1].val;
	} else {
	    t[v].val = t[v * 2].val ^ t[v * 2 + 1].val;
	}
    }
}

void update(int v, int tl, int tr, int pos, ll new_val)
{
    if (tl == tr) {
	t[v].val = new_val;
    } else {
	int tm = (tl + tr) / 2;

	if (pos <= tm) {
	    update(v * 2, tl, tm, pos, new_val);
	} else {
	    update(v * 2 + 1, tm + 1, tr, pos, new_val);
	}

	if (t[v].level % 2 == 0) {
	    t[v].val = t[v * 2].val | t[v * 2 + 1].val;
	} else {
	    t[v].val = t[v * 2].val ^ t[v * 2 + 1].val;
	}
    }
}

void solve()
{
    int pow, m, n;
    cin >> pow >> m;

    n = 1 << pow;

    ll a[n];
    for (int i = 0; i < n; i++) {
	cin >> a[i];
    }

    build(a, 1, 0, n-1);

    for (int i = 0; i < m; i++) {
	int p, b;
	cin >> p >> b;
	update(1, 0, n-1, p-1, b);
	cout << t[1].val << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    // int tc; cin >> tc;

    solve();
}

/*
Input:
2 4
1 6 3 5
1 4
3 4
1 2
1 2

Output:
1
3
3
3
 */
