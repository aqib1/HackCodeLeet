import java.util.*;

public class Algorithm3 {
    private final static Set<Item> itemNodes = new HashSet<>();
    private final static int[] directions = new int[]{0, 1, 2, 3};

    public static void main(String[] args) {

        char[][] board1 = new char[][]{
                {'.', '.', 'X', '.', '.'},
                {'X', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
        };

        System.out.println(solve(board1));
    }

    public static int solve(char[][] board) {
        Map<String, Boolean> visitedNodes = new HashMap<>();
        dfs(board, 0, 0, 0, visitedNodes);
        return itemNodes.size();
    }

    private static void movement(char[][] board, int x, int y, int direction, Map<String, Boolean> visitedNodes) {
        Item item = new Item(x, y);
        itemNodes.add(item);
        if (direction == directions[0]) {
            dfs(board, x, y + 1, 0, visitedNodes);
        } else if (direction == directions[1]) {
            dfs(board, x + 1, y, 1, visitedNodes);
        } else if (direction == directions[2]) {
            dfs(board, x, y - 1, 2, visitedNodes);
        } else {
            dfs(board, x - 1, y, 3, visitedNodes);
        }
    }

    private static void clockWiseMovement(char[][] board, int x, int y, int direction, Map<String, Boolean> visitedNodes) {
        if (direction == directions[0]) {
            dfs(board, x, y - 1, 1, visitedNodes);
        } else if (direction == directions[1]) {
            dfs(board, x - 1, y, 2, visitedNodes);
        } else if (direction == directions[2]) {
            dfs(board, x, y + 1, 3, visitedNodes);
        } else {
            dfs(board, x + 1, y, 0, visitedNodes);
        }
    }

    private static void dfs(char[][] board, int x, int y, int direction, Map<String, Boolean> visitedNodes) {
        String key = x + "," + y + "," + direction;
        if (visitedNodes.containsKey(key)) {
            return;
        }
        if (x == board.length || x == -1 || y == -1 || y == board[0].length) {
            if (x == board.length) {
                dfs(board, x - 1, y, 2, visitedNodes);
            } else if (x == -1) {
                dfs(board, 0, y, 0, visitedNodes);
            } else if (y == board[0].length) {
                dfs(board, x, y - 1, 1, visitedNodes);
            } else if (y == -1) {
                dfs(board, x, 0, 3, visitedNodes);
            }
            return;
        }
        visitedNodes.put(key, true);
        if (board[x][y] != 'X') {
            movement(board, x, y, direction, visitedNodes);
        } else {
            clockWiseMovement(board, x, y, direction, visitedNodes);
        }

    }

    private static class Item {
        int x;
        int y;

        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.x) * Objects.hashCode(this.y);
        }

        @Override
        public boolean equals(Object o) {
            Item other = (Item) o;
            return other.x == this.x && other.y == this.y;
        }
    }
}

