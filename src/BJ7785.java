import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<String, Boolean> dict = new HashMap<>();
        for (int i = 0 ; i < N ; i++) {
            String[] tmp = br.readLine().split(" ");
            if (tmp[1].equals("enter")) {
                dict.put(tmp[0], true);
            }
            else {
                dict.remove(tmp[0]);
            }
        }
        List<String> list = new ArrayList<>(dict.keySet());
        list.sort(Comparator.reverseOrder());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            bw.write(it.next()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
