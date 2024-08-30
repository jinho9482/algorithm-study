import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    // scanner보다 빠르다.
        String input = br.readLine();

        String[] array = input.split(" ");
        System.out.print(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));
    }
}
