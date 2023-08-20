import java.util.*;
import java.io.*;
public class BJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> noListen = new HashSet<>();
        List<String> answer = new ArrayList<>();
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0 ; i < NM[0] ; i++) {
            noListen.add(br.readLine());
        }
        for (int i = 0 ; i < NM[1] ; i++) {
            String tmp = br.readLine();
            if (noListen.contains(tmp)) {
                answer.add(tmp);
            }
        }
        answer.sort(Comparator.naturalOrder());
        bw.write(answer.size()+"\n");
        for (String k : answer) {
            bw.write(k+"\n");
        }
        bw.flush();
        bw.close();
    }
}
