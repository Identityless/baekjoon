import java.util.*;
import java.io.*;

public class BJ10989 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int numOfNum = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for (int i = 0 ; i < numOfNum ; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        for (int i = 1 ; i <= 10000 ; i++) {
            for (int j = 0 ; j < arr[i] ; j++) {
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
