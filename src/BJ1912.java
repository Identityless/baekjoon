import java.io.*;
import java.util.Arrays;

public class BJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sums = new int[N];
        int max = nums[0];
        sums[0] = nums[0];

        for (int i = 1 ; i < N ; i++) {
            sums[i] = Math.max(nums[i], sums[i-1]+nums[i]);
            if (sums[i] > max)
                max = sums[i];
        }

        bw.write(max+"");
        bw.flush();
        bw.close();

    }
}
