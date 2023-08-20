import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BJ11478 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 1 ; i <= string.length() ; i++) {
            for (int j = 0 ; i+j <= string.length() ; j++) {
                set.add(string.substring(j, i+j));
            }
        }
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
    }
}
