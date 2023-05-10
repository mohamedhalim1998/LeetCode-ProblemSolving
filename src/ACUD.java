import java.util.Arrays;

public class ACUD {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(findIndexToReplace(arr));
    }

    private static int findIndexToReplace(int[] arr) {

        int[] left = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            left[i + 1] = (arr[i] == 1 ? left[i] + 1 : 0);
        }
        int[] right = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            right[i] = (arr[i] == 1 ? right[i + 1] + 1 : 0);
        }
        int max = 0;
        int replace = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int count = 1 + left[i] + right[i];
                if(count > max) {
                    max = count;
                    replace = i;
                }
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return replace;
    }


}
