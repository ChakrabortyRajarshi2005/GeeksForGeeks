Compare and Connect
There is a multiset 
S
S containing 
N
+
M
N+M strings, 
N
N of which are "
<
<" and 
M
M of which are "
>
>".

For two strings 
s
s and 
t
t, 
f
(
s
,
t
)
f(s,t) is defined as:

If 
s
s is smaller than 
t
t in lexicographical order, 
f
(
s
,
t
)
=
s
+
f(s,t)=s+ "
<
<" 
+
t
+t;

If 
s
s is equal to 
t
t in lexicographical order, 
f
(
s
,
t
)
=
s
+
f(s,t)=s+ "
=
=" 
+
t
+t;

If 
s
s is larger than 
t
t in lexicographical order, 
f
(
s
,
t
)
=
s
+
f(s,t)=s+ "
>
>" 
+
t
+t;

You need to perform 
N
+
M
−
1
N+M−1 operations. Each time, choose two strings 
s
s and 
t
t in 
S
S, insert 
f
(
s
,
t
)
f(s,t) to 
S
S and erase 
s
s and 
t
t from 
S
S.

Finally, only one string remains in 
S
S. Find the lexicographically smallest possible final string.

In lexicographical order, string are compared based on their characters from left to right, similar to how words are ordered in a dictionary. The comparison follows these rules:

The first character of each string is compared. The string with the smaller character (based on its ASCII value) is considered smaller.
If the first characters are the same, the second characters are compared, and so on, until a difference is found.
If one string is a prefix of the other, the shorter string is considered smaller.
In this context, the characters "
<
<", "
=
=", and "
>
>" have the following lexicographical order:

"
<
<" is the smallest (ASCII value 60),
"
=
=" is the second (ASCII value 61),
"
>
>" is the largest (ASCII value 62).
Input Format
The first line of input will contain a single integer 
T
T, denoting the number of test cases.
Each test case consists of multiple lines of input.
The only line of each test case contains two space-separated integers 
N
N and 
M
M.
Output Format
For each test case, output the lexicographically smallest possible final string.

Constraints
1
≤
T
≤
10
4
1≤T≤10 
4
 
0
≤
N
,
M
≤
2
⋅
10
5
0≤N,M≤2⋅10 
5
 
N
+
M
≥
2
N+M≥2
The sum of 
N
N and 
M
M over all test cases won't exceed 
2
⋅
10
5
2⋅10 
5
 , respectively.
Sample 1:
Input
Output
3
0 2
2 3
2 1
>=>
<<<<><><>
<<<<>
Explanation:
Test Case 
1
1:

At first, 
S
=
{
"
S={">
"
,
"
",">
"
}
"}.

You choose two strings 
s
=
"
s=">
"
" and 
t
=
"
t=">
"
" in 
S
S, insert 
f
(
s
,
t
)
=
"
f(s,t)=">
=
=>
"
" to 
S
S and erase 
s
s and 
t
t from 
S
S.

After that, 
S
=
{
"
S={">
=
=>
"
}
"}. The answer is 
"
">
=
=>
"
".
#include <bits/stdc++.h>

using namespace std;
void s() {
    int n, m;
    cin >> n >> m;

    if (n >= 1 && m >= 1) {
        for (int i = 0; i < 2 * n; ++i) {
            cout << '<';
        }
        for (int i = 0; i < m - 1; ++i) {
            cout << "><";
        }
        cout << '>';

    } else if (m == 0) {
        for (int i = 0; i < 2 * n - 3; ++i) {
            cout << '<';
        }
        cout << "=<";

    } else {
        for (int i = 0; i < m - 2; ++i) {
            cout << "><";
        }
        cout << ">=>";
    }
    cout << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        s();
    }
}
