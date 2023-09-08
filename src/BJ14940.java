import java.io.*;
import java.util.*;

public class BJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] map = new int[N][];
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0 ; i < N ; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0 ; j < M ; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    queue.add(new Node(j, i));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx] && map[ny][nx] == 1) {
                    map[ny][nx] = map[now.y][now.x] + 1;
                    visited[ny][nx] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (!visited[i][j] && map[i][j] == 1)
                    bw.write(-1+" ");
                else
                    bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
