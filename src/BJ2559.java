import java.io.*;
import java.util.*;

public class BJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i + K <= N ; i++) {
            if (max < nums[i+K] - nums[i])
                max = nums[i+K] - nums[i];
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
