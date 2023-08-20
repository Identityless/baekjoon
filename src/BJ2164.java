import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BJ2164 {
    private static Deque<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            process();
        }

        bw.write(deque.poll()+"");
        bw.flush();
        bw.close();
    }

    private static void process() {
        deque.pollFirst();
        deque.addLast(deque.pollFirst());
    }
}
