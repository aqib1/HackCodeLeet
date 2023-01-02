import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaxDistance {
    private static final int[] DIRECTIONS = {0, -1, 0, 1, 0};

    // Time complexity O(N x M)
    // Space O(N x M) + O(N x M) = O 2(N x M)
    public int maxDistance(int[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        int distance = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfs = new LinkedList<>();
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    bfs.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }


        while (!bfs.isEmpty()) {
            distance++;
            for(int i = bfs.size(); i > 0; i--) {
                int[] coordinate = bfs.remove();
                for (int direction = 0; direction < DIRECTIONS.length - 1; direction++) {
                    int newX = coordinate[0] + DIRECTIONS[direction];
                    int newY = coordinate[1] + DIRECTIONS[direction + 1];

                    if (newX >= 0 && newX < grid.length
                            && newY >= 0 && newY < grid[newX].length
                            && !visited[newX][newY]) {
                        grid[newX][newY] = distance;
                        visited[newX][newY] = true;
                        bfs.add(new int[] {newX, newY});
                        max = Math.max(max, grid[newX][newY]);
                    }
                }
            }
        }


        return max == Integer.MIN_VALUE ? -1 : max;
    }


    public static void main(String[] args) {
        MaxDistance m = new MaxDistance();

        System.out.println(m.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
}
