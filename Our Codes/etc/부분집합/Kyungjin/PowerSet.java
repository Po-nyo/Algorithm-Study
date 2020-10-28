package subset.solution;

public class PowerSet {

    private int[] superSet;

    public void printEverySubset(int[] superSet) {
        this.superSet = superSet;

        printSubset(new int[]{});
        for(int i=1; i<=superSet.length; i++)
            n_subset(0, 0, new int[i]);
    }

    private void n_subset(int depth, int start, int[] subset) {
        if(depth == subset.length)
            printSubset(subset);
        else {
            for (int i=start; i<superSet.length; i++) {
                subset[depth] = superSet[i];
                n_subset(depth+1, i+1, subset);
            }
        }
    }

    private void printSubset(int[] subset) {
        System.out.print("{ ");
        for(int i : subset)
            System.out.print(i + " ");
        System.out.println("}");
    }
}
