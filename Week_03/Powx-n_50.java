// 1. ѭ�������� O(n)
// 2. ������ ������ O(logn)
// terminator; process; drill down, merge; reverse states

// Pow(x, n ):
//     subproblem: subresult = pow(x, n/2)

//     merge:
//     if n % 2 == 1{
//         //odd
//         result = subresult * subresult * x;
//     } else {
//         // even
//         result = subresult * subresult
//     }


// �ⷨ2 ������+�ݹ� �ռ�O(logn)
class Solution {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}

// �ⷨ3 ������+���� �ռ�O(1)


//��һ��
