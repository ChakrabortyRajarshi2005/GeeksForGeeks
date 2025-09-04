# cook your dish here
import sys

input = sys.stdin.readline
II = lambda: int(input())
MI = lambda: map(int, input().split())
LI = lambda: [int(a) for a in input().split()]
SI = lambda: input().rstrip()

mod = 998244353


def precompute(max_n: int):
    M = 2 * max(1, max_n)
    fact = [1] * (M + 5)
    invfact = [1] * (M + 5)
    for i in range(1, M + 5):
        fact[i] = fact[i - 1] * i % mod
    invfact[M + 4] = pow(fact[M + 4], mod - 2, mod)
    for i in range(M + 4, 0, -1):
        invfact[i - 1] = invfact[i] * i % mod
    pow2 = [1] * (M + 5)
    for i in range(1, M + 5):
        pow2[i] = (pow2[i - 1] << 1) % mod
    return fact, invfact, pow2


def C(n: int, r: int, fact, invfact):
    if r < 0 or r > n or n < 0:
        return 0
    return fact[n] * invfact[r] % mod * invfact[n - r] % mod


def solve():
    T = II()
    arrN = [0] * T
    arrS = [""] * T
    mx = 0
    for ti in range(T):
        n = II()
        s = SI()
        arrN[ti] = n
        arrS[ti] = s
        if n > mx:
            mx = n
    fact, invfact, pow2 = precompute(mx)
    out = []
    for ti in range(T):
        n = arrN[ti]
        s = arrS[ti]
        if '1' not in s:
            m = n - 1
            out.append(str(C(2 * m, m, fact, invfact)))
            continue
        # collect runs of consecutive '1's
        pos = []
        for i, ch in enumerate(s, start=1):
            if ch == '1':
                pos.append(i)
        runs = []
        i = 0
        mpos = len(pos)
        while i < mpos:
            j = i
            while j + 1 < mpos and pos[j + 1] == pos[j] + 1:
                j += 1
            runs.append((pos[i], pos[j]))
            i = j + 1

        ans = 1
        # head and tail zero blocks contribute Catalan-like factors Z(L) = C(2*(L-1), L-1)
        # Here implemented via factorial tables modulo mod
        head = runs[0][0] - 1
        if head >= 1:
            m0 = head - 1
            ans = ans * C(2 * m0, m0, fact, invfact) % mod
        tail = n - runs[-1][1]
        if tail >= 1:
            m2 = tail - 1
            ans = ans * C(2 * m2, m2, fact, invfact) % mod
        # internal gaps between runs also contribute Z(gap)
        for (l1, r1), (l2, r2) in zip(runs, runs[1:]):
            gap = l2 - r1 - 1
            if gap >= 1:
                m1 = gap - 1
                ans = ans * C(2 * m1, m1, fact, invfact) % mod
        # per-run multiplicative factors
        for l, r in runs:
            k = r - l + 1
            if k == 1:
                if l == 1 and r == n:
                    F = 1
                elif l == 1 or r == n:
                    F = 2
                else:
                    F = 6
            else:
                boundary_count = (1 if l > 1 else 0) + (1 if r < n else 0)
                F = pow2[(k - 1) + boundary_count]
            ans = ans * F % mod
        out.append(str(ans))
    print("\n".join(out))


if __name__ == '__main__':
    solve()

class Solution {
  public:
    Node *reverseKGroup(Node *head, int k) {
        if (head == nullptr) {
            return head;
        }

        Node *curr = head;
        Node *newHead = nullptr;
        Node *tail = nullptr;

        while (curr != nullptr) {
            Node *groupHead = curr;
            Node *prev = nullptr;
            Node *nextNode = nullptr;
            int count = 0;

            // Reverse the nodes in the current group
            while (curr != nullptr && count < k) {
                nextNode = curr->next;
                curr->next = prev;
                prev = curr;
                curr = nextNode;
                count++;
            }

            // If newHead is null, set it to the
            // last node of the first group
            if (newHead == nullptr) {
                newHead = prev;
            }

            // Connect the previous group to the
            // current reversed group
            if (tail != nullptr) {
                tail->next = prev;
            }

            // Move tail to the end of the reversed group
            tail = groupHead;
        }

        return newHead;
    }
};
