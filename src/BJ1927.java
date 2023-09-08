import java.io.*;
import java.util.*;

public class BJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (minHeap.isEmpty())
                    bw.write(0+"\n");
                else
                    bw.write(minHeap.poll()+"\n");
            } else {
                minHeap.add(tmp);
            }
        }
        bw.flush();
        bw.close();

    }
}
