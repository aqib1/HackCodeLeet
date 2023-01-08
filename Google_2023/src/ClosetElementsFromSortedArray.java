import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosetElementsFromSortedArray {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(k == arr.length) return Arrays.stream(arr).boxed().toList();

        List<Integer> result = new ArrayList<>();
        int index = binarySearch(arr, x);

        int left = index - 1;
        int right = index;
        while((right - left - 1) < k) {
            if(left < 0) {
                right++;
            } else if(right >= arr.length ||
            Math.abs(arr[right] - x) >= Math.abs(arr[left] - x)) {
                left--;
            } else {
                right++;
            }
        }

        for(int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    private static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(x < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[] {1, 2, 3, 4, 5}, 4, -1));
    }
}
