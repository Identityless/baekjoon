import java.util.*;
import java.io.*;
public class BJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> dict = new HashMap<>();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> {
            if (dict.containsKey(it)) {
                dict.put(it, dict.get(it)+1);
            } else {
                dict.put(it, 1);
            }
        });
        int M = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> {
            try {
                if (dict.containsKey(it)) {
                    bw.write(dict.get(it) + " ");
                } else {
                    bw.write("0 ");
                }
            } catch (IOException e) {}
        });
        bw.flush();
        bw.close();
    }
}
