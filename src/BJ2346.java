import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Balloon> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1 ; i <= N ; i++) {
            list.add(new Balloon(i, arr[i-1]));
        }

        int idx = 0;
        while (true) {
            Balloon tmp = list.get(idx);
            list.remove(idx);
            bw.write(tmp.seq+" ");
            if (list.isEmpty())
                break;
            if (tmp.value > 0) {
                idx = (idx + tmp.value - 1) % list.size();
            }
            if (tmp.value < 0) {
                idx = (idx + tmp.value) % list.size();
                idx = idx >= 0 ? idx : list.size() + idx;
            }
        }

        bw.flush();
        bw.close();
    }
    static class Balloon {
        int seq;
        int value;

        public Balloon(int seq, int value) {
            this.seq = seq;
            this.value = value;
        }
    }
}
