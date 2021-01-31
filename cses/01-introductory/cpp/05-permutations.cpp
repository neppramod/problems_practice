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
  int n;

  cin >> n;

  if (n == 1) {
	cout << "1" << endl;
  } else if (n <= 3) {
	cout << "NO SOLUTION" << endl;
  } else if (n == 4) {
	cout << "2 4 1 3" << endl;
  } else {
	for (int i = 1; i <= n; i+=2) {
	  cout << i << " ";
	}

	for (int i = 2; i <= n; i+=2) {
	  cout << i << " ";
	}

	cout << endl;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // int tc; cin >> tc;

  solve();
}
