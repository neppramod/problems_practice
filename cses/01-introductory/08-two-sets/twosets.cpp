#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<int, int> ii;
typedef vector<int> vi;

int main()
{
  ll n;
  cin >> n;

  if (n * (n + 1) % 4) {
	cout << "NO\n";
	return 0;
  }

  ll sum = n * (n + 1) / 4;
  vi a, b;

  for (int i = n; i >= 1; i--) {
	if (sum >= i) {
	  a.push_back(i);
	  sum -= i;
	} else {
	  b.push_back(i);
	}
  }

  cout << "YES\n";
  cout << a.size() << "\n";
  for (int x : a) {
	cout << x << " ";
  }
  cout << "\n";
  cout << b.size() << "\n";
  for (int x : b) {
	cout << x << " ";
  }
  cout << "\n";  
}
