import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Task1 {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

   static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }


    static class Result {
        private static int max = Integer.MIN_VALUE;

        /*
         * Complete the 'maximumPages' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

       public static SinglyLinkedListNode reverse(SinglyLinkedListNode node)
        {
            SinglyLinkedListNode prev = null;
            SinglyLinkedListNode current = node;
            SinglyLinkedListNode next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            node = prev;
            return node;
        }
        public static int maximumPages(SinglyLinkedListNode head) {
           if(head == null)
               return 0;
           if(head.next == null)
               return head.data;
            int count = 0;
            SinglyLinkedListNode countPointer = head;
            while(countPointer.next != null) {
                System.out.println(countPointer.data);
                count++;
                countPointer = countPointer.next;
            }
            SinglyLinkedListNode mid = head;
            for(int x=0; x <= (count / 2) ; x++) {
                mid = mid.next;
            }

            mid = reverse(mid);

            SinglyLinkedListNode start = head;
            while(start.next != null && mid.next != null) {
                max = Math.max(start.data + mid.data, max);
                start = start.next;
                mid = mid.next;
            }

            return max;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList head = new SinglyLinkedList();
        head.insertNode(1);
        head.insertNode(2);
        head.insertNode(3);
        head.insertNode(4);
        head.insertNode(5);
        head.insertNode(6);

//        int headCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, headCount).forEach(i -> {
//            try {
//                int headItem = Integer.parseInt(bufferedReader.readLine().trim());
//
//                head.insertNode(headItem);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });

        int result = Result.maximumPages(head.head);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
