import java.util.*;
import java.io.*;

public class BJ2169 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        int[][] tmp = new int[2][M+1];
//        int[] dx = {-1, 0, 1};
//        int[] dy = {0, 1, 0};
//        Queue<Node> queue = new LinkedList<>();
        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        dp[0][0] = map[0][0];
//        queue.add(new Node(0,0));
        for (int i = 1 ; i <= M ; i++) {
            dp[1][i] = dp[1][i-1] + map[1][i];
        }
        for (int i = 2 ; i <= N ; i++) {
            tmp[0][1] = dp[i-1][1] + map[i][1];
            for (int j = 2 ; j <= M ; j++) {
                tmp[0][j] = Math.max(tmp[0][j-1], dp[i-1][j]) + map[i][j];
            }
            tmp[1][M] = dp[i-1][M] + map[i][M];
            for (int j = M-1 ; j > 0; j--) {
                tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + map[i][j];
            }
            for (int j = 1 ; j <= M ; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }



        bw.write(dp[N][M]+"");
        bw.flush();
        bw.close();

    }

//    static class Node {
//        int x;
//        int y;
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

//    static class DP {
//        int value;
//        boolean[] visited;
//        public DP () {
//            value = Integer.MIN_VALUE;
//            visited = new boolean[3];
//        }
//    }
}
