public class NextGreatestLetter {


    // Time complexity O(N)
    // Space complexity O(1)
    public char nextGreatestLetter(char[] letters, char target) {

        for (char letter : letters) {
            if (letter > target)
                return letter;
        }

        return letters[0];
    }

    public char nextGreatestLetterOptimal(char [] letters, char target) {
        int start = 0, end = letters.length;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(letters[mid] <= target) start = mid + 1;
            else end = mid;
        }

        return letters[start % letters.length];
    }


    public static void main(String[] args) {
        System.out.println(new NextGreatestLetter().nextGreatestLetter(new char[] {'e', 'e', 'g', 'g'}, 'g'));
    }
}
