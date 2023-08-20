import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BJ1181 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for (int i = 0 ; i < N ; i++) {
            strings[i] = br.readLine();
        }

        String[] distinctedStrings = Arrays.stream(strings).distinct().toArray(String[]::new);

        Arrays.sort(distinctedStrings, (e1, e2) -> {
            if(e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }
            return e1.length() - e2.length();
        });

        Arrays.stream(distinctedStrings).forEach(it -> {
            try {
                bw.write(it+"\n");
            } catch (IOException e)
            {}
        });
        bw.flush();
        bw.close();
    }
}
