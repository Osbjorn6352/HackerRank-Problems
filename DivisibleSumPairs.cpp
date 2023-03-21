#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'divisibleSumPairs' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER_ARRAY ar
 */

int divisibleSumPairs(int n, int k, vector<int> ar) {
    int res = 0;
    int arlen = ar.size();
    for (int i = 0; i < arlen; i ++) {
        for (int j = i + 1; j < arlen; j++) {
            if (i == j);
            else {
                if ((ar[i] + ar[j]) % k == 0) res++;
            }
        }
    }
    return res;
}
