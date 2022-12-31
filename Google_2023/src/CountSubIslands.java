import java.util.Objects;

public class CountSubIslands {

    private static final int []DIRECTIONS = {0, -1, 0, 1, 0};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if(Objects.isNull(grid1) || Objects.isNull(grid2))
            return 0;
        int subIslands = 0;
        for(int x = 0; x < grid2.length; x++) {
            for(int y = 0; y < grid2[x].length; y++) {
             if(grid2[x][y] == 1 && grid1[x][y] == grid2[x][y] && dfs(grid1, grid2, true, x, y)) {
                 subIslands++;
                }
            }
        }
        return subIslands;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, boolean isValid, int x, int y) {
        if(grid2[x][y] != grid1[x][y]) return false;
          grid2[x][y] = 0;

        for(int direction = 0; direction < DIRECTIONS.length - 1; direction++) {
            int newX = x + DIRECTIONS[direction];
            int newY = y + DIRECTIONS[direction + 1];

            if(newX >= 0 && newX < grid2.length && newY >= 0 && newY < grid2[newX].length && grid2[newX][newY] == 1)
                isValid = dfs(grid1, grid2, isValid, newX, newY);
        }

        return isValid;
    }
}
