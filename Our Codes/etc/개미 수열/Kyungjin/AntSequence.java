package ant_sequence.solution;

import java.util.ArrayList;
import java.util.List;

public class AntSequence {

    private List<String> sequence;

    public AntSequence(String start) {
        this.sequence = new ArrayList<>();

        sequence.add(start);
    }

    public String getNthSequence(int n) {
        if(sequence.size() < n)
            process(n);

        return sequence.get(n-1);
    }

    private void process(int n) {
        while(sequence.size() < n) {
            String lastSequence = sequence.get(sequence.size() - 1);
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<lastSequence.length(); i++) {
                char current = lastSequence.charAt(i);
                int count = count_continuous(lastSequence, current, i);

                sb.append(current).append(count);

                i += count-1;
            }

            sequence.add(sb.toString());
        }
    }

    private int count_continuous(String str, char target, int start) {
       int count = 1;

       for(int i=start+1; i<str.length(); i++) {
           char current = str.charAt(i);

           if(target == current)
               count++;
           else
               return count;
       }

       return count;
    }
}
