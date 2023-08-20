import java.io.*;
import java.util.Stack;

public class BJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals("."))
                break;
            if (isValid(s))
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isValid(String ps) {
        Stack<String> stack = new Stack<>();

        for (int i = 0 ; i < ps.length() ; i++) {
            String tmp = ps.substring(i, i+1);
            if (stack.isEmpty() && (tmp.equals(")") || tmp.equals("]")))
                return false;
            if (tmp.equals("(") || tmp.equals("["))
                stack.push(tmp);
            else if (tmp.equals(")")) {
                if (stack.peek().equals("("))
                    stack.pop();
                else
                    return false;
            }
            else if (tmp.equals("]")) {
                if (stack.peek().equals("["))
                    stack.pop();
                else
                    return false;
            }
        }

        if (stack.size() > 0)
            return false;
        return true;
    }
}
