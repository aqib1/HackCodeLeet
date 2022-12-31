import java.util.Objects;

public class MaxAreaOfIsland {

    private int maxValue;
    private int areaOfIsland;
    private static final int []DIRECTION = {0, -1, 0, 1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        if(Objects.isNull(grid) || grid.length == 0) return 0;

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                if(grid[x][y] == 1) {
                    areaOfIsland = 1;
                    dfs(grid, x, y);
                    maxValue = Math.max(maxValue, areaOfIsland);
                }
            }
        }
        return maxValue;
    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;

        for(int direction = 0; direction < DIRECTION.length - 1; direction++) {
            int newX = x + DIRECTION[direction];
            int newY = y + DIRECTION[direction + 1];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length && grid[newX][newY] == 1) {
                ++areaOfIsland;
                dfs(grid, newX, newY);
            }
        }
    }
}
