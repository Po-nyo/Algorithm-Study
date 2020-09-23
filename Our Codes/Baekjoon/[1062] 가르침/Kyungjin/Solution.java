import java.util.ArrayList;

public class Solution {

    private String[] words;
    private boolean[] alphabets;
    private ArrayList<Character> candidates;
    private int max;

    public void solve(String[] words, int k) {
        this.words = words;
        this.alphabets = new boolean[26];
        this.max = 0;

        this.candidates = candidates();

        if(k < 5)
            this.max = 0;
        else if(candidates.size() <= k-5)
            this.max = words.length;
        else
            backtrack(0, 5, k);

        System.out.println(this.max);
    }

    private ArrayList<Character> candidates() {
        alphabets[0] = true;
        alphabets['n' - 'a'] = true;
        alphabets['t' - 'a'] = true;
        alphabets['i' - 'a'] = true;
        alphabets['c' - 'a'] = true;

        ArrayList<Character> list = new ArrayList<>();

        for (String word: words) {
            for (int i=0; i<word.length(); i++) {
                char current = word.charAt(i);

                if (!alphabets[current - 'a'] && !list.contains(current))
                    list.add(current);
            }
        }

        return list;
    }

    private void backtrack(int start, int depth, int k) {
        if(depth == k) {
            count();
        }
        else {
            for(int i=start; i<this.candidates.size(); i++) {
                char c = this.candidates.get(i);
                this.alphabets[c-'a'] = true;
                backtrack(i+1, depth+1, k);
                this.alphabets[c-'a'] = false;
            }
        }
    }

    private void count() {
        int cnt = 0;

        Loop:
        for(String word: this.words) {
            for(int i=0; i<word.length(); i++) {
                if(!alphabets[word.charAt(i)-'a'])
                    continue Loop;
            }
            cnt++;
        }

        this.max = Math.max(this.max, cnt);
    }
}
