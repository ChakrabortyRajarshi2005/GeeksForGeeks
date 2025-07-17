Power of k in factorial of n
Difficulty: MediumAccuracy: 51.2%Submissions: 14K+Points: 4
Given two positive integers n and k, determine the highest value of x such that kx divides n! (n factorial) completely (i.e., n % (kx) == 0).

Examples :

Input: n = 7, k = 2
Output: 4
Explanation: 7! = 5040, and 24 = 16 is the highest power of 2 that divides 5040.
Input: n = 10, k = 9
Output: 2
Explanation: 10! = 3628800, and 9² = 81 is the highest power of 9 that divides 3628800.
Constraints:
1 ≤ n ≤ 105
2 ≤ k ≤ 105
class Solution {
    public ArrayList<int[]> primeFactors(int num) {
        ArrayList<int[]> factors = new ArrayList<>();

        int count = 0;
        while (num % 2 == 0) {
            num /= 2;
            count++;
        }
        if (count > 0) factors.add(new int[] {2, count});
        for (int i = 3; i * i <= num; i += 2) {
            count = 0;
            while (num % i == 0) {
                num /= i;
                count++;
            }
            if (count > 0) factors.add(new int[] {i, count});
        }
        if (num > 1) factors.add(new int[] {num, 1});

        return factors;
    }
    public int legendre(int n, int p) {
        int count = 0;
        for (long power = p; power <= n; power *= p) {
            count += n / power;
        }
        return count;
    }
    public int maxKPower(int n, int k) {
        ArrayList<int[]> factors = primeFactors(k);

        int result = Integer.MAX_VALUE;
        for (int[] factor : factors) {
            int prime = factor[0];
            int expInK = factor[1];
            int countInFact = legendre(n, prime);
            result = Math.min(result, countInFact / expInK);
        }

        return result;
    }
}
