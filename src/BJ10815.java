import java.util.*;
import java.io.*;
public class BJ10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> dict = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ")).forEach(it -> dict.put(Integer.parseInt(it), 1));
        int M = Integer.parseInt(br.readLine());
        int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int target : targets) {
            if (dict.containsKey(target)) {
                bw.write("1 ");
            }
            else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
    }
}
