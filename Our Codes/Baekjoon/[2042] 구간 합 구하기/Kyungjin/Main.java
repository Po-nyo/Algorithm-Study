package boj_2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] array = new long[n];
        for(int i=0; i<n; i++)
            array[i] = Integer.parseInt(br.readLine());

        SegmentTree segTree = new SegmentTree(array);

        for(int i=0; i<m+k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if(a == 1)
                segTree.update(b-1, c);
            else if(a == 2)
                System.out.println(segTree.getSum(b-1, (int)c-1));
        }

        br.close();
    }

}
