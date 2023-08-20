import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BJ28278 {
    private static Stack<Integer> stack = new Stack<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            String p = br.readLine();
            process(p);
        }
        bw.flush();
        bw.close();
    }
    private static void process(String p) throws IOException {
        switch (p.charAt(0)) {
            case '1': {
                int tmp[] = Arrays.stream(p.split(" ")).mapToInt(Integer::parseInt).toArray();
                stack.push(tmp[1]);
                break;
            }
            case '2': {
                if (stack.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(stack.pop()+"\n");
                break;
            }
            case '3': {
                bw.write(stack.size()+"\n");
                break;
            }
            case '4': {
                if (stack.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0 ");
                break;
            }
            case '5': {
                if (stack.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(stack.peek()+"\n");
                break;
            }
        }
    }
}
