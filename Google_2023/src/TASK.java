import java.util.Objects;

public class TASK {


    // Space complexity O(2N)
    // Time complexity O(N)
    public static int waterStored(int[] block) {
        if(Objects.isNull(block) || block.length == 0) return 0;
        int storedWater = 0;

        int[] maxBlockFromLeft = new int[block.length];
        int[] maxBlockFromRight = new int[block.length];

        maxBlockFromLeft[0] = block[0];
        for(int i = 1; i < block.length; i++) {
            maxBlockFromLeft[i] = Math.max(maxBlockFromLeft[i - 1], block[i]);
        }

        maxBlockFromRight[maxBlockFromRight.length - 1] = block[block.length - 1];
        for(int i = block.length - 2; i >= 0; i--) {
            maxBlockFromRight[i] = Math.max(maxBlockFromRight[i + 1], block[i]);
        }

        for(int i = 0; i < block.length; i++)
            storedWater+= Math.min(maxBlockFromLeft[i], maxBlockFromRight[i]) - block[i];

        return storedWater;
    }





    // No of people + ages
    // Array of ages

    //  0 <= age <= 100
    // Time complexity -> O(N)
    // Space is O(100)
    public static void sort(int [] ages) {
        // O(N)
        // O(100)

        int[] sort = new int[101];

        for(int age: ages) {
            sort[age]++;
        }

        // O(N)
        for(int i=0; i < sort.length; i++)
            if(sort[i]!= 0) {
                for(int j=0; j<sort[i];j++)
                    System.out.println(i);
            }
    }


    public static void main(String[] args) {
//        sort(new int[] {12, 12, 12, 13});

        // base condition is fine
        System.out.println(waterStored(new int[] {}));
        System.out.println(waterStored(null));
        System.out.println(waterStored(new int[] {4, 2, 4, 0, 3}));
        System.out.println(waterStored(new int[] {1}));
    }
}

