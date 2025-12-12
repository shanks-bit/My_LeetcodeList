// leetcode -> https://www.geeksforgeeks.org/dsa/longest-common-substring-dp-29/

int countCommon(string a, string b, int m, int n) {
	int t[m + 1][n + 1];
	int best_count = 0;

	for (int i = 1; i < m + 1; i++)
		for (int j = 1; j < n + 1; j++)
			if (a[i - 1] == b[j - 1]) {
				t[i][j] = 1 + t[i - 1][j - 1];
				best_count = max(t[i][j], best_count);
			}
			else
				// it will be 0 bcoz it is  a substring not subsequence
				t[i][j] = 0;

	return best_count;
}
