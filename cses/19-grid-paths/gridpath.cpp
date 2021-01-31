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

bool vis[7][7];
int ans;
string s;

bool e(int i, int j) {
  return i >= 0 && i < 7 && j >= 0 && j < 7 && !vis[i][j];
}

void dfs(int i, int j, int a=0) {
  // cout << i << " " << j << " " << a << endl;

  // if current position is last row, first column
  // and if number of steps (a) is 48
  // increment result count
  if (i == 6 && j == 0) {
	if (a == 48) {
	  ans++;
	}
	return;
  }

  // visit current node
  vis[i][j] = 1;

  // if current char is '?' or current char is 'L'
  if (s[a] == '?' || s[a] == 'L') {

	// if j is greater than 0 and if left is not visited
	if (j && !vis[i][j-1]) {

	  // if 2 position left is not valid, but one position left up and down are valid
	  // and your current move is left
	  // don't go there, because after visiting left
	  // you have to go up or down
	  // visiting either side will not result in an answer
	  // because you can never return to the other side
	  // and still have a valid answer.
	  // if that's not the case, you can go left
	  if (!(!e(i, j-2) && e(i-1, j-1) && e(i+1, j-1))) {
		dfs(i, j-1, a + 1);
	  }
	  
	}
  }


  // similarly handle other 3 cases
  // right
  if (s[a] == '?' || s[a] == 'R') {
	if (j < 6 && !vis[i][j+1]) {
	  if (!(!e(i, j+2) && e(i-1, j+1) && e(i+1, j+1))) {
		dfs(i, j+1, a + 1);
	  }
	}
  }

  // up
  if (s[a] == '?' || s[a] == 'U') {
	if (i && !vis[i-1][j]) {
	  if (!(!e(i-2, j) && e(i-1, j-1) && e(i-1, j+1))) {
		dfs(i-1, j, a+1);
	  }
	}
  }

  // down
  if (s[a] == '?' || s[a] == 'D') {
	if (i < 6 && !vis[i+1][j]) {
	  if (!(!e(i+2, j) && e(i+1, j-1) && e(i+1, j+1))) {
		dfs(i+1, j, a + 1);
	  }
	}
  }


  vis[i][j] = 0;
}

void solve()
{
  cin >> s;
  dfs(0, 0, 0);
  
  cout << ans;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // int tc; cin >> tc;

  solve();
}
