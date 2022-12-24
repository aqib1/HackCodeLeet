public class NumberOfClosedIslands {


    // four dimensional directions
    private static final int[] DIRECTIONS = {0, -1, 0, 1, 0};

    public static int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 0) {
                    if (iterateIsland(grid, x, y)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean iterateIsland(int[][] grid, int x, int y) {
        grid[x][y] = 1;
        boolean response = true;
        if((x-1 < 0 || x+1 >= grid.length) || (y-1 < 0 || y+1 >= grid[x].length)) {
            response = false;
        }

        for (int direction = 0; direction < DIRECTIONS.length - 1; direction++) {
            int newX = x + DIRECTIONS[direction];
            int newY = y + DIRECTIONS[direction + 1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length && grid[newX][newY] == 0) {
                response &= iterateIsland(grid, newX, newY);
            }
        }
        return response;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}};
        System.out.println(closedIsland(grid));
    }
}
