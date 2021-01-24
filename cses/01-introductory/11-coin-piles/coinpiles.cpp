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

void solve()
{
  ll a, b;
  cin >> a >> b;

  ll mx = max(a, b);
  ll mi = min(a, b);

  ll diff = mx - mi;

  mx -= 2 * diff;
  mi -= diff;

  if (mi == 0 || (mi > 0 && mi % 3 == 0)) {
	cout << "YES" << endl;
  } else {
	cout << "NO" << endl;
  }
  
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tc; cin >> tc;
  while (tc -- > 0) {
	  solve();
  }
}
