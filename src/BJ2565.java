import java.io.*;
import java.util.*;

public class BJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        int[] dp = new int[N];
        int max = 0;
        for (int i = 0 ; i < N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lines[i][0] = input[0];
            lines[i][1] = input[1];
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (lines[j][1] < lines[i][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        for (int i = 0 ; i < N ; i++) {
            if (dp[i] > max)
                max = dp[i];
        }

        bw.write(N-max+"");
        bw.flush();
        bw.close();
    }
}
