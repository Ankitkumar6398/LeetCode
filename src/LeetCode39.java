import java.util.ArrayList;
import java.util.Scanner;

public class LeetCode39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] candidates = new int[size];
        for (int index = 0; index < size; index++) {
            candidates[index] = sc.nextInt();
        }
        int target = sc.nextInt();


        System.out.println(combinationSum(candidates, target));

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        findCombination(0, candidates, target, combinations, new ArrayList<>());
        return combinations;

    }

    static void findCombination(int index, int[] candidates, int target, ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> combination) {
        if (index == candidates.length) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }
        if (target <= candidates[index]) {
            combination.add(candidates[index]);
            findCombination(index, candidates, target, combinations, combination);
        }
        findCombination(index + 1, candidates, target, combinations, combination);

    }
}
