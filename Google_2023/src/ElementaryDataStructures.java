import java.util.Objects;

public class ElementaryDataStructures {


    public static void main(String[] args) {
//        int[] evenSizedArray = new int[]{1, 2, 3, 4};
//
//        int mid = evenSizedArray.length / 2;
//        double median = (double)(evenSizedArray[mid - 1] + evenSizedArray[mid]) / 2.0;
//        System.out.println(median);
//
//        int[] oddSizedArray = new int[] {1, 2, 3};
//        System.out.println(oddSizedArray[oddSizedArray.length / 2]);


        System.out.println(median(new int[]{1, 2},
                new int[]{3, 4}));
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


    public static double median(int X[], int Y[]) {
        // step 1: check if X > Y then replace
        if (X.length > Y.length) {
            int[] tmp = Y;
            Y = X;
            X = tmp;
        }
        int startOfSmallArray = 0;
        int endOfSmallArray = X.length;
        int partitionOfSmallArray;
        int partitionOfLargeArray;
        boolean isOdd = (X.length + Y.length) % 2 != 0;

        while (startOfSmallArray <= endOfSmallArray) {
            partitionOfSmallArray = (startOfSmallArray + endOfSmallArray) / 2;
            partitionOfLargeArray = ((X.length + Y.length + 1) / 2) - partitionOfSmallArray;
            // x0 > y1
            if (partitionOfSmallArray > 0 && partitionOfLargeArray < Y.length
                    && X[partitionOfSmallArray - 1] > Y[partitionOfLargeArray]) {
                endOfSmallArray = partitionOfSmallArray - 1;
            }
            // x1 < y0
            else if (partitionOfSmallArray < X.length && partitionOfLargeArray > 0
                    && X[partitionOfSmallArray] < Y[partitionOfLargeArray - 1]) {
                startOfSmallArray = partitionOfSmallArray + 1;
            } else {
                int maxLeft = Integer.MIN_VALUE;
                if (partitionOfSmallArray > 0) {
                    maxLeft = Math.max(maxLeft, X[partitionOfSmallArray - 1]);
                }
                if (partitionOfLargeArray > 0) {
                    maxLeft = Math.max(maxLeft, Y[partitionOfLargeArray - 1]);
                }
                if (isOdd) return maxLeft;
                else {
                    int minRight = Integer.MAX_VALUE;
                    if (partitionOfSmallArray < X.length) {
                        minRight = Math.min(minRight, X[partitionOfSmallArray]);
                    }
                    if (partitionOfLargeArray < Y.length) {
                        minRight = Math.min(minRight, Y[partitionOfLargeArray]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }
        }

        return -1;
    }

    // Time complexity O(log min(x,y))
    public static double findMedianSortedArraysEffective(int[] nums1, int[] nums2) {
        // make sure nums1 always small array
        if (nums1.length > nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }

        int startOfSmallArray = 0;
        int endOfSmallArray = nums1.length;
        int partitionOfSmallArray;
        int partitionOfLargeArray;

        while (startOfSmallArray <= endOfSmallArray) {
            partitionOfSmallArray = (startOfSmallArray + endOfSmallArray) / 2;
            partitionOfLargeArray = ((nums1.length + nums2.length + 1) / 2) - partitionOfSmallArray;

            if (partitionOfSmallArray > 0
                    && partitionOfLargeArray < nums2.length
                    && nums1[partitionOfSmallArray - 1] > nums2[partitionOfLargeArray]) {
                endOfSmallArray = partitionOfSmallArray - 1;
            } else if (partitionOfLargeArray > 0
                    && startOfSmallArray < nums1.length
                    && nums2[partitionOfLargeArray - 1] > nums1[partitionOfSmallArray]) {
                startOfSmallArray = partitionOfSmallArray + 1;
            } else {
                int total = nums1.length + nums2.length;
                int maxLeft = Integer.MIN_VALUE;

                if (partitionOfSmallArray > 0) {
                    maxLeft = Math.max(maxLeft, nums1[partitionOfSmallArray - 1]);
                }
                if (partitionOfLargeArray > 0) {
                    maxLeft = Math.max(maxLeft, nums2[partitionOfLargeArray - 1]);
                }

                if (total % 2 != 0)
                    return maxLeft;
                else {
                    int minRight = Integer.MAX_VALUE;
                    if (partitionOfSmallArray < nums1.length) {
                        minRight = Math.min(minRight, nums1[partitionOfSmallArray]);
                    }
                    if (partitionOfLargeArray < nums2.length) {
                        minRight = Math.min(minRight, nums2[partitionOfLargeArray]);
                    }
                    return (minRight + maxLeft) / 2.0;
                }
            }
        }

        return -1;
    }

}
