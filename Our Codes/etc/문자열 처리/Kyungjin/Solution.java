package text_process.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private String a;
    private String b;
    private final String[] rank = {"Miss", "Good", "Perfect"};

    public Solution(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public void command_u() {
        this.a = a.substring(1);
        this.b = b.substring(0, b.length()-1);
    }

    public void command_d() {
        this.a = a.substring(0, a.length()-1);
        this.b = b.substring(1);
    }

    public void command_e() {
        if(a.length() == 0)
            System.out.println(this.rank[0]);
        else {
            Set<Character> b_char_set = new HashSet<>();

            for(int i=0; i<b.length(); i++)
                b_char_set.add(b.charAt(i));

            System.out.println(this.rank[getRank(b_char_set)]);
        }
    }

    private int getRank(Set<Character> char_set) {
        boolean case_flag = false;

        for(int i=0; i<a.length(); i++) {
            char current = a.charAt(i);

            if(isValidChar(current) && !char_set.contains(current)) {
                char lowercase = Character.toLowerCase(current);
                char uppercase = Character.toUpperCase(current);

                if(!char_set.contains(lowercase) && !char_set.contains(uppercase))
                    return 0;
                else
                    case_flag = true;
            }
        }

        if(case_flag)
            return 1;

        return 2;
    }

    private boolean isValidChar(char c) {
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}
