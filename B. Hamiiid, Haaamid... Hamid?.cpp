B. Hamiiid, Haaamid... Hamid?
time limit per test1 second
memory limit per test256 megabytes

Mani has locked Hamid in a 1×n
 grid. Initially, some cells of the grid contain walls and the rest are empty, and Hamid is in an empty cell.

In each day, the following events happen in order:

Mani selects an empty cell and builds a wall in that cell. Note that he can not build a wall in the cell which Hamid currently is at;
Hamid selects a direction (left or right), then
If there are no walls in that direction, he will escape the grid;
Otherwise, he will move to the nearest wall in that direction and destroy that wall. Hamid is at the position of the destroyed wall after this day.
Here is an example of a possible sequence of actions when n=6
:


Hamid is always aware of where the walls are. He wants to minimize the number of days that he needs to escape the grid, while Mani wants to maximize it.

You have to determine the number of days Hamid needs to escape the grid if they both act optimally.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤104
). The description of the test cases follows.

The first line of each test case contains two integers n
 and x
 (2≤n≤2⋅105
, 1≤x≤n
) — the size of the grid and the initial position of Hamid. He is at the x
-th cell from left to right initially.

The second line contains a string s
 of length n
 (si="#"
 or "."
) — the initial state of the grid. The i
-th cell of the grid contains a wall if si="#"
, and it is empty if si="."
.

It is guaranteed that the x
-th cell is empty, and there are at least two empty cells in the grid.

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, output a single integer — the number of days Hamid needs to escape the grid if they both act optimally.

Example
InputCopy
4
3 1
..#
4 2
....
5 3
##..#
6 4
#...#.
OutputCopy
1
1
3
3
Note
In the first test case, Mani must build a wall in cell 2
, so Hamid can escape from the left side of the grid on the first day.

In the second test case, if Mani places the wall to the left of Hamid, Hamid can escape from the right. And if the wall is to Hamid's right, he can escape from the left. Thus, the answer is 1
.

In the third test case:


It can be shown that both players acted optimally in the above illustration.

In the fourth test case, we have shown an example of actions in the statements. Note that the players did not act optimally in this example.



#include<bits/stdc++.h>
using namespace std;

int32_t main() {
    cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
    int tc;
    cin >> tc;
    while(tc--) {
        int n, x;
        string s;
        cin >> n >> x >> s;
        if(x==1 || x==n) {
            cout << "1\n";
            continue;
        }
        x--;
        int inf = 1e9;
        int lf=-inf, rg=inf;
        for(int i=x-1; i>=0; i--)
            if(s[i]=='#') {
                lf=i;
                break;
            }
        for(int i=x+1; i<n; i++)
            if(s[i]=='#') {
                rg=i;
                break;
            }
        if(lf==-inf && rg==inf) {
            cout << "1\n";
            continue;
        }
        cout << max(min(x+1, n-rg+1), min(lf+2, n-x)) << '\n';
    }
    return 0;
}
