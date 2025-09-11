Maximum MST
There was a weighted undirected complete graph on 
N
N vertices with 
M
=
N
⋅
(
N
−
1
)
2
M= 
2
N⋅(N−1)
​
  edges, one edge between every pair of vertices.

Unfortunately, the weights have been scrambled, and while we have recovered the multiset of weights, we do not know which edge had which weight. You are given a sequence 
W
1
,
W
2
,
…
,
W
M
W 
1
​
 ,W 
2
​
 ,…,W 
M
​
 .

Among all possible assignments of weights, what is the maximum possible value of the minimum spanning tree
†
†
 ?

†
†
  The minimum spanning tree is a subset of 
N
−
1
N−1 edges, with minimum sum of weights in the subset, such that it is possible to reach any vertex from any other vertex using only edges in this subset.

Input Format
The first line of input will contain a single integer 
T
T, denoting the number of test cases.
Each test case consists of multiple lines of input.
The first line of each test case contains 
N
N - the number of vertices in the graph.
The second line contains 
M
M integers - 
W
1
,
W
2
,
…
,
W
M
W 
1
​
 ,W 
2
​
 ,…,W 
M
​
 .
Output Format
For each test case, output on a new line the maximum possible value of minimum spanning tree over all assignments of weights.

Constraints
1
≤
T
≤
100
1≤T≤100
2
≤
N
≤
50
2≤N≤50
1
≤
W
i
≤
10
7
1≤W 
i
​
 ≤10 
7
 
Sample 1:
Input
Output
3
2
42
3
1 2 3
4
5 5 5 5 5 5
42
3
15
Explanation:
Test Case 1 : There is only one edge, which must be part of the MST. Thus, the only possible MST value is 
42
42.

Test Case 2 : We can assign the edge 
(
1
,
2
)
(1,2) as weight 
1
1, edge 
(
1
,
3
)
(1,3) as weight 
2
2 and edge 
(
2
,
3
)
(2,3) as weight 
3
3. Then, the MST consists of the edges 
(
1
,
2
)
(1,2) and 
(
1
,
3
)
(1,
#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    std::cin >> t;
    while(t>0){
        t--;
        int n;
        std::cin >> n;
        int size=n*(n-1)/2;
        std::vector<int>arr(size);
        for(int i=0;i<size;i++){
            std::cin >> arr[i];
        }
        int ans;
        sort(arr.begin(),arr.end());
        if(n<4){
            if(n==2) ans=arr[0];
            if(n==3) ans=arr[0]+arr[1];
        }
        if(n>=4){
            ans=arr[0];
            int k=1;
            for(int i=1;i<size;i+=k){
                ans+=arr[i];
                k++;
            }
        }
        std::cout << ans << std::endl;
    }

}
