package com.hyungyu.algorithm.leetcode.dynamic_programming;

public class P1706_WhereWillTheBallFall {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        int[] ball = findBall(grid);
        for (int i : ball) {
            System.out.println(i);
        }
    }

    public static int[] findBall(int[][] grid) {
        int result[] = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findBallDropColumn(0, i, grid);
        }
        return result;
    }

    public static int findBallDropColumn(int row, int col, int[][] grid) {
        if (row == grid.length) {
            return col;
        }
        int nextColumn = col + grid[row][col];
        if (nextColumn < 0 ||
            nextColumn > grid[0].length - 1 ||
            grid[row][col] != grid[row][nextColumn]) {
            return -1;
        }
        return findBallDropColumn(row + 1, nextColumn, grid);
    }
}
