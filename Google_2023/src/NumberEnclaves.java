import java.util.Objects;

public class NumberEnclaves {

    private static final int []DIRECTIONS = {0, -1, 0, 1, 0};
    private int cellCount;
    public int numEnclaves(int[][] grid) {
        if(Objects.isNull(grid) || grid.length == 0) return 0;
        int numberOfEnclaves  = 0;

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                if(grid[x][y] == 1) {
                    cellCount = 1;
                    if(dfs(grid,true, x, y)) {
                        numberOfEnclaves += cellCount;
                    }
                }
            }
        }

        return numberOfEnclaves;
    }

    public boolean dfs(int[][] grid, boolean isValid, int x, int y) {
        if((x == 0 || x == grid.length - 1 || y == 0 || y == grid[x].length - 1) && grid[x][y] == 1)
            return false;
        grid[x][y] = 0;
        for(int direction = 0; direction < DIRECTIONS.length - 1; ++direction) {
            int newX = x + DIRECTIONS[direction];
            int newY = y + DIRECTIONS[direction + 1];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length && grid[newX][newY] == 1) {
                cellCount++;
                isValid = dfs(grid, isValid ,newX, newY);
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        NumberEnclaves numberEnclaves = new NumberEnclaves();

        System.out.println(numberEnclaves.numEnclaves(new int [][] {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        }));
    }
}
