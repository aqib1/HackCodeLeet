package klarna;

import java.util.Iterator;
import java.util.Set;

public class Question2 {

	// isWritable(4, 2, [1, 4]) returns true as the file of size 2 can be stored on
	// sectors 2 and 3
	public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
		if (occupiedSectors.isEmpty() && fileSize <= blockSize)
			return true;

		int counter = 0;
		Iterator<Integer> it = occupiedSectors.iterator();
		while (it.hasNext()) {
			int startBlock = it.next();

			if (blockSize - startBlock < fileSize) {
				return false;
			} else {
				counter++;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
