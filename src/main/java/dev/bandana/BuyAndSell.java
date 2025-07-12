package dev.bandana;

/*
    Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
 */

public class BuyAndSell {
    public static void main(String[] args) {

        int arr [] = {1, 4, 5, 2, 4};

        buyAndSellStock(arr);

    }
     public static void buyAndSellStock(int a[]){
        int n = a.length;
        int minPrice = Integer.MAX_VALUE;
        int price = 0;

        for(int i = 0; i < n; i++){
            if(a[i] < minPrice){
                minPrice = a[i];
            }
            else {
                price = Math.max(price, a[i] - minPrice);
            }
        }
        System.out.println("Maximum benifit : " + price);
     }

}
