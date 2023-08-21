import java.io.*;
import java.util.*;

public class BJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] mode = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] queueStack = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = N-1 ; i >= 0 ; i--) {
            if (mode[i] == 0) {
                queue.add(queueStack[i]);
            }
        }
        for (int i = 0 ; i < num ; i++) {
            queue.add(inputs[i]);
            bw.write(queue.poll()+" ");
        }

        bw.flush();
        bw.close();
    }
}
