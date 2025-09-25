E2. Looking at Towers (difficult version)
time limit per test4 seconds
memory limit per test512 megabytes
This is the difficult version of the problem. The only differences between the easy and the difficult version are the constraints on t
 and n
.

Consider a row of m
 towers; the height of the i
-th tower in the row is hi
.

If you look at this row of towers from the left, you see all towers that are strictly higher than all towers before them. Similarly, if you look at this row of towers from the right, you see all towers that are strictly higher than all towers after them. For example, if the towers have heights [3,5,5,7,4,6,7,2,4]
, then:

when looking from the left, you see towers with heights 3
, 5
 and 7
;
when looking from the right, you see towers with heights 7
 and 4
.
Let L(h)
 be the set of heights you see from the left, and R(h)
 be the set of heights you see from the right when the sequence of heights is h
. In the example above, L(h)={3,5,7}
, and R(h)={4,7}
.

You are given a sequence a1,a2,…,an
. Your task is to calculate the number of subsequences of a
 such that L(a)=L(a′)
 and R(a)=R(a′)
, where a′
 is the subsequence you consider. Two subsequences are different if indices of chosen elements are different.

Input
The first line contains one integer t
 (1≤t≤104
) — the number of test cases.

Each test case consists of two lines:

the first line contains one integer n
 (1≤n≤3⋅105
);
the second line contains n
 integers a1,a2,…,an
 (1≤ai≤109
).
Additional constraint on the input: the sum of n
 over all test cases does not exceed 3⋅105
.

Output
For each test case, print one integer — the number of subsequences a′
 of the given sequence a
 such that L(a)=L(a′)
 and R(a)=R(a′)
. Since it might be huge, print it modulo 998244353
.

Example
InputCopy
5
5
4 2 4 8 3
5
1 2 3 2 1
6
1 2 3 3 2 1
9
3 5 5 7 4 6 7 2 4
1
10
OutputCopy
5
1
3
51
1
Note
In the first example, L(a)={4,8}
, R(a)={3,8}
. The subsequences included in the answer are:

[4,8,3]
 (the 1
-st, the 4
-th and the 5
-th element);
[4,8,3]
 (the 3
-rd, the 4
-th and the 5
-th element);
[4,2,8,3]
 (the 1
-st, the 2
-nd, the 4
-th and the 5
-th element);
[4,4,8,3]
 (the 1
-st, the 3
-rd, the 4
-th and the 5
-th element);
[4,2,4,8,3]
 (the whole sequence).
In the second example, the only valid subsequence is the given sequence itself.

#include<bits/stdc++.h>
 
using namespace std;
 
const int MOD = 998244353;
const int N = 1000043;
 
int add(int x, int y)
{
    x += y;
    while(x >= MOD) x -= MOD;
    while(x < 0) x += MOD;
    return x;
}
 
int mul(int x, int y)
{
    return (x * 1ll * y) % MOD;
}   
 
int binpow(int x, int y)
{
    int z = 1;
    while(y > 0)
    {
        if(y % 2 == 1) z = mul(z, x);
        x = mul(x, x);
        y /= 2;
    }
    return z;
}
 
vector<int> get(const vector<int>& a)
{
    int cur = -1;
    vector<int> res;
    for(auto x : a)
        if(x > cur)
        {
            res.push_back(x);
            cur = x;
        }
    return res;
}
 
struct SegTree
{
    vector<int> f;
    vector<int> t;
    int n;
 
    int getVal(int v, int pos)
    {
        return mul(t[pos], binpow(2, f[v]));
    }   
 
    void push(int v)
    {
        if(f[v] != 0)
        {
            f[2 * v + 1] += f[v];
            f[2 * v + 2] += f[v];
            f[v] = 0;
        }
    }
 
    void resolve(int v, int pos)
    {
        if(f[v] != 0)
        {
            t[pos] = mul(t[pos], binpow(2, f[v]));
            f[v] = 0;    
        }
    }
 
    int get(int v, int l, int r, int pos)
    {
        if(l == r - 1)
            return getVal(v, pos);
        else
        {
            push(v);
            int m = (l + r) / 2;
            if(pos < m)
                return get(v * 2 + 1, l, m, pos);
            else
                return get(v * 2 + 2, m, r, pos);
        }
    }
 
    int get(int pos)
    {
        return get(0, 0, n, pos);
    }
 
    void inc(int v, int l, int r, int pos, int val)
    {
        if(l == r - 1)
        {
            resolve(v, pos);
            t[pos] = add(t[pos], val);
        }
        else
        {
            push(v);
            int m = (l + r) / 2;
            if(pos < m)
                inc(v * 2 + 1, l, m, pos, val);
            else
                inc(v * 2 + 2, m, r, pos, val);
        }
    }
 
    void inc(int pos, int val)
    {
        return inc(0, 0, n, pos, val);
    }
 
    void mulBy2(int v, int l, int r, int L, int R)
    {
        if(L >= R) return;
        if(l == L && r == R)
            f[v]++;
        else
        {
            push(v);
            int m = (l + r) / 2;
            mulBy2(v * 2 + 1, l, m, L, min(R, m));
            mulBy2(v * 2 + 2, m, r, max(L, m), R);
        }
    }
 
    void mulBy2(int l, int r)
    {
        mulBy2(0, 0, n, l, r);   
    }
 
    SegTree(int n = 0)
    {
        this->n = n;
        f.resize(4 * n);
        t.resize(n);
    }
};
 
vector<int> calc(const vector<int>& a, const vector<int>& b)
{
    int n = a.size();
    int m = b.size();
    SegTree tree(m + 1);
    tree.inc(0, 1);
    vector<int> res(n);
    int maxVal = b.back();
    for(int i = 0; i < n; i++)
    {
        int x = a[i];
        if(x > maxVal) continue;
        else
        {
            if (x == maxVal) res[i] = tree.get(m - 1);
            int lf = lower_bound(b.begin(), b.end(), x) - b.begin();
            tree.mulBy2(lf + 1, m + 1);
            if(b[lf] == x)
            {
                int cur = tree.get(lf);
                tree.inc(lf + 1, cur);
            }
        }
    }
    return res; 
}   
 
void solve()
{
    int n;
    cin >> n;
    vector<int> a(n);
    for(int i = 0; i < n; i++)
        cin >> a[i];
    auto left_view = get(a);
    reverse(a.begin(), a.end());
    auto right_view = get(a);
    reverse(a.begin(), a.end());
 
    auto dpL = calc(a, left_view);
    reverse(a.begin(), a.end());
    auto dpR = calc(a, right_view);
    reverse(a.begin(), a.end());
    reverse(dpR.begin(), dpR.end());
 
    int maxVal = *max_element(a.begin(), a.end());
    int ans = 0;
    int sumLeft = 0;
    for(int i = 0; i < n; i++)
    {
        if(a[i] > maxVal) continue;
        else
        {   
            if(a[i] == maxVal) ans = add(ans, mul(add(sumLeft, dpL[i]), dpR[i]));
            sumLeft = mul(sumLeft, 2);
            if(a[i] == maxVal) sumLeft = add(sumLeft, dpL[i]);
        }
    }
    cout << ans << endl;
}
 
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);    
    int t;
    cin >> t;
    for(int i = 0; i < t; i++) solve();
}
