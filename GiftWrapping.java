import java.util.ArrayList;
import java.util.List;

public class GiftWrapping {

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

	private List<int[]> giftWrap(int[][] arr) {
		// finding leftmost point.
		int left = 0, n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[i][0] < arr[left][0])
				left = i;
		}
		// gift-wrapping
		int prev = left, current;
		List<int[]> ans = new ArrayList<int[]>();
		ans.add(arr[left]);
		do {
			current = (prev + 1) % n;//select any point other than prev.
			//find next ccw in order.
			for (int i = 0; i < n; i++) {
				if (left(arr[prev][0], arr[prev][1], arr[i][0], arr[i][1], arr[current][0], arr[current][1]))
					current = i;
			}
			ans.add(arr[current]);
			prev = current;
		} while (prev != left);
		return ans;
	}

	public GiftWrapping() {
		int arr[][] = { { 0, 3 }, { 4, 2 }, { 3, 5 }, { 5, 3 }, { 3, 0 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
		List<int[]> ans = giftWrap(arr);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i)[0] + ":" + ans.get(i)[1]);
		}
	}

	public static void main(String[] args) {
		new GiftWrapping();
	}
}
