import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BJ18258 {
    private static Deque<String> deque = new LinkedList<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            String cmd = br.readLine();
            process(cmd);
        }
        bw.flush();
        bw.close();
    }

    private static void process(String cmd) throws IOException {
        String[] arr = cmd.split(" ");

        switch (arr[0]) {
            case "push": {
                deque.add(arr[1]);
                break;
            }
            case "pop": {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                    break;
                }
                bw.write(deque.pop()+"\n");
                break;
            }
            case "size": {
                bw.write(deque.size()+"\n");
                break;
            }
            case "empty": {
                if (deque.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
                break;
            }
            case "front": {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                    break;
                }
                bw.write(deque.peekFirst()+"\n");
                break;
            }
            case "back": {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                    break;
                }
                bw.write(deque.peekLast()+"\n");
                break;
            }
        }
    }
}
