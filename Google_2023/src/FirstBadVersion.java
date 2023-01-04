interface VersionControl {
    boolean isBadVersion(int version);
}
public class FirstBadVersion implements VersionControl {

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    @Override
    public boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(1420736637));
    }

}
