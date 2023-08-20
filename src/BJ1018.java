import java.io.*;
import java.util.Arrays;

public class BJ1018 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] map = new String[NM[0]][NM[1]];
        int count1 = 0, count2 = 0, count;
        String[][] mapStartWithW = new String[NM[0]][NM[1]];
        String[][] mapStartWithB = new String[NM[0]][NM[1]];
        String[] sources = {"B", "W"};
        int start = 0, now;
        int min = 64;

        for(int i = 0 ; i < NM[0] ; i++) {
            map[i] = br.readLine().split("");
        }
        for(int i = 0 ; i < 8 ; i++) {
            now = start;
            for (int j = 0 ; j < 8 ; j++) {
                mapStartWithB[i][j] = sources[now];
                mapStartWithW[i][j] = sources[getNextIdx(now)];
                now = getNextIdx(now);
            }
            start = getNextIdx(start);
        }

        for (int a = 0 ; a <= NM[0] - 8 ; a++) {
            for (int b = 0 ; b <= NM[1] - 8 ; b++) {
                count1 = 0;
                count2 = 0;
                for (int i = 0 ; i < 8 ; i++) {
                    for (int j = 0 ; j < 8 ; j++) {
                        if(!mapStartWithB[i][j].equals(map[i+a][j+b])) {
                            count1++;
                        }
                        if(!mapStartWithW[i][j].equals(map[i+a][j+b])) {
                            count2++;
                        }
                    }
                }
                if (count1 < min) {
                    min = count1;
                }
                if (count2 < min) {
                    min = count2;
                }
            }
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
    }

    private static int getNextIdx(int x) {
        return ++x%2;
    }

}
