import java.io.*;
import java.util.Arrays;

public class BJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] r = new int[N];
        int[] g = new int[N];
        int[] b = new int[N];
        for (int i = 0 ; i < N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            r[i] = input[0];
            g[i] = input[1];
            b[i] = input[2];
        }
        int[][] sums = new int[N][3];
        sums[0][0] = r[0];
        sums[0][1] = g[0];
        sums[0][2] = b[0];

        for (int i = 1 ; i < N ; i++) {
            sums[i][0] = r[i] + Math.min(sums[i-1][1], sums[i-1][2]);
            sums[i][1] = g[i] + Math.min(sums[i-1][0], sums[i-1][2]);
            sums[i][2] = b[i] + Math.min(sums[i-1][0], sums[i-1][1]);
        }
        int min = Math.min(sums[N-1][0], Math.min(sums[N-1][1], sums[N-1][2]));

        bw.write(min+"");
        bw.flush();
        bw.close();

    }
}
