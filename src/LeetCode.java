import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11, 15)));
        matrix.add(new ArrayList<>(Arrays.asList(2, 5, 8, 12, 19)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9, 16, 22)));
        matrix.add(new ArrayList<>(Arrays.asList(10, 13, 14, 17, 24)));
        boolean result = searchElement(matrix, 8);
        System.out.println(result ? "true" : "false");
    }

    public static boolean searchElement(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size(), m = matrix.get(0).size();
        for (int rows = 0; rows < n; rows++) {
            for (int col = 0; col < m; col++) {
                if (matrix.get(rows).get(col) == target) {
                    return true;

                }

            }


        }
        return false;
    }
}
