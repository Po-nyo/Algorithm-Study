package automata.solution;

import java.util.Arrays;

public class Automata {

    private int cnt;
    private int[] sequence;
    private int[] prev_sequence;

    public void solve(int[] sequence) {
        this.cnt = 0;
        this.sequence = sequence;
        backtrack(new int[sequence.length], 0);

        if(cnt > 1)
            System.out.print("multiple");
        else if(cnt == 1)
            Arrays.stream(prev_sequence).forEach(System.out::print);
        else
            System.out.print("zero");

        System.out.println();
    }

    private void backtrack(int[] prev, int index) {
        if(index == sequence.length) {
            this.prev_sequence = prev.clone();
            cnt++;
        }
        else {
            int[] candidates = new int[2];
            int n = getCandidates(candidates, prev, index);

            for(int i=0; i<n; i++) {
                prev[index] = candidates[i];
                backtrack(prev, index + 1);
            }
        }
    }

    private int getCandidates(int[] candidates, int[] prev_seq, int index) {
        int count = 0;

        int prev = getIndex(index - 1);
        int prev_prev = getIndex(prev - 1);
        int next = getIndex(index + 1);
        int next_next = getIndex(next + 1);

        for(int i=0; i<=1; i++) {
            boolean[] negative_cases = new boolean[6];

            negative_cases[0] = prev < index && next < index && prev_seq[prev] == prev_seq[next] && sequence[index] != i;
            negative_cases[1] = prev < index && next < index && prev_seq[prev] != prev_seq[next] && sequence[index] == i;
            negative_cases[2] = prev_prev < index && prev < index && sequence[prev] == prev_seq[prev] && prev_seq[prev_prev] != i;
            negative_cases[3] = prev_prev < index && prev < index && sequence[prev] != prev_seq[prev] && prev_seq[prev_prev] == i;
            negative_cases[4] = next_next < index && next < index && sequence[next] == prev_seq[next] && prev_seq[next_next] != i;
            negative_cases[5] = next_next < index && next < index && sequence[next] != prev_seq[next] && prev_seq[next_next] == i;

            if(negative_cases[0] || negative_cases[1] || negative_cases[2] || negative_cases[3] || negative_cases[4] || negative_cases[5])
                continue;

            candidates[count++] = i;
        }

        return count;
    }

    private int getIndex(int index) {
        return (index + sequence.length) % sequence.length;
    }
}