import java.io.*;
import java.util.*;

public class BJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[2][N];
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (nums[i] > nums[j] && dp[0][i] == dp[0][j]) {
                    dp[0][i]++;
                }
            }
        }
        for (int i = N-1 ; i >= 0 ; i--) {
            for (int j = N-1; j > i ; j--) {
                if (nums[i] > nums[j] && dp[1][i] == dp[1][j]) {
                    dp[1][i]++;
                }
            }
            if (dp[1][i] + dp[0][i] > max)
                max = dp[1][i] + dp[0][i] -1;
        }

        bw.write(max+"");
        bw.flush();
        bw.close();


    }
}
