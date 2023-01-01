import java.util.*;

public class ShortestPathInBinaryMatrix {
    // (-1, -1) (-1, 0) (-1, 1)
    // (0, -1)          (0, 1)
    // (1, -1)  (1, 0)  (1, 1)

    private static final int [][]DIRECTIONS = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(Objects.isNull(grid) || grid.length == 0 || grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0)
            return -1;

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] coordinate = queue.remove();
            int distance = grid[coordinate[0]][coordinate[1]];
            if(coordinate[0] == grid.length - 1 && coordinate[1] == grid[coordinate[0]].length - 1)
                return distance;

            for(int[] neighbour : getNeighbours(coordinate, grid)) {
                grid[neighbour[0]][neighbour[1]] = distance + 1;
                queue.add(neighbour);
            }
        }
        return -1;
    }

    public List<int[]> getNeighbours(int []coordinate, int[][] grid) {
        List<int []> neighbours = new ArrayList<>();

        for (int[] direction : DIRECTIONS) {
            int newRow = coordinate[0] + direction[0];
            int newCol = coordinate[1] + direction[1];

            if (newRow < 0 || newRow >= grid.length
                    || newCol < 0 || newCol >= grid[newRow].length
                    || grid[newRow][newCol] != 0)
                continue;

            neighbours.add(new int[]{newRow, newCol});
        }

        return neighbours;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix i = new ShortestPathInBinaryMatrix();

        System.out.println(i.shortestPathBinaryMatrix(new int [][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}
        }));
    }
}
