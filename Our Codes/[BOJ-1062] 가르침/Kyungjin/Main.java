import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] input = line.split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String[] words = new String[n];

        for(int i=0; i<n; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4);
        }

        new Solution().solve(words, k);
    }
}
