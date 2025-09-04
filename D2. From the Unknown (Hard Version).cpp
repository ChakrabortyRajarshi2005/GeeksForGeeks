D2. From the Unknown (Hard Version)
time limit per test3 seconds
memory limit per test512 megabytes

This is the hard version of the problem. The difference between the versions is that in this version, the sum of the lengths of the articles over all queries must not exceed 2.5⋅104
. You can hack only if you solved all versions of this problem.

This is an interactive problem.

The RiOI Team has recently developed a text editor named RiOI Editor. The editor works with exactly one integer parameter W
 — the width of each line. It is known that 1≤W≤105
.

As you cannot understand the RiOI Language, from your point of view, words differ from each other only by their length. Hence, an article of length n
 is defined as a sequence a
 consisting of n
 positive integers, where ai
 is the length of the i
-th word in the article. The RiOI Editor displays the article [a1,a2,…,an]
 on screen as follows:

If max(a1,a2,…,an)>W
, the editor is unable to display the article;
Otherwise, the editor is able to display the article by the following process:
Initially, l=1
, and s=0
. During the whole process, l
 always denotes the current number of lines in the editor, and s
 always denotes the sum of lengths of words in the last line;
Then, for each 1≤i≤n
:
If s+ai≤W
, the word is inserted at the end of the current line. Thus, l
 remains unchanged, and s
 gets increased by ai
.
Otherwise, the word is inserted into a new line. Thus, l
 becomes l+1
, and s
 becomes ai
.
The number of lines needed to display the article is the final value of l
.
You are very interested in the editor, so you decide to find out the value of W
 by inputting some articles into the editor and observing the number of lines needed to display each article.

Formally, you can query the jury at most 2
 times. In each query, you input an article [a1,a2,…,an]
 (1≤n≤105
) to the editor, and the jury will respond to you with:

The number of lines needed to display the article, if the editor is able to display it;
0
, if the editor is unable to display the article.
Additional constraint in this version: the sum of the lengths of the articles (i.e., n
) over all queries must not exceed 2.5⋅104
.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤10
). The description of the test cases follows.

Interaction
For each test case, you can make up to 2
 queries to find out the value of W
. It is guaranteed that 1≤W≤105
.

To make a query, you should print a new line in the following format:

? n a1 a2 … an
 (1≤n,ai≤105
) — the article you input to the editor.
The sum of n
 over all queries must not exceed 2.5⋅104
.

At the end of each query, the jury will print an integer, as described in the statements.

To report that you have found the value of W
, print a new line in the following format:

! W
 — the parameter of the editor.
Printing the answer does not count as one of the 2
 queries.

After that, proceed to process the next test case or terminate the program if it was the last test case.

After printing each query do not forget to output the end of line and flush∗
 the output. Otherwise, you will get Idleness limit exceeded verdict.

If, at any interaction step, you read −1
 instead of valid data, your solution must exit immediately. This means that your solution will receive Wrong answer because of an invalid query or any other mistake. Failing to exit can result in an arbitrary verdict because your solution will continue to read from a closed stream.

The interactor in this problem is adaptive. It means that the value of W
 may change during the interaction, but it is guaranteed that there is always at least one integer W
 satisfying all the queries.

Hacks

To perform a hack, only the following format is available:

The first line of the input contains an integer t
 (1≤t≤10
) — the number of test cases. Then, output a string "manual" in the same line.

The only line of each test case contains a single integer W
 (1≤W≤105
) — the parameter of the editor.

The hacking format for the example is as follows.

2 manual
20
1
∗
To flush, use:

fflush(stdout) or cout.flush() in C++;
sys.stdout.flush() in Python;
see the documentation for other languages.
Example
InputCopy
2

2

1


0

OutputCopy

? 5 1 9 4 6 1

? 2 10 10

! 20
? 1 2

! 1
Note
In the first test case:

For the first query, the total length of the words is 1+9+4+6+1=21
, and the article is displayed in two lines, so W<21
;
For the second query, the total length of the words is 10+10=20
, and the article is displayed in one line, so W≥20
.
Thus, we have determined W=20
.

In the second test case, the editor cannot display the article in the only query. Thus, W<2
, so it can only be 1
.

#include <bits/stdc++.h>
using namespace std;

const int MAXW = 100'000;
const int MAXSUM = 25'000;
const int B = 116;
const int K = 11343;

int t;

inline int ask(vector<int> v) {
  cout << "? " << v.size();
  for (int i : v) {
    cout << ' ' << i;
  }
  cout << endl;
  int x;
  cin >> x;
  if (x == -1) {
    exit(0);
  }
  return x;
}
inline void answer(int x) { cout << "! " << x << endl; }

int main() {
  cin >> t;
  while (t--) {
    vector<int> v_qry1(K, B);
    int res_qry1 = ask(v_qry1);
    if (res_qry1 == 0) {
      // W < B
      vector<int> v_qry2(B * B, 1);
      int res_qry2 = ask(v_qry2);
      int w = (B * B - 1) / (res_qry2 - 1);
      answer(w);
    } else {
      // W >= B
      int min_w = ((K - 1) / res_qry1 + 1) * B,
          max_w = ((K - 1) / (res_qry1 - 1) + 1) * B - 1;
      max_w = min(max_w, MAXW);
      for (int w = B; w <= MAXW; w++) {
        int h = (K - 1) / (w / B) + 1;
        if (h == res_qry1) {
          assert(min_w <= w);
          assert(w <= max_w);
        } else {
          assert(w < min_w || w > max_w);
        }
      }

      if (min_w == max_w) {
        answer(min_w);
      } else {
        vector<int> v_qry2;
        for (int i = min_w + 2; i <= max_w; i++) {
          v_qry2.push_back(min_w + 1);
          v_qry2.push_back(i - min_w - 1);
        }
        if (v_qry2.empty()) {
          v_qry2.push_back(min_w + 1);
        }
        int res_qry2 = ask(v_qry2);

        if (res_qry2 == 0) {
          answer(min_w);
        } else {
          answer(min_w + 1 + ((int)v_qry2.size() - res_qry2));
        }
      }
    }
  }
}
