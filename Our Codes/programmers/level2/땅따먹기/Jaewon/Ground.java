public class Ground {
    public static void main(String[] args) {
        int[][] land = {{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}};
        Ground g = new Ground();
        g.answer(land);
    }

    private int answer(int[][] land) {
        Ground g = new Ground();
        int max = land[0][g.maxIndex(land[0],-1)];
        int prior = g.maxIndex(land[0],-1);
        int second = land[0][g.maxIndex(land[0],prior)];

        for(int i=1;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                if(j==prior)
                    land[i][j]+=second;
                else
                    land[i][j]+=max;
            }

            max = land[i][g.maxIndex(land[i],-1)];
            prior = g.maxIndex(land[i],-1);
            second = land[i][g.maxIndex(land[i],prior)];

        }
        return max;
    }


    private int maxIndex(int[] land,int prior){
        int max=0;
        int maxIndex=0;

        for(int i=0;i<land.length;i++){
            if(max<land[i] && i!=prior){
                max = land[i];
                maxIndex = i;
            }

        }

        return maxIndex;
    }


}
