import java.util.*;
import java.io.*;
public class BJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Boolean> dict = new HashMap<>();
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for (int i = 0 ; i < NM[0] ; i++) {
            dict.put(br.readLine(), true);
        }
        for (int i = 0 ; i < NM[1] ; i++) {
            if (dict.containsKey(br.readLine())) {
                answer++;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
