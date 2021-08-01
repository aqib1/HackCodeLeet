public class TrappingWater {

    public static int trappingWater(int [] boxes) {
        if(boxes.length == 0)
            return 0;
        int waterMeasurement = 0;
        int maxValueLeftSide[] = new int[boxes.length];
        int maxValueRightSide[] = new int[boxes.length];


        maxValueLeftSide[0] = boxes[0];

        for(int x = 1; x < maxValueLeftSide.length; x++)
          maxValueLeftSide[x] = Math.max(maxValueLeftSide[x-1], boxes[x]);

        maxValueRightSide[maxValueRightSide.length - 1] = boxes[boxes.length-1];

        for(int x = maxValueRightSide.length - 2; x >= 0; x--)
            maxValueRightSide[x] = Math.max(maxValueRightSide[x+1], boxes[x]);

        for(int x=0; x < boxes.length; x++)
            waterMeasurement += Math.min(maxValueLeftSide[x], maxValueRightSide[x]) - boxes[x];

        return waterMeasurement;

    }

    public static void main(String[] args) {
        System.out.println(trappingWater(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }
}
