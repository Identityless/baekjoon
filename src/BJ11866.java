import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= input[0] ; i++) {
            list.add(i);
        }
        bw.write("<");
        int idx = 0;
        while (true) {
            idx = (idx+input[1]-1) % list.size();
            bw.write(list.get(idx)+"");
            list.remove(idx);
            if (list.isEmpty())
                break;
            bw.write(", ");
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
