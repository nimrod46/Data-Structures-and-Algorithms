package interview_question.google_interview_questions;

public class TrappingRainWater {

  /**
   * Not the most efficient solution but that what I came up with the first time.
   * This solution counts each level separately so its O(n * k) where n is the length of the list
   * and k is the number of levels
   */
  public static int getTrappingRainWater(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      if(max < height[i]) {
        max = height[i];
      }
    }
    int count = 0;
    for (int i = 1; i < max; i++) {
      count += countWaterAtLevel(height, i);
    }
    return count;
  }

  private static int countWaterAtLevel(int[] height, int level) {
    int first = 0;
    for (int i = 0; i < height.length; i++) {
      if(level <= height[i]) {
        first = i;
        break;
      }
    }

    int last = 0;
    for (int i = height.length - 1; i >= 0; i--) {
      if(level <= height[i]) {
        last = i;
        break;
      }
    }
    int count = 0;
    for (int i = first; i < last + 1; i++) {
      if(level > height[i]) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(getTrappingRainWater(array));
  }
}
