import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,7,4,1,2,5,8};
        while(true) {
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i-1]) {
                    count++;
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }
            if (count == 0) {
                break;
            }
        }
        for (int j : arr) System.out.println(j);
    }
}
