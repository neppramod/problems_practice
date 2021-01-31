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
  ll n, sum = 0;

  cin >> n;

  for (int i = 0; i < n-1; i++) {
	int a;
	cin >> a;
	sum += a;
  }

  cout << (n * (n+1) / 2) - sum;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // int tc; cin >> tc;

  solve();
}
