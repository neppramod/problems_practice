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

  // two knights can be places in n^2 * (n^2-1) ways
  // since both knights are of same type
  // we divide by 2
  // subtract ways they can attack each other
  // 2 * 2X3 board (attack alternatively)
  // can move (n-1) ways to right and (n-2) to down
  // same with 3x2 board
  // in each 2x3 board each knight can attack 2 times
  // 2 more if we change color

  cout << 0 << endl;
  
  for (int k = 2; k <= n; k++) {
	long x = k * k;
	long result = x * (x-1) / 2;

	result = result - 4 * (k-1) * (k-2);


	cout << result << endl;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // int tc; cin >> tc;

  solve();
}
