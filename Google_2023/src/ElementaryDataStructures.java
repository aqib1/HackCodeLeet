public class ElementaryDataStructures {


    public static int[] merge(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0, x = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merge[x++] = nums1[i++];
            } else {
                merge[x++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            merge[x++] = nums1[i++];
        }

        while (j < nums2.length) {
            merge[x++] = nums2[j++];
        }

        return merge;
    }

    // Space complexity O(N+M) where N is space of nums1 and M is space of nums2.
    // Time complexity is O(N+M)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        int halfIndex = merged.length / 2;
        return merged.length % 2 == 0 ? ((double) (merged[halfIndex - 1] + merged[halfIndex]) / 2) : (merged[halfIndex]);
    }

}
