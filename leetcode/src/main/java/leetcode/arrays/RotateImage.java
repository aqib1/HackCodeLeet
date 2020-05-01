package leetcode.arrays;

import java.util.Objects;

public class RotateImage {

	// Time complexity O(n) and space complexity O(1)
	public int[][] rotateImage(int[][] image) {
		if (Objects.isNull(image))
			throw new IllegalArgumentException();
		if (image.length == 0)
			return new int[][] {};
		int rotateYLimit = 2;
		int [][] rotatedImage = new int[image.length][image[0].length];
		for (int x = 0; x < image.length; x++) {
			for (int y = 0; y < image[x].length; y++) {
				rotatedImage[y][rotateYLimit] = image[x][y];
			}
			rotateYLimit--;
		}
		return rotatedImage;
	}
}
