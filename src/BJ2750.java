import java.util.*;
import java.io.*;

public class BJ2750 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        List<Integer> list = new ArrayList<>();
        int numOfNum = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < numOfNum ; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());

        for(int k : list) {
            bw.write(k+"\n");
        }
        bw.flush();
        bw.close();
    }
}
