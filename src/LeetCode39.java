import java.util.ArrayList;
import java.util.List;
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


        ArrayList<ArrayList<Integer>> list = combinationSum(candidates, target);
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

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
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            findCombination(index, candidates, target-candidates[index], combinations, combination);
            combination.remove(combination.size() - 1);
        }
        findCombination(index + 1, candidates, target, combinations, combination);

    }
}
