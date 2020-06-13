package interview_question.facebook_interview_questions;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

  public static int getNumberOfIslands(int[][] grid) {
    Set<String> visited = new HashSet<>();
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (visited.contains(i + "" + j)) {
          continue;
        }
        if (grid[i][j] == 1) { //We found a new island, lets scout it and count it!
          scoutIsland(grid, i, j, visited);
          count++;
        }
      }
    }
    return count;
  }

  private static void scoutIsland(int[][] grid, int i, int j, Set<String> visited) {
    if (visited.contains(i + "" + j) || i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
      return;
    }
    visited.add(i + "" + j);
    scoutIsland(grid, i + 1, j, visited); //Scouting the island in all 4 directions
    scoutIsland(grid, i, j + 1, visited);
    scoutIsland(grid, i - 1, j, visited);
    scoutIsland(grid, i, j - 1, visited);
  }

  public static void main(String[] args) {
    int[][] grid =
           {{1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}};
    System.out.println(getNumberOfIslands(grid));
  }
}
