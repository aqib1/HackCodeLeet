import java.util.Objects;

public class ElementaryDataStructures {

    public static void main(String[] args) {
        System.out.println(findByBinarySearchRecursive(new int[] {1, 2, 3, 4},
                2));
    }

    public static int findByBinarySearchRecursive(int[] data, int value) {
        return findByBinarySearchRecursive(0, data.length, data, value);
    }

    public static int findByBinarySearchRecursive(int start, int end, int[] data, int value) {
        if (start > end) return -1;
        else {
            int mid = (start + end) / 2;
            if (data[mid] == value) return mid;

            if (data[mid] < value)
                return findByBinarySearchRecursive(mid + 1, end, data, value);
            else
                return findByBinarySearchRecursive(start, mid - 1, data, value);
        }
    }

    // Binary search is a searching algorithm to find element from
    // sorted array/data-structure. Time complexity is Log(n)
    // Iterative approach
    public static int findByBinarySearch(int[] data, int value) {
        if (Objects.isNull(data) || data.length == 0)
            return 0;
        int start = 0;
        int end = data.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == value) return mid;

            if (data[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

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
