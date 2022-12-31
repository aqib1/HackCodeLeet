import java.util.Arrays;

public class FloodFill {

    private static final int []DIRECTIONS = {0, -1, 0, 1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean [][] visited = new boolean[image.length][image.length];
        int startingPixel = image[sr][sc];
        floodFill(image, visited , startingPixel, sr, sc, color);
        return image;
    }

    public void floodFill(int[][] image, boolean [][] visited , int startingPixel, int x, int y, int color) {

        visited[x][y] = true;
        image[x][y] = color;
        for(int direction = 0; direction < DIRECTIONS.length - 1; direction++) {
            int newX = x + DIRECTIONS[direction];
            int newY = y + DIRECTIONS[direction + 1];
            if(newX >= 0 && newX < image.length && newY >= 0 && newY < image[newX].length && image[newX][newY] == startingPixel && !visited[newX][newY]) {
                floodFill(image, visited, startingPixel, newX, newY, color);
            }
        }
    }

    public static void main(String[] args) {
        FloodFill f = new FloodFill();

        System.out.println(Arrays.deepToString(
                f.floodFill(new int [][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 0)
        ));
    }
}
