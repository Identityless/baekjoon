import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BJ1269 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Set<Integer> set = new HashSet<>(Arrays.stream(list).collect(Collectors.toSet()));

        int intersection = 0;

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int b : a) {
            if (set.contains(b)) {
                intersection++;
            }
        }
        bw.write((NM[0] + NM[1] - intersection * 2) + "");
        bw.flush();
        bw.close();
    }
}
