import java.io.*;

public class BJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum[1] = arr[1];
        if (N > 1) {
            sum[2] = arr[1] + arr[2];

            for (int i = 3; i <= N; i++) {
                sum[i] = Math.max(Math.max(sum[i - 3] + arr[i - 1], sum[i - 2])+arr[i], sum[i-1]);
            }
        }

        bw.write(sum[N]+"");
        bw.flush();
        bw.close();
    }
}
