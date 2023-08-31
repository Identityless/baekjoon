import java.io.*;
import java.util.StringTokenizer;

public class BJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[][] s = new int[N][2];
        int[] dp = new int[S+1];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = S ; j >= 0 ; j--) {
                if (j - s[i][0] >= 0) {
                    dp[j] = Math.max(dp[j], s[i][1]+dp[j-s[i][0]]);
                }
            }
        }
        bw.write(dp[S]+"");
        bw.flush();
        bw.close();
    }
}
