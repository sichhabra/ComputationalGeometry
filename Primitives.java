import java.awt.Point;

public class Primitives {

	public int area(Point a, Point b, Point c) {
		return (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
	}

	public boolean left(Point a, Point b, Point c) {
		return area(a, b, c) > 0;
	}

	public boolean leftOn(Point a, Point b, Point c) {
		return area(a, b, c) >= 0;
	}

	public boolean colinear(Point a, Point b, Point c) {
		return area(a, b, c) == 0;
	}

	public boolean intersect(Point a, Point b, Point c, Point d) {
		if (colinear(a, b, c) || colinear(a, b, d) || colinear(b, c, d) || colinear(a, c, d))
			return false;
		return (left(a, b, c) ^ left(a, b, d)) && (left(c, d, a) ^ left(c, d, b));
	}

	public boolean between(Point a, Point b, Point c) {
		if (!colinear(a, b, c))
			return false;
		if (a.x != b.x)
			return (a.x <= c.x && c.x <= b.x) || (a.x >= c.x && c.x >= b.x);
		else
			return (a.y <= c.y && c.y <= b.y) || (a.y >= c.y && c.y >= b.y);
	}

	public Primitives() {

	}

	public static void main(String[] args) {
		new Primitives();
	}

}
