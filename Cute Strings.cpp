Cute Strings
A string 
S
S of length 
3
3 is called cute if it satisfies the following conditions:

S
1
=
S
3
S 
1
​
 =S 
3
​
 , i.e. its first and last characters are equal, and
S
2
=
w
S 
2
​
 =w, i.e. its middle character is w.
Some examples of cute strings are "owo", "uwu", and "qwq"; whereas "wwf" and "oco" are examples of strings that are not cute.

You are given a string 
S
S of length 
3
3. Is it cute?

Input Format
The first and only line of input contains a string 
S
S of length 
3
3.
Output Format
On a single line, output the answer: "Cute" (without quotes) if 
S
S is a cute string, and "No" (without quotes) otherwise.

Each character may be printed in either uppercase or lowercase, i.e. the strings NO, No, nO, and no will all be treated as equivalent.

Constraints
S
S has length 
3
3.
Each character of 
S
S is a lowercase English letter, i.e. one of 
{
’a’, ’b’, 
…
,
’z’
}
{’a’, ’b’, …,’z’}.
Sample 1:
Input
Output
owo
Cute
Explanation:
"owo" is a cute string, because its middle character is w and its first and third characters are equal.

Sample 2:
Input
Output
pwp
Cute
Explanation:
"pwp" is a cute string, because its middle character is w and its first and third characters are equal.

Sample 3:
Input
Output
pvp
No
Explanation:
"pvp" is not a cute string, because its middle character is not w.

Sample 4:
Input
Output
awe
No
Explanation:
"awe" is not a cute string, because its first and third characters don't match.

#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	string k;
	cin >> k;
	
	if ( k[0] == k[2] && k[1] == 'w' ) {
	    cout << "Cute" << endl;
	}
	
	else {
	    cout << "No" << endl;
	}

}
