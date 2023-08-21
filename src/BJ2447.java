import java.io.*;

public class BJ2447 {

    private static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        process(N, 0, 0, N, N);

        for (String[] y : map) {
            for (String x : y) {
                bw.write(x);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void process(int size, int startX, int startY, int endX, int endY) {
        if (size == 1)
            return;
        for (int i = startY ; i < endY ; i++) {
            for (int j = startX ; j < endX ; j++) {
                if (j >= startX+size/3 && j < startX+(size/3)*2 && i >= startY+size/3 && i < startY+(size/3)*2) {
                    map[i][j] = " ";
                }
                else {
                    map[i][j] = "*";
                }
            }
        }
        for (int i = startY ; i < endY; i+=(size/3)) {
            for (int j = startX ; j < endX ; j+=(size/3)) {
                if (j >= startX+size/3 && j < startX+(size/3)*2 && i >= startY+size/3 && i < startY+(size/3)*2)
                    continue;
                else {
                    process(size/3, j, i, j+(size/3), i+(size/3));
                }
            }
        }
    }
}
