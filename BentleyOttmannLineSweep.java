import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

//Usual Ottmann Bentley Sweep Algorithm Report Mode.
public class BentleyOttmannLineSweep {

	class Event {
		Point point;
		boolean isTop = false;
		boolean isBottom = false;

		public Event(Point point) {
			this.point = point;
		}
	}

	class Segment {
		int value;
	}

	List<Point> sweep(Point line[][]) {

		Queue<Event> queue = new PriorityQueue<Event>(new Comparator<Event>() {
			public int compare(Event a, Event b) {
				return (a.point.y == b.point.y) ? (b.point.x - a.point.x) : (a.point.y - b.point.y);
			}
		});

		for (Point point[] : line) {
			Event a = new Event(point[0]);
			a.isTop = true;
			Event b = new Event(point[1]);
			b.isBottom = true;
			queue.add(a);
			queue.add(b);
		}

		NavigableSet<Segment> status = new TreeSet<Segment>(new Comparator<Segment>() {
			public int compare(Segment a, Segment b) {
				return (b.value - a.value);
			}
		});

		List<Point> intersections = new ArrayList<Point>();

		while (!queue.isEmpty()) {
			Event e=queue.poll();
			if(e.isTop) {
				//add the segment in status at position based on current x coordinates and check for 2 intersections.
			}
			else if(e.isBottom) {
				//remove the segment in status and check for a intersection.
			}
			else {
				//swap the two segments and check for 2 intersections.
			}
		}

		return intersections;
	}

	public BentleyOttmannLineSweep() {
		Point line[][] = new Point[4][2];

		line[0][0] = new Point(0, 0);
		line[0][1] = new Point(2, 2);

		line[1][0] = new Point(2, 0);
		line[1][1] = new Point(0, 2);

		line[2][0] = new Point(0, 0);
		line[2][1] = new Point(2, 1);

		line[3][0] = new Point(2, 1);
		line[3][1] = new Point(0, 2);

		List<Point> report = sweep(line);
		for (int i = 0; i < report.size(); i++)
			System.out.println(report.get(i).x + ":" + report.get(i).y);
	}

	public static void main(String[] args) {
		new BentleyOttmannLineSweep();
	}

}
