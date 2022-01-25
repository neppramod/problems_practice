#include <bits/stdc++.h>

using namespace std;

const long long MOD = 1e9 + 7;
const long long INF = INT_MAX / 10;

typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int,int> pii;


#define F first
#define S second
#define PB push_back
#define MP make_pair

#define MAXN 1024000

int t[4 * MAXN];
int lazy[4 * MAXN];

#define FLAG_SET 1
#define FLAG_RESET 2
#define FLAG_FLIP 3

int flip(int b)
{
    if (b == FLAG_SET) return FLAG_RESET;
    else if (b == FLAG_RESET) return FLAG_SET;
    else if (b == FLAG_FLIP) return 0;
    else return FLAG_FLIP;
}

void push(int v, int tl, int tr)
{
    if (lazy[v] == 0) return;

    if (lazy[v] == FLAG_SET) {
	t[v] = tr - tl + 1;
    } else if (lazy[v] == FLAG_RESET) {
	t[v] = 0;
    } else if (lazy[v] == FLAG_FLIP) {
	t[v] = (tr - tl + 1) - t[v];
    }

    // push current state to children
    if (tl != tr) {
	if (lazy[v] == FLAG_SET) {
	    lazy[v*2] = lazy[v*2+1] = lazy[v];
	} else if (lazy[v] == FLAG_RESET) {
	    lazy[v*2] = lazy[v*2+1] = lazy[v];
	} else if (lazy[v] == FLAG_FLIP) {
	    lazy[v*2] = flip(lazy[v*2]);
	    lazy[v*2+1] = flip(lazy[v*2+1]);
	}
    }

    lazy[v] = 0;
}

void build(int a[], int v, int tl, int tr)
{
    lazy[v] = 0;

    if (tl == tr) {
	t[v] = a[tl];
    } else {
	int tm = (tl + tr) / 2;
	build(a, v * 2, tl, tm);
	build(a, v * 2 + 1, tm + 1, tr);
	t[v] = t[v * 2] + t[v * 2 + 1];
    }
}

void update_set(int v, int tl, int tr, int l, int r)
{
    push(v, tl, tr);
    if (tl > r || tr < l) return;
    if (tl == tr) {
	t[v] = 1;
	lazy[v] = 0;
    } else if (l <= tl && tr <= r) {
	t[v] = r - l + 1;
	lazy[v * 2] = lazy[v * 2 + 1] = FLAG_SET;
    } else {
	int tm = (tl + tr) / 2;
	update_set(v * 2, tl, tm, l, min(r, tm));
	update_set(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
	t[v] = t[v * 2] + t[v * 2 + 1];
    }
}

void update_reset(int v, int tl, int tr, int l, int r)
{
    push(v, tl, tr);
    if (tl > r || tr < l) return;
    if (tl == tr) {
	t[v] = 0;
	lazy[v] = 0;
    } else if (l <= tl && tr <= r) {
	t[v] = 0;
	lazy[v * 2] = lazy[v * 2 + 1] = FLAG_RESET;
    } else {
	int tm = (tl + tr) / 2;
	update_reset(v * 2, tl, tm, l, min(r, tm));
	update_reset(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
	t[v] = t[v * 2] + t[v * 2 + 1];
    }
}

void update_flip(int v, int tl, int tr, int l, int r)
{
    push(v, tl, tr);
    if (tl > r || tr < l) return;
    if (tl == tr) {
	t[v] = t[v] == 1 ? 0 : 1;
	lazy[v] = 0;
    } else if (l <= tl && tr <= r) {
	t[v] = 0;
	lazy[v * 2] = flip(lazy[v*2]);
	lazy[v * 2 + 1] = flip(lazy[v * 2 + 1]);
    } else {
	int tm = (tl + tr) / 2;
	update_reset(v * 2, tl, tm, l, min(r, tm));
	update_reset(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
	t[v] = t[v * 2] + t[v * 2 + 1];
    }
}

int query(int v, int tl, int tr, int l, int r)
{
    push(v, tl, tr);
    if (tl > r || tr < l) return -1;
    if (l <= tl && tr <= r) {
	return t[v];
    } else {
	int tm = (tl + tr) / 2;
	int q1 = query(v * 2, tl, tm, l, min(r, tm));
	int q2 = query(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
	if (q1 < 0) return q2;
	if (q2 < 0) return q1;
	return q1 + q2;
    }
}

void solve()
{
     int t1;
    cin >> t1;
    int case1 = 1;
    while (t1--) {
	int m;
	cin >> m;
	
	string s;
	while (m--) {
	    int T;
	    string s1;
	    cin >> T >> s1;

	    while (T--) {
		s += s1;
	    }    
	}

	int n = s.length();
	int a[n];
	for (int i = 0; i < n; i++) {
	    a[i] = s[i] == '0' ? 0 : 1;
	}

	build(a, 1, 0, n-1);

	cout << "Case " << (case1++) << ":\n";
	int q1 = 1;
	
	
	int q;
	cin >> q;
	while (q--) {
	    char mode;
	    int l, r;
	    cin >> mode >> l >> r;
	    
	    if (mode == 'F') update_set(1, 0, n-1, l, r);
	    else if (mode == 'E') update_reset(1, 0, n-1, l, r);
	    else if (mode == 'I') update_flip(1, 0, n-1, l, r);
	    else if (mode == 'S')cout << "Q" <<(q1++) << ": " << query(1, 0, n-1, l, r) << "\n";
	}

    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    // int tc; cin >> tc; while (tc--) solve();

    solve();
    return 0;
}
