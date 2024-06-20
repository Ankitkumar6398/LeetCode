package QuestionsSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalidromePartitioning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        List<List<String>> list = partition(str);
        int size = list.size();
        System.out.println("[");
        for (int i = 0; i < size; i++) {
            System.out.println("[");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println("]");
        }
        System.out.println("]");


    }

    public static List<List<String>> partition(String str) {
        List<List<String>> res = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        partitionHelper(0, str, arr, res);
        return res;

    }

    static void partitionHelper( int start,String str, List<String> arr, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                arr.add(str.substring(start, i + 1));
                partitionHelper(i+1,str,  arr, res);
                arr.remove(arr.size() - 1);
            }
        }

    }

    static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;

        }
        return true;
    }
}
