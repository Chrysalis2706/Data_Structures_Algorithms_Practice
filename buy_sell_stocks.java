public class buy_sell_stocks {

    public static int buy_sell_stock(int arr[]){
        int maxProfit = 0;
        int buy_price = Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++){
            if (buy_price < arr[i]){
                int current_profit = arr[i] - buy_price; // today's profit
                maxProfit = Math.max(current_profit, maxProfit);
            }else {
                buy_price = arr[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int maxProfit = buy_sell_stock(prices);
        System.out.println(maxProfit);
    }
}
