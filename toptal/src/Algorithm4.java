import java.util.*;

public class Algorithm4 {
    static Set<Item> itemCollector = new HashSet<>();

    public static void main(String[] args) {
    /*char[][] board = new char[][]{
            {'.','.','.','.','X','.','.'},
            {'X','.','.','.','.','.','.'},
            {'.','.','.','.','.','X','.'},
            {'.','.','.','.','.','.','.'},
    };*/

        char[][] board1 = new char[][]{
                {'.','.','X','.','.'},
                {'X','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
        };

        System.out.println(solve(board1));
    }

    public int solution(String[] R) {
        char[][] box = new char[R.length][];

        for (int i = 0; i < R.length; i++) {
            box[i] = R[i].toCharArray();
        }

        return solve(box);
    }
    public static int solve(char[][] box) {
        Map<String,Boolean> visited = new HashMap<>();
        depthFirstSearch(box , 0, 0, 0 , visited);
        return itemCollector.size();
    }

    static void depthFirstSearch(char[][] box, int x, int y, int direction, Map<String,Boolean> visited) {

        String key = x+"#"+y+"#"+direction;
        if(visited.containsKey(key)) {
            return;
        }

        if(x==box.length || x==-1 || y==-1 || y==box[0].length) {
            if (x == box.length) {
                depthFirstSearch(box, x - 1, y, 2, visited);
            } else if (x == -1) {
                depthFirstSearch(box, 0, y, 0, visited);
            } else if (y == box[0].length) {
                depthFirstSearch(box, x, y - 1, 1, visited);
            } else if (y == -1) {
                depthFirstSearch(box, x, 0, 3, visited);
            }
            return;
        }

        visited.put(key , true);
        if(box[x][y]!='X') {
            Item item = new Item(x,y);
            itemCollector.add(item);
            if(direction==0) {
                depthFirstSearch(box , x, y+1 , 0, visited);
            }
            else if(direction==1) {
                depthFirstSearch(box , x+1, y , 1, visited);
            }
            else if(direction==2) {
                depthFirstSearch(box , x, y-1 , 2, visited);
            }
            else {
                depthFirstSearch(box , x-1, y , 3, visited);
            }
        }
        else {
            if(direction==0) {
                depthFirstSearch(box , x, y-1 , 1, visited);
            }
            else if(direction==1) {
                depthFirstSearch(box , x-1, y , 2, visited);
            }
            else if(direction==2) {
                depthFirstSearch(box , x, y+1 , 3, visited);
            }
            else {
                depthFirstSearch(box , x+1, y , 0, visited);
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

        public int hashCode() {
            return Objects.hashCode(this.x)*Objects.hashCode(this.y);
        }

        public boolean equals(Object o) {
            Item other = (Item)o;
            return other.x==this.x && other.y==this.y;
        }
    }
}

