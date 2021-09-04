import java.util.Objects;

public class MainClass {

	public static int trappingWater(int blocks[]) {
		if(Objects.isNull(blocks) || blocks.length == 0) return 0;
		
		int count = 0;
		// left to right max values
		int [] leftMax = new int[blocks.length];
		int [] maxRight = new int [blocks.length];
		
		leftMax[0] = blocks[0];
		
		for(int x = 1; x < leftMax.length; x++) {
			leftMax[x] = Math.max(leftMax[x-1], blocks[x]);
		}
		
		maxRight[maxRight.length - 1] = blocks[blocks.length - 1];
		
		for(int x = maxRight.length - 2; x >= 0; x--) {
			maxRight[x]  = Math.max(maxRight[x+1], blocks[x]);
		}
		
		for(int x=0; x < blocks.length; x++) {
			count += Math.min(leftMax[x], maxRight[x]) - blocks[x]; 
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(trappingWater(new int[] {0, 1, 2, 1, 0, 3}));
	}
}
