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
  string s;

  cin >> s;

  char last = s[0];
  int curCount = 0;
  int sum = 0;

  for (int i = 0; i < s.length(); i++) {
	char c = s[i];

	if (c == last) {
	  curCount++;
	  sum = max(sum, curCount);
	} else {
	  curCount = 1;
	  last = c;
	}
  }

  cout << sum << endl;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // int tc; cin >> tc;

  solve();
}
