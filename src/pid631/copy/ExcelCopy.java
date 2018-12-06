package me.bai.LeetCode.pid631.copy;

public class ExcelCopy {
	int[][] g;
	int[] vs;
	int[] ord;
	boolean[] issum;

	public ExcelCopy(int H, char W) {
		g = new int[676][676];
		vs = new int[676];
		ord = new int[676];
		issum = new boolean[676];
		for (int i = 0; i < 676; i++)
			ord[i] = i;
	}

	public void set(int r, char cc, int v) {
		r--;
		int c = cc - 'A';
		int x = r * 26 + c;
		for (int i = 0; i < 676; i++)
			g[i][x] = 0;
		vs[x] = v;
		issum[x] = false;
		recalc();
	}

	private void recalc() {
		ord = sortTopologically(g);
		for (int i = 0; i < 676; i++) {
			if (!issum[ord[i]])
				continue;
			vs[ord[i]] = 0;
			for (int j = 0; j < 676; j++) {
				vs[ord[i]] += vs[j] * g[j][ord[i]];
			}
		}
	}

	public int get(int r, char cc) {
		r--;
		int c = cc - 'A';
		int x = r * 26 + c;
		return vs[x];
	}

	public int[] get(String t) {
		int c = t.charAt(0) - 'A';
		int r = Integer.parseInt(t.substring(1)) - 1;
		return new int[] { r, c };
	}

	public int sum(int r, char cc, String[] strs) {
		r--;
		int c = cc - 'A';
		int x = r * 26 + c;
		for (int i = 0; i < 676; i++)
			g[i][x] = 0;
		issum[x] = true;
		for (String s : strs) {
			int colon = s.indexOf(':');
			if (colon >= 0) {
				int[] one = get(s.substring(0, colon));
				int[] two = get(s.substring(colon + 1));
				for (int j = Math.min(one[0], two[0]); j <= Math.max(one[0], two[0]); j++) {
					for (int k = Math.min(one[1], two[1]); k <= Math.max(one[1], two[1]); k++) {
						g[j * 26 + k][x]++;
					}
				}
			} else {
				int[] one = get(s);
				g[one[0] * 26 + one[1]][x]++;
			}
		}
		recalc();
		return get(r + 1, cc);
	}

	public int[] sortTopologically(int[][] g) {
		int n = g.length;
		int[] ec = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] > 0) {
					ec[j]++;
				}
			}
		}
		int[] ret = new int[n];
		int p = 0;
		int q = 0;

		ost: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[j][i] > 0)
					continue ost;
			}
			ret[q++] = i;
		}

		for (; p < q; p++) {
			int cur = ret[p];
			for (int i = 0; i < n; i++) {
				if (g[cur][i] > 0) {
					ec[i]--;
					if (ec[i] == 0)
						ret[q++] = i;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (ec[i] > 0) {
				return null;
			}
		}
		return ret;
	}

}
