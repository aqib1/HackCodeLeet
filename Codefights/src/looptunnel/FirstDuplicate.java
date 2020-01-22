package looptunnel;

public class FirstDuplicate {
	static int firstDuplicate(int[] a) {
		boolean rec[] = new boolean[a.length + 1];
		for (int c : a)
			if (rec[c])
				return c;
			else
				rec[c] = true;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstDuplicate(new int[] {1,2,3,4,3,2}));
	}

}
