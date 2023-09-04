import java.io.*;
import java.util.*;

public class BJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int[][] field= new int[N+1][N+1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                field[i][j] = field[i-1][j] + field[i][j-1] - field[i-1][j-1] + map[i][j];
            }
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = 0;
            result = field[x2][y2] - field[x1-1][y2] - field[x2][y1-1] + field[x1-1][y1-1];
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }
}
