
import java.util.*;
import java.util.stream.Collectors;

public class TuringTest {




    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    public static int bfs(TreeNode root) {
        int result = 0;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if(node != null) {
                if(node.left!=null) {
                    bfs.add(node.left);
                    if(isLeaf(node.left))
                        result+= node.left.val;
                }
                if(node.right!=null) bfs.add(node.right);
            }
        }

        return result;
    }

    public static String maxRepeatedAnimal(String animals, String []forbidden) {
        String [] animalArray = animals.split(" ");
        Map<String, Integer> animalCount = new HashMap<>();
        for(String animal : animalArray) {
            animal = animal.toLowerCase();
            if(animalCount.containsKey(animal)) {
                animalCount.put(animal, animalCount.get(animal) + 1);
            } else {
                animalCount.put(animal, 1);
            }
        }
        for(String notAllowed: forbidden) animalCount.remove(notAllowed.toLowerCase());

        LinkedHashMap<String, Integer> sortedMap = animalCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap.isEmpty() ? "" : sortedMap.entrySet().iterator().next().getKey();
    }

    public static int twoSumLessThanK(int[] A, int k) {
        int response = -1;
        for(int i=0; i < A.length; i++) {
            for(int j= i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if(sum < k && response < sum) {
                    response = sum;
                }
            }
        }
        return response;
    }


    static char findExtraCharcter(char []strA, char[] strB)
    {
        // store string values in map
        int[] m1 = new int[256];
        HashMap<Character, Integer> charCount = new HashMap<>();

        // store second string in map with frequency
        for (int i = 0; i < strB.length; i++) {
            if(charCount.containsKey(strA[i])) {
                charCount.put(strA[i], charCount.get(strA[i]) + 1);
            } else {
                charCount.put(strA[i], 1);
            }

        }
        // store first string in map with frequency
        for (int i = 0; i < strA.length; i++)
            m1[strA[i]]--;

        for (int i=0;i<m1.length;i++)
        {

            // if the frequency is 1 then this
            // character is which is added extra
            if (m1[i]== 1)
                return (char) i;
        }
        return Character.MIN_VALUE;
    }

    public static String solution(String s) {
        String []cs = s.split(" ");
        Map<Integer, String> cc = new HashMap<>();
        for(String c: cs) {
            int o = Integer.parseInt(String.valueOf(c.charAt(c.length() - 1)));
            String cn = c.substring(0, c.length() - 1);
            cc.put(o, cn);
        }

        Map<Integer, String> ss = cc.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o, n) -> o, LinkedHashMap::new));

        String rs = "";
        for(int key: ss.keySet()) {
            rs = rs.concat(ss.get(key) + " ");
        }

        return rs;
    }

    public static void main(String[] args) {


        System.out.println(findExtraCharcter("abcd".toCharArray(), "ceadb".toCharArray()));

//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);
//        node.left.left = new TreeNode(10);
//        node.right.left = new TreeNode(11);
//
//        System.out.println(s(node));

//        System.out.println(maxRepeatedAnimal("Dog horse donkey CAT donkey caT bird donkey", new String[] {"donkey"}));

//        System.out.println(twoSumLessThanK(new int[] {10, 20, 30}, 15));
        System.out.println(solution("red2 white1 black3"));
    }
}
