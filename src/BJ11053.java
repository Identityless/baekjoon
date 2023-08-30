import java.io.*;
import java.util.Arrays;

public class BJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (nums[i] > nums[j] && dp[j] == dp[i])
                    dp[i]++;
            }
            if (dp[i] > max)
                max = dp[i];
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
