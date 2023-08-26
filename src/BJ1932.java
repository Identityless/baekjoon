import java.io.*;
import java.util.StringTokenizer;

public class BJ1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][N];
        int[][] sums = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        sums[0][0] = nums[0][0];

        for (int i = 1 ; i < N ; i++) {
            sums[i][0] = sums[i-1][0] + nums[i][0];
            for (int j = 1 ; j < i ; j++) {
                sums[i][j] = Math.max(sums[i-1][j-1], sums[i-1][j]) + nums[i][j];
            }
            sums[i][i] = sums[i-1][i-1] + nums[i][i];
        }
        int max = sums[N-1][0];
        for (int i = 1 ; i < N ; i++) {
            max = Math.max(max, sums[N-1][i]);
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
