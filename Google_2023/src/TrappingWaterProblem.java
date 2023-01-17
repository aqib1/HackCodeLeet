public class TrappingWaterProblem {
    // Time O(N) and space O(N)
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        int[] maxFromLeft = new int[height.length];
        int[] maxFromRight = new int[height.length];
        int trappingWater = 0;
        maxFromLeft[0] = height[0];
        for(int x=1; x<height.length; x++) {
            maxFromLeft[x] = Math.max(maxFromLeft[x-1], height[x]);
        }

        maxFromRight[maxFromRight.length - 1] = height[height.length -1];
        for(int x=maxFromRight.length - 2; x>=0; x--) {
            maxFromRight[x] = Math.max(maxFromRight[x+1], height[x]);
        }

        for(int x=0; x<height.length; x++) {
            trappingWater+= Math.min(maxFromLeft[x], maxFromRight[x]) - height[x];
        }

        return trappingWater;
    }
}
