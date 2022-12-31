import java.util.Objects;

public class NumberOfIslands {

    // Time complexity O(N x M) where N is number of rows and M is number of columns
    // Space complexity O(N x M) {Recursion}

    private static final int []DIRECTIONS = new int [] {0, -1, 0, 1, 0};
    public int numIslands(char[][] grid) {
        if(Objects.isNull(grid) || grid.length == 0) return 0;
        int count = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                if(grid[x][y] == '1') {
                visitIslands(grid, x, y);
                count++;
              }
            }
        }
        return count;
    }


    private void visitIslands(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        for(int direction=0; direction < DIRECTIONS.length - 1; direction++) {
            int newX = x + DIRECTIONS[direction];
            int newY = y + DIRECTIONS[direction + 1];
            if(newX >= 0 && newX < grid.length
                    && newY >= 0 && newY < grid[newX].length
                        && grid[newX][newY] == '1'){
                visitIslands(grid, newX, newY);
            }
        }
    }
}
