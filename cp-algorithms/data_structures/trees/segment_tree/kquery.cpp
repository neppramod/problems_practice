/*
SPOJ: KQuery
*/
#include <bits/stdc++.h>

using namespace std;

const long long MOD = 1e9 + 7;
const long long INF = INT_MAX / 10;

typedef long long ll;
typedef long double ld;
typedef vector<int> vi;
typedef vector<long> vl;
typedef pair<int,int> pii;


#define F first
#define S second
#define PB push_back
#define MP make_pair

#define MAXN 30005

typedef struct {
    vl list;
} node;

node t[4 * MAXN];

node create_node(ll val)
{
    node node1;
    node1.list.PB(val);
    return node1;
}

node merge(node n1, node n2)
{
    node n3;
    int i = 0, j = 0;

    vl l1,l2,l3;

    l1 = n1.list;
    l2 = n2.list;

    while (i < l1.size() && j < l2.size()) {
	if (l1[i] < l2[j]) {
	    l3.PB(l1[i++]);
	} else {
	    l3.PB(l2[j++]);
	}
    }

    while (i < l1.size()) {
	l3.PB(l1[i++]);
    }

    while (j < l2.size()) {
	l3.PB(l2[j++]);
    }

    n3.list = l3;
    return n3;
}

void build(ll a[], int v, int tl, int tr)
{
    if (tl == tr) {
	t[v] = create_node(a[tl]);
    } else {
	int tm = (tl + tr) / 2;

	build(a, v * 2, tl, tm);
	build(a, v * 2 + 1, tm + 1, tr);

	t[v] = merge(t[v * 2], t[v * 2 + 1]);
    }
}

int query(int v, int tl, int tr, int l, int r, ll k)
{
    if (l > r) {
	return 0;
    } else if (l == tl && r == tr) {
	auto h = upper_bound(t[v].list.begin(), t[v].list.end(), k);
	return (t[v].list.end() - h);
    } else {
	int tm = (tl + tr) / 2;
	return query(v * 2, tl, tm, l, min(tm, r), k) + query(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r, k);
    }
}

void solve()
{
    //vl a = {1,1,1,2,3,4,5};
    //auto h = upper_bound(a.begin(), a.end(), 1);
    //cout << (a.end() - h)<< "\n";

    int n;
    cin >> n;
    ll a[n];
    for (int i = 0; i < n; i++) {
	cin >> a[i];
    }

    build(a, 1, 0, n-1);
    
    ll q;
    cin >> q;

    while (q -- > 0) {
	int i, j;
	ll k;

	cin >> i >> j >> k;
	cout << query(1, 0, n-1, i-1, j-1, k) << "\n";
    }

    /*
    for (int i = 0; i < 15; i++) {
	for (auto val : t[i].list) {
	    cout << val << " ";
	}
	cout << "\n";
    }
    */
    
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    // int tc; cin >> tc; while (tc--) solve();

    solve();
    return 0;
}
