package QuestionsSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubsetSum1 {
    static ArrayList<Integer> subsetSum(ArrayList<Integer> nums, int N) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subset(0,0,nums,N,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
    static void subset(int ind, int sum, ArrayList<Integer> nums, int N, ArrayList<Integer> sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }
        subset(ind+1, sum+nums.get(ind), nums, N, sumSubset);
        subset(ind+1, sum, nums, N, sumSubset);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nums.add(scanner.nextInt());
        }
        ArrayList<Integer> ans = subsetSum(nums,nums.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
