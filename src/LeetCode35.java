import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeetCode35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] candidates = new int[size];
        for (int i = 0; i < size; i++) {
            candidates[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        List<List<Integer>> list = findCombinationSum2(candidates, target);
        System.out.println(list.toString().replace(",", " "));
    }

    public static List<List<Integer>> findCombinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationSum(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    static void findCombinationSum(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            findCombinationSum(i + 1, candidates, target - candidates[i], result, temp);
            temp.remove(temp.size() - 1);

        }
    }
}
