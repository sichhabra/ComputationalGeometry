
public class Vectors {

	public int[] add(int a[], int b[]) {
		return new int[] { a[0] + b[0], a[1] + b[1] };
	}

	public double dist(int a[], int b[]) {
		int d1 = a[0] - b[0];
		int d2 = a[1] - b[1];
		return Math.sqrt(d1 * d1 + d2 * d2);
	}
	
	public double val(int a[]) {
		return Math.sqrt(a[0]*a[0]+a[1]*a[1]);
	}

	public Vectors() {

	}

	public static void main(String[] args) {
		new Vectors();
	}

}
