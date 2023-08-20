import java.util.*;
import java.io.*;
public class BJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> dict = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < NM[0] ; i++) {
            String tmp = br.readLine();
            dict.put(tmp, i+1);
            list.add(tmp);
        }
        for (int i = 0 ; i < NM[1] ; i++) {
            String tmp = br.readLine();
            if (tmp.charAt(0) > 47 && tmp.charAt(0) < 58) {
                bw.write(list.get(Integer.parseInt(tmp)-1)+"\n");
            }
            else {
                bw.write(dict.get(tmp)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
