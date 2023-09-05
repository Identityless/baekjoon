import java.io.*;
import java.util.*;

public class BJ25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][];
        int[][] dp = new int[N+1][M+1];
        boolean color = false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < N ; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                if ((board[i-1][j-1] == 'W' && color) || (board[i-1][j-1] == 'B' && !color)) {
                    dp[i][j] = 1;
                }
                color = !color;
            }
            if (i % 2 == 0)
                color = false;
            else
                color = true;
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                dp[i][j] = dp[i][j-1] + dp[i][j];
            }
        }
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j];
            }
        }

        for (int i = K ; i <= N ; i++) {
            for (int j = K ; j <= M ; j++) {
                int tmp = dp[i][j] - dp[i-K][j] - dp[i][j-K] + dp[i-K][j-K];
                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
        }
        int result = Math.min(min, K*K-max);
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
