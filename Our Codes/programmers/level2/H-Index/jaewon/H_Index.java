public class H_Index {
    public static void main(String[] args){
        int[] citations = {3,0,6,1,5};
        H_Index a = new H_Index();

        System.out.println(a.H(citations));
    }

    private int H(int[] citations){
        int max = max(citations);
        int H=0;

        for(int i=0;i<=max;i++){
            int count=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i)
                    count++;
            }

            if(count>=i&&count>=H)
                H = i;
        }

        return H;
    }
    private int max(int[] citations){
        int max=0;
        for(int i=0;i<citations.length;i++){
            if(max<=citations[i])
                max=citations[i];
        }
        return max;
    }
}
