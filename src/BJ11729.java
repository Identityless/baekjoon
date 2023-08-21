import java.io.*;

public class BJ11729 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 25);

        int N = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, N)-1+"\n");

        hanoi(N, 1, 3, 2);

        bw.flush();
        bw.close();
    }

    private static void hanoi(int height, int from, int to, int via) throws IOException {
        if (height == 1) {
            bw.write(from + " " + to+"\n");
            return;
        }
        hanoi(height-1, from, via, to);
        bw.write(from + " " + to+"\n");
        hanoi(height-1, via, to, from);
    }
}
