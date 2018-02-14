import java.util.HashSet;

public class ConvexHull {

	/* finding orientation */

	public void cofactor(int arr[][], int temp[][], int p, int q, int n) {
		int i = 0, j = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (row != p && col != q)
					temp[i][j++] = arr[row][col];
				if (j == n - 1) {
					j = 0;
					i++;
				}
			}
		}
	}

	public int determinant(int arr[][], int n) {
		if (n == 1)
			return arr[0][0];
		int D = 0, temp[][] = new int[n][n], sign = 1;
		for (int f = 0; f < n; f++) {
			cofactor(arr, temp, 0, f, n);
			D += sign * arr[0][f] * determinant(temp, n - 1);
			sign = -sign;
		}
		return D;
	}

	public int orient(int x1, int y1, int x2, int y2, int x3, int y3) {
		int arr[][] = { { 1, x1, y1 }, { 1, x2, y2 }, { 1, x3, y3 } };
		return determinant(arr, 3);
	}

	public boolean left(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (orient(x1, y1, x2, y2, x3, y3) > 0);
	}

	public boolean right(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (orient(x1, y1, x2, y2, x3, y3) < 0);
	}

	public boolean on(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (orient(x1, y1, x2, y2, x3, y3) == 0);
	}

	/*-----------------------------------------------*/

	class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object o) {
			Point p = (Point) o;
			return (p.x == x && p.y == y);
		}

		public int hashCode() {
			return new Integer(x + "0" + y);
		}
	}

	public int[][] convexHullN3(int p[][]) {
		int n = p.length;
		HashSet<Point> set = new HashSet<Point>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					set.add(new Point(i, j));
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					for (int k = 0; k < n; k++) {
						if (j != k && i != k) {
							if (left(p[i][0], p[i][1], p[j][0], p[j][1], p[k][0], p[k][1])) {
								set.remove(new Point(i, j));
							}
						}
					}
				}
			}
		}
		int m = set.size();
		int ans[][] = new int[m][2];
		int o = 0;
		for (Point point : set) {
			ans[o][0] = point.x;
			ans[o++][1] = point.y;
		}
		return ans;
	}

	public ConvexHull() {
		int arr[][] = { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 2 }, { 2, 0 } };
		int ans[][] = convexHullN3(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + ":" + ans[i][1]);
		}
	}

	public static void main(String[] args) {
		new ConvexHull();
	}

}
