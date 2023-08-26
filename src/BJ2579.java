import java.io.*;
import java.util.Arrays;

public class BJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int[] sums = new int[N+1];

        sums[1] = nums[0];

        if (N >= 2) {
            sums[2] = nums[0] + nums[1];
        }

        for (int i = 3 ; i <= N ; i++) {
            sums[i] = Math.max(sums[i-3] + nums[i-2], sums[i-2]) + nums[i-1];
        }

        bw.write(sums[N]+"");
        bw.flush();
        bw.close();

    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int[][] sums = new int[N][N];
//        int input;
//        if (N >= 1) {
//            sums[0][0] = Integer.parseInt(br.readLine());
//        }
//        if (N >= 2) {
//            sums[1][0] = Integer.parseInt(br.readLine());
//            sums[1][1] = sums[0][0] + sums[1][0];
//        }
//        if (N >= 3) {
//            input = Integer.parseInt(br.readLine());
//            sums[2][0] = sums[0][0] + input;
//            sums[2][1] = sums[1][0] + input;
//        }
//        if (N >= 4) {
//            input = Integer.parseInt(br.readLine());
//            sums[3][0] = sums[1][0] + input;
//            sums[3][1] = sums[1][1] + input;
//            sums[3][2] = sums[2][0] + input;
//
//            for (int i = 4; i < N; i++) {
//                input = Integer.parseInt(br.readLine());
//                for (int j = 0; j < i - 2; j++) {
//                    sums[i][j] = sums[i - 2][j] + input;
//                }
//                sums[i][i - 2] = sums[i - 1][0] + input;
//                sums[i][i - 1] = sums[i - 1][1] + input;
//            }
//        }
//
//
//        int max = sums[N-1][0];
//        for (int i = 1 ; i < N ; i++)
//            max = Math.max(max, sums[N-1][i]);
//
//        bw.write(max+"");
//        bw.flush();
//        bw.close();
//    }
}
