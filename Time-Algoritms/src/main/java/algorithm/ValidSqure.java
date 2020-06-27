package algorithm;

import java.util.TreeSet;

public class ValidSqure {
	public static double distance(Point p1, Point p2) {
		return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		TreeSet<Point> s = new TreeSet<>((x, y) -> x.x == y.x ? x.y - y.y : x.x - y.x);
		s.add(new Point(p1[0], p1[1]));
		s.add(new Point(p2[0], p2[1]));
		s.add(new Point(p3[0], p3[1]));
		s.add(new Point(p4[0], p4[1]));
		if (s.size() < 4)
			return false;
		TreeSet<Point> s1 = new TreeSet<>((x, y) -> x.x == y.x ? y.y - x.y : y.x - x.x);
		Point point1 = s.pollFirst();
		Point point2 = s.pollFirst();
		Point point3 = s.pollFirst();
		Point point4 = s.pollFirst();
		s1.add(point3);
		s1.add(point4);
		point3 = s1.pollFirst();
		point4 = s1.pollFirst();
		double diagonalDist1 = distance(point1, point3);
		double diagonalDist2 = distance(point4, point2);

		if (diagonalDist1 == 0 || diagonalDist2 == 0 || diagonalDist1 != diagonalDist2)
			return false;
		double dis1 = distance(point1, point2);
		double dis2 = distance(point2, point3);
		double dis3 = distance(point3, point4);
		double dis4 = distance(point4, point1);
		if (dis1 != dis2 || dis2 != dis3 || dis3 != dis4) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		validSquare(new int[] { 0, 0 }, new int[] { 1, 1 }, new int[] { 1, 0 }, new int[] { 1, 1 });
	}

}
