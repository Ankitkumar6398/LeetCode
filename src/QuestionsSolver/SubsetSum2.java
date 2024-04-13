package QuestionsSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[]{1,2,2};
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        List<List<Integer>> answer = subsetsWithDup(arr);
        System.out.println(answer.toString().replace(",", " "));

    }

    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        findSubset(0, arr, new ArrayList<>(), result);
        return result;

    }

    private static void findSubset(int index, int[] arr, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));


        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            temp.add(arr[i]);
            findSubset(i + 1, arr, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

}
