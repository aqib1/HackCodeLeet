import java.util.List;

public class KClosetNumberFromSortedArray {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int response = binarySearch(arr, k);
        return null;
    }

    private int binarySearch(int[] arr, int k) {
        int start = 0, end = arr.length;
        while(start < end) {
            int mid = start + (end - start) / 2;

            if(k > arr[mid]) start = mid + 1;
            else end = mid;
        }

        if(arr[start] == k) return start;
        if(start == 0) return Integer.MIN_VALUE;
        else return Integer.MAX_VALUE;
    }

}
