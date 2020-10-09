package text_process.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        Solution s = new Solution(a, b);

        while(true) {
            String command = br.readLine();

            if(command.equals("u"))
                s.command_u();
            else if(command.equals("d"))
                s.command_d();
            else if(command.equals("e")) {
                s.command_e();
                break;
            }
            else
                System.out.println("잘못된 명렁입니다.");
        }
    }
}
