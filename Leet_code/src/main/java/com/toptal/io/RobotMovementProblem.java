package com.toptal.io;

import java.util.*;
import java.util.stream.IntStream;

public class RobotMovementProblem {
    enum Directions {
        DOWN, RIGHT, UP, LEFT
    }

    private static final char OBSTACLE = 'X';
    private static final Boolean TRUE = true;
    private static final String KEY_SEPARATOR = "##";
    private static final int INVALID_INPUT_RESPONSE = -1;
    private static final int ZERO = 0;
    private static final Set<Point> pointsCollector = new LinkedHashSet<>();

    // O(N) where N is the number of rows
    public static int solution(String[] R) {
        if (Objects.isNull(R) || !notEmptyArray(R))
            return INVALID_INPUT_RESPONSE;
        char[][] board = new char[R.length][];
        IntStream.range(0, R.length).forEach(row -> board[row] = R[row].toCharArray());
        if(boardEmpty(board))
            return INVALID_INPUT_RESPONSE;
        return solution(board);
    }

    private static boolean boardEmpty(char[][] board) {
        return board.length == ZERO || (board.length == 1 && board[ZERO].length == ZERO);
    }

    private static int solution(char[][] board) {
        Map<String, Boolean> visitedKeys = new HashMap<>();
        dfs(board, ZERO, ZERO, Directions.RIGHT, visitedKeys);
        return pointsCollector.size();
    }

    // O(V) where is the number of all nodes/vertices
    private static void dfs(char[][] board, int x, int y, Directions direction, Map<String, Boolean> visitedKeys) {
        String key = getKey(x, y, direction.ordinal());

        if (visitedKeys.containsKey(key))
            return;

        if (isBoundary(x, y, board)) {
            boundaryMovement(x, y, board, visitedKeys);
            return;
        }

        visitedKeys.put(key, TRUE);
        if (board[x][y] != OBSTACLE)
            movement(board, x, y, direction, visitedKeys);
        else
            clockWiseMovement(board, x, y, direction, visitedKeys);
    }

    private static void movement(char[][] board, int x, int y, Directions direction, Map<String, Boolean> visitedKeys) {
        Point point = new Point(x, y);
        pointsCollector.add(point);
        switch (direction) {
            case RIGHT:
                dfs(board, x, y + 1, Directions.RIGHT, visitedKeys);
                break;
            case DOWN:
                dfs(board, x + 1, y, Directions.DOWN, visitedKeys);
                break;
            case LEFT:
                dfs(board, x, y - 1, Directions.LEFT, visitedKeys);
                break;
            default:
                dfs(board, x - 1, y, Directions.UP, visitedKeys);
        }
    }

    private static void clockWiseMovement(char[][] board, int x, int y, Directions direction, Map<String, Boolean> visitedKeys) {
        switch (direction) {
            case RIGHT:
                dfs(board, x, y - 1, Directions.DOWN, visitedKeys);
                break;
            case DOWN:
                dfs(board, x - 1, y, Directions.LEFT, visitedKeys);
                break;
            case LEFT:
                dfs(board, x, y + 1, Directions.UP, visitedKeys);
                break;
            default:
                dfs(board, x + 1, y, Directions.RIGHT, visitedKeys);
        }
    }


    private static void boundaryMovement(int x, int y, char[][] board, Map<String, Boolean> visitedKeys) {
        if (x == board.length) {
            dfs(board, x - 1, y, Directions.LEFT, visitedKeys);
        } else if (x == -1) {
            dfs(board, ZERO, y, Directions.RIGHT, visitedKeys);
        } else if (y == board[x].length) {
            dfs(board, x, y - 1, Directions.DOWN, visitedKeys);
        } else if (y == -1) {
            dfs(board, x, ZERO, Directions.UP, visitedKeys);
        }
    }

    private static boolean isBoundary(int x, int y, char[][] board) {
        return x == board.length || x == -1 || y == -1 || y == board[x].length;
    }

    private static String getKey(int x, int y, int direction) {
        return String.valueOf(x)
                .concat(KEY_SEPARATOR)
                .concat(String.valueOf(y))
                .concat(KEY_SEPARATOR)
                .concat(String.valueOf(direction));
    }

    private static class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    "}\n";
        }
    }

    private static boolean notEmptyArray(String[] array) {
        return array.length != ZERO;
    }

    public static void clean() {
        pointsCollector.clear();
    }
}
