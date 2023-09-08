import java.io.*;
import java.util.*;

public class BJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][];
        int t = -1;
        int cnt = 0;
        for (int i = 0 ; i < N ; i++) {
            times[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        for (int i = 0 ; i < N ; i++) {
            if (times[i][0] >= t) {
                cnt++;
                t = times[i][1];
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
