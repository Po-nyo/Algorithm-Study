package text_categorize.solution;

public class Solution {

    public void solve(String line) {
        StringBuilder en_sb = new StringBuilder();
        StringBuilder ko_sb = new StringBuilder();

        for(int i=0; i<line.length(); i++) {
            char current = line.charAt(i);

            if(isEnglish(current))
                en_sb.append(current);
            else
                ko_sb.append(current);
        }

        System.out.println(en_sb.toString() + ko_sb.toString());
        System.out.println(en_sb.length() + " " + ko_sb.length() + " " + line.length());
    }

    private boolean isEnglish(char c) {
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}
