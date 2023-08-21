import java.io.*;

public class BJ9663 {
    private static int cnt = 0;
    private static int N;
    private static int[] history;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        history = new int[N];
        for (int i = 0 ; i < N ; i++) {
            history[i] = -1;
        }
        dfs(0);

        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }

    private static void dfs(int yIdx) {
        if (yIdx == N)
            cnt++;
        for (int i = 0 ; i < N ; i++) {
            if (isGood(i, yIdx)) {
                history[yIdx] = i;
                dfs(yIdx+1);
                history[yIdx] = -1;
            }
        }

    }

    private static boolean isGood(int xIdx, int yIdx) {
        int i = 0;
        while (history[i] != -1) {
            if (Math.abs(history[i]-xIdx) == Math.abs(i-yIdx) || xIdx == history[i])
                return false;
            i++;
        }
        return true;
    }


}
