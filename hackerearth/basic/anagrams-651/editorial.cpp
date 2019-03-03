#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <bits/stdc++.h>

using namespace std;

int number_needed(string a, string b) {
    int p[26]={0},q[26]={0};
    for(int i=0;i<a.length();i++)
        p[a[i]-97]++;
    for(int i=0;i<b.length();i++)
        q[b[i]-97]++;
    int ans=0;
    for(int i=0;i<26;i++)
        ans+=abs(p[i]-q[i]);

    return ans;
}

int main(){

    ///freopen("1.txt","r",stdin);
    //freopen("1a.txt","w",stdout);
    int t;
    cin>>t;
    while(t--)
    {
        string a;
        cin >> a;
        string b;
        cin >> b;
        cout << number_needed(a, b) << endl;
    }
    return 0;
}
