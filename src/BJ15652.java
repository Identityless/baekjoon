import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ15652 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(NM[0], NM[1], 0);
        bw.flush();
        bw.close();
    }
    private static void dfs(int N, int M, int seg) throws IOException {
        if (M == 0) {
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = seg ; i < N; i++) {
            list.add(i+1);
            dfs(N, M-1, i);
            list.remove(list.size()-1);
        }
    }
}

