import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ15650 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(NM[1], new boolean[NM[0]]);
        bw.flush();
        bw.close();
    }
    private static void dfs(int M, boolean[] visited) throws IOException {
        if (M == 0) {
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0 ; i < visited.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i+1);
                dfs(M-1, visited.clone());
                list.remove(list.size()-1);
            }
        }
    }
}
