public class StockPrice {
    public static void main(String[] args){
        int[] prices = {1,2,3,2,3};
        StockPrice a = new StockPrice();

        a.time(prices);

        for(int i : prices)
            System.out.print(i+" ");

    }
    private int[] time(int[] prices) {

        for (int i=0;i<prices.length;i++){
            int time=-1;

            for (int j=i;j<prices.length;j++) {
                time++;

                if(prices[i]>prices[j])
                    break;

            }
            prices[i]=time;
        }

        return prices;
    }
}
