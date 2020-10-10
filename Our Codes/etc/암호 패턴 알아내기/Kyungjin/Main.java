package crypt.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        String coded = br.readLine();

        new Solution().solve(original, coded);
    }
}
