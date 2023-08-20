import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BJ12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int seq = 1;
        int[] peoples = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0 ; i < N ; i++) {
            if (peoples[i] != seq) {
                while (!stack.isEmpty() && stack.peek() == seq) {
                    stack.pop();
                    seq++;
                }
                stack.push(peoples[i]);
            }
            else
                seq++;
        }

        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (tmp != seq) {
                bw.write("Sad");
                break;
            }
            else
                seq++;
        }

        if (stack.isEmpty())
            bw.write("Nice");

        bw.flush();
        bw.close();
    }
}
