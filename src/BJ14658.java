import java.io.*;
import java.util.*;

public class BJ14658 {
    static int N, M, L, K;
    static int[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stars = new int[K][];
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < K ; i++) {
            stars[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0 ; i < K ; i++) {
            for (int j = 0 ; j < K ; j++) {
                max = Math.max(max, cal(stars[i][0], stars[j][1]));
            }
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }

    private static int cal(int x, int y) {
        int tmp = 0;
        for (int[] star : stars) {
            if (x <= star[0] && y <= star[1] && x+L >= star[0] && y+L >= star[1])
                tmp++;
        }
        return tmp;
    }

//    static class Node {
//        int x, y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int L = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int max = Integer.MIN_VALUE;
//
//        int[][] map = new int[M+2][N+2];    // 가로 세로 확인해서 나중에 틀리면 수정
//
//        for (int i = 0 ; i < K ; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            map[y+1][x+1] = 1;
//        }
//
//        for (int i = 1 ; i <= M+1 ; i++) {
//            for (int j = 1; j <= N+1 ; j++) {
//                map[i][j] = map[i][j-1] + map[i][j];
//            }
//        }
//
//        for (int j = 1 ; j <= N+1 ; j++) {
//            for (int i = 1 ; i <= M+1 ; i++) {
//                map[i][j] = map[i-1][j] + map[i][j];
//            }
//        }
//
//        for (int i = M+1 ; i >= L ; i--) {
//            for (int j = N+1 ; j >= L ; j--) {
//                int tmp = map[i][j] - map[i][j-L] - map[i-L][j] + map[i-L][j-L];
//                if (tmp > max)
//                    max = tmp;
//            }
//        }
//
//        bw.write(max+"");
//        bw.flush();
//        bw.close();
//    }
}
