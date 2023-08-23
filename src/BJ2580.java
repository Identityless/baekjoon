import java.io.*;
import java.util.*;

public class BJ2580 {

    private static int[][] map = new int[9][];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 9 ; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        find();

        for (int[] i : map) {
            for (int j : i) {
                bw.write(j+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean find() {
        boolean flag;
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (map[i][j] == 0) {
                    List<Integer> insertList = getInsertList(j, i);
                    if (insertList.size() == 0)
                        return false;
                    for (int k : insertList) {
                        map[i][j] = k;
                        flag = find();
                        if (flag) {
                            return true;
                        }
                    }
                    map[i][j] = 0;
                    return false;
                }
            }
        }
        return true;
    }

    private static List<Integer> getInsertList(int x, int y) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> noSet = new HashSet<>();
        for (int i = 0 ; i < 9 ; i++) {
            noSet.add(map[y][i]);
            noSet.add(map[i][x]);
        }
        for (int i = y-(y%3) ; i < y-(y%3)+3 ; i++) {
            for (int j = x-(x%3); j < x-(x%3)+3 ; j++) {
                noSet.add(map[i][j]);
            }
        }
        for (int i = 1 ; i <= 9 ; i++) {
            if (!noSet.contains(i))
                list.add(i);
        }
        return list;
    }
}
