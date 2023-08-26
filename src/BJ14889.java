import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ14889 {
    private static int N;
    private static int[][] table;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        table = new int[N][];

        for (int i = 0 ; i < N ; i++) {
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        find(new ArrayList<>(), 0);

        bw.write(min+"");
        bw.flush();
        bw.close();
    }

    private static void find(List<Integer> team1, int sp) {
        if (N/2 - team1.size() > N - sp)
            return;
        if (team1.size() == N/2) {
            min = Math.min(min, processBalance(team1));
            return;
        }
        for (int i = sp ; i < N ; i++) {
            if (!team1.contains(i)) {
                team1.add(i);
                find(team1, i);
                team1.remove(team1.size()-1);
            }
        }
    }

    private static int processBalance(List<Integer> team1) {
        List<Integer> team2 = new ArrayList<>();
        int power1 = 0, power2 = 0;
        for (int i = 0 ; i < N ; i++) {
            if (!team1.contains(i)) {
                team2.add(i);
            }
        }
        for (int i = 0 ; i < N/2 ; i++) {
            for (int j = i ; j < N/2 ; j++) {
                power1 += table[team1.get(i)][team1.get(j)];
                power1 += table[team1.get(j)][team1.get(i)];
                power2 += table[team2.get(i)][team2.get(j)];
                power2 += table[team2.get(j)][team2.get(i)];
            }
        }
        return Math.abs(power1 - power2);
    }
}
