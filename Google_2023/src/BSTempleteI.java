public class BSTempleteI {
    public int bsI(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int bsII(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        // start == end
        if(start != nums.length && nums[start] == target) return start;
        return -1;
    }

    public static int bsIII(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid]) start = mid;
            else end = mid;
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(bsIII(new int[]{1,2,3,4,5,6,7}, 1));
    }
}
