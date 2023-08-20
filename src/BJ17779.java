import java.io.*;
import java.util.*;

public class BJ17779 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[][] map;
    private static int[][] district;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0 ; i < N ; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0 ; i < N-2 ; i++) {
            for (int j = 1 ; j < N-1 ; j++) {
                gerrymandering(j, i);
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    private static void gerrymandering(int x, int y) {
        int d1Lim = x;
        int d2Lim = N-x-1;
        for (int i = 1 ; i <= d1Lim ; i++) {
            for (int j = 1 ; j <= d2Lim ; j++) {
                if (i+j <= N-y-1) {
                    splitDistrict(x, y, i, j);
                }
            }
        }
    }

    private static void splitDistrict(int x, int y, int d1Lim, int d2Lim) {
        int[] dx = {-1, 1, 1, -1};
        int[] dy = {1, 1, -1, -1};

        int nx;
        int ny;

        for (int d1 = 1 ; d1 <= d1Lim ; d1++) {
            for (int d2 = 1 ; d2 <= d2Lim ; d2++) {
                nx = x;
                ny = y;
                district = new int[N][N];
                for(int i = 0 ; i < d1 ; i++) {
                    nx = nx + dx[0];
                    ny = ny + dy[0];
                    district[ny][nx] = 5;
                }
//                for(int i = nx-1 ; i >= 0 ; i--) {
//                    district[ny][i] = 3;
//                }
                for(int i = 0 ; i < d2 ; i++) {
                    nx = nx + dx[1];
                    ny = ny + dy[1];
                    district[ny][nx] = 5;
                }
//                for(int i = ny + 1 ; i < N ; i++) {
//                    district[i][nx] = 4;
//                }
                for(int i = 0 ; i < d1 ; i++) {
                    nx = nx + dx[2];
                    ny = ny + dy[2];
                    district[ny][nx] = 5;
                }
//                for(int i = nx+1 ; i < N ; i++) {
//                    district[ny][i] = 2;
//                }
                for(int i = 0 ; i < d2 ; i++) {
                    nx = nx + dx[3];
                    ny = ny + dy[3];
                    district[ny][nx] = 5;
                }
//                for(int i = ny-1 ; i >= 0 ; i--) {
//                    district[i][nx] = 1;
//                }

//                bfs(new Node(0,0), 1);
//                bfs(new Node(N-1, 0), 2);
//                bfs(new Node(0, N-1), 3);
//                bfs(new Node(N-1, N-1), 4);
                answer = Math.min(answer, getTmpMin(x, y, d1, d2));
            }
        }
    }
    private static int getTmpMin(int x, int y, int d1, int d2) {
        int[] sumArr = {0,0,0,0,0};
        for (int i = 0 ; i < y+d1; i++) {
            for (int j = 0 ; j <= x ; j++) {
                if (district[i][j] == 5)
                    break;
                sumArr[1] += map[i][j];
            }
        }
        for (int i = 0 ; i <= y+d2 ; i++) {
            for (int j = N-1 ; j > x ; j--) {
                if (district[i][j] == 5)
                    break;
                sumArr[2] += map[i][j];
            }
        }
        for (int i = N-1 ; i >= y+d1 ; i--) {
            for (int j = 0 ; j < x+d2-d1 ; j++) {
                if (district[i][j] == 5)
                    break;
                sumArr[3] += map[i][j];
            }
        }
        for (int i = N-1 ; i > y+d2 ; i--) {
            for (int j = N-1 ; j >= x+d2-d1 ; j--) {
                if (district[i][j] == 5)
                    break;
                sumArr[4] += map[i][j];
            }
        }
        boolean flag = false;
        sumArr[0] += map[y][x] + map[y+d1+d2][x+d2-d1];
        for (int i = y+1 ; i < y+d1+d2 ; i++) {
            for (int j = x - d1 ; j <= x+d2 ; j++) {
                if(district[i][j] == 5) {
                    sumArr[0] += map[i][j];
                    flag = !flag;
                    continue;
                }
                if (flag)
                    sumArr[0] += map[i][j];

            }
        }
//        printMap();
//        for(int i : sumArr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        Arrays.sort(sumArr);
        return sumArr[4]-sumArr[0];
    }
//    private static Queue<Node> queue = new LinkedList<>();

//    private static int getTmpMin() {
//        int[] sumArr = {0,0,0,0,0};
//        for (int i = 0 ; i < N ; i++) {
//            for (int j = 0 ; j < N ; j++) {
//                sumArr[district[i][j]%5] += map[i][j];
//            }
//        }
//        Arrays.sort(sumArr);
//        return sumArr[4]-sumArr[0];
//    }

//    private static void bfs(Node start, int sectionNum) {
//        int[] bfsDx = {1, 0, -1, 0};
//        int[] bfsDy = {0, 1, 0, -1};
//        queue.add(start);
//
//        while (!queue.isEmpty()) {
//            Node now = queue.poll();
//            district[now.y][now.x] = (char)sectionNum;
//            for (int i = 0 ; i < 4 ; i++) {
//                int nx = now.x + bfsDx[i];
//                int ny = now.y + bfsDy[i];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < N && district[ny][nx] == 0) {
//                    queue.add(new Node(nx, ny));
//                }
//            }
//        }
//    }
//    private static void printMap() {
//        for (int i = 0 ; i < N ; i++) {
//            for (int j = 0 ; j < N ; j++) {
//                System.out.print(district[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

//    static class Node {
//        int x;
//        int y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
