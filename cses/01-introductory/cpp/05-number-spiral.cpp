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


long getCellValue(long row, long col) {
  if (row > col) {
	if (row % 2 == 0) {
	  return row * row - col + 1;
	} else {
	  row--;
	  return row * row + col;
	}
  } else {
	if (col % 2 == 0) {
	  col--;
	  return col * col + row;
	} else {
	  return col * col - row + 1;
	}
  }
}

void solve()
{
  int t;
  cin >> t;

  while (t-- > 0) {
	long row, col;

	cin >> row;
	cin >> col;

	cout << getCellValue(row, col) << endl;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // int tc; cin >> tc;

  solve();
}
