import java.io.*;
import java.util.Stack;

public class BJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < N ; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
                stack.pop();
            else
                stack.push(input);
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
