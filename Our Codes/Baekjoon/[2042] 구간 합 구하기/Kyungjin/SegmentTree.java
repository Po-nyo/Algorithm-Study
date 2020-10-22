package boj_2042;

public class SegmentTree {

    private long[] segTree;
    private long[] array;
    private final int root = 1;
    private int begin;
    private int end;

    public SegmentTree(long[] array) {
        this.array = array;
        int size = (int)Math.pow(2, (int)Math.ceil((Math.log(array.length)/Math.log(2)+1))) + 1;
        segTree = new long[size];

        this.begin = 0;
        this.end = array.length-1;

        inIt(root, begin, end);
    }

    private long inIt(int n, int begin, int end) {
        if(begin == end)
            segTree[n] = array[begin];
        else {
            int mid = (begin + end) / 2;
            segTree[n] = inIt(2*n, begin, mid) + inIt(2*n+1, mid+1, end);
        }

        return segTree[n];
    }

    public long getSum(int from, int to) {
        return getSum_recursively(root, begin, end, from, to);
    }

    private long getSum_recursively(int n, int begin, int end, int from, int to) {
        if(from > end || to < begin)
            return 0;
        else if(from <= begin && to >= end)
            return segTree[n];
        else {
            int mid = (begin + end) / 2;
            return getSum_recursively(2*n, begin, mid, from, to) + getSum_recursively(2*n+1, mid+1, end, from, to);
        }
    }

    public void update(int index, long newValue) {
        long diff = newValue - array[index];
        array[index] = newValue;
        update_recursively(root, begin, end, index, diff);
    }

    private void update_recursively(int n, int begin, int end, int index, long diff) {
        if(index < begin || index > end)
            return;
        else {
            segTree[n] += diff;
            if(begin == end)
                return;
            else {
                int mid = (begin + end) / 2;
                update_recursively(2*n, begin, mid, index, diff);
                update_recursively(2*n+1, mid+1, end, index, diff);
            }
        }
    }

}
