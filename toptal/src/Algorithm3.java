import java.util.*;

public class Algorithm3 {
    static Set<Item> items = new HashSet<>();
    static int[] dir = new int[] {0,1,2,3};

    public static void main(String[] args) {

        char[][] board1 = new char[][]{
                {'.','.','X','.','.'},
                {'X','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
        };

        System.out.println(solve(board1));
    }

    public static int solve(char[][] board) {
        Map<String,Boolean> visited = new HashMap<>();
        dfs(board , 0, 0, 0 , visited);
        return items.size();
    }

    static void dfs(char[][] board, int x, int y, int direction, Map<String,Boolean> visited) {

        String key = x+","+y+","+direction;
        if(visited.containsKey(key)) {
            return;
        }

        if(x==board.length || x==-1 || y==-1 || y==board[0].length) {
            if (x == board.length) {
                dfs(board, x - 1, y, 2, visited);
            } else if (x == -1) {
                dfs(board, 0, y, 0, visited);
            } else if (y == board[0].length) {
                dfs(board, x, y - 1, 1, visited);
            } else if (y == -1) {
                dfs(board, x, 0, 3, visited);
            }
            return;
        }

        visited.put(key , true);
        if(board[x][y] != 'X') {
            Item item = new Item(x,y);
            items.add(item);
            if(direction == dir[0]) {
                dfs(board , x, y+1 , 0, visited);
            }
            else if(direction == dir[1]) {
                dfs(board , x+1, y , 1, visited);
            }
            else if(direction== dir[2]) {
                dfs(board , x, y-1 , 2, visited);
            }
            else {
                dfs(board , x-1, y , 3, visited);
            }
        }
        else {
            if(direction == dir[0]) {
                dfs(board , x, y-1 , 1, visited);
            }
            else if(direction == dir[1]) {
                dfs(board , x-1, y , 2, visited);
            }
            else if(direction== dir[2]) {
                dfs(board , x, y+1 , 3, visited);
            }
            else {
                dfs(board , x+1, y , 0, visited);
            }
        }

    }

    static class Item {
        int x;
        int y;
        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.x)*Objects.hashCode(this.y);
        }


        @Override
        public boolean equals(Object o) {
            Item other = (Item)o;
            return other.x==this.x && other.y==this.y;
        }
    }
}

