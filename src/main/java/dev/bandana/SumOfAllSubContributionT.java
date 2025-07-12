package dev.bandana;

import java.util.Scanner;

public class SumOfAllSubContributionT {
    public static void main(String[] args) {
        int [] arr = {2, -1, 4, 7, 2 };
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        SumSubArrContriTech(arr);

        printStartEndLengthK(arr,K);
        findMaxSumLengthK(arr, K);

        SumMaxSubLenK(arr, K);

        findSlideWndwSum(arr,K);
    }

    //Contribution Technique
    public static void SumSubArrContriTech(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int start = i+1;
            int end = n-i;
            int freq = start * end;
            sum = sum + (freq*arr[i]);
        }
        System.out.println("Sum of all SubArray is: "+ sum);
    }

    public static void printStartEndLengthK(int[] arr, int K) {
        int n = arr.length;
        for(int s=0; s<=n-K; s++){
            int end = K+s-1;
            System.out.println("Start : "+ s + " and "+ "End: "+ end);
        }

    }
    //Fixed lenth of Window
    public static void findMaxSumLengthK(int[] arr, int K) {
        int n = arr.length;
         int s =0;
         int e = K-1;
         long ans = Integer.MIN_VALUE;
         while(e<n){
             int sum =0 ;
             for(int i = s;i<=e; i++){
                 sum += arr[i];
             }
            ans = Math.max(ans,sum);
             s++;
             e++;
         }
        System.out.println("Sum of Max length subArr " + ans);
    }

    //Using prefix sum
    public static void SumMaxSubLenK(int[] arr, int K) {
        int n = arr.length;

        //Calculate prefix Sum
        int pref [] =new int [n];
        pref[0]=arr[0];
        for(int i=1;i<n;i++){
            pref[i] = pref[i-1]+arr[i];
        }

        int s = 0;
        int e =K-1;
        long ans = Integer.MIN_VALUE;
        while(e<n){
            long sum =0;
            if(s == 0){
                sum+= pref[e];
            }
            else {
                sum+= pref[e]-pref[s-1];
            }
            ans = Math.max(ans, sum);
            s++;
            e++;
        }
        System.out.println("Sum of Max length subArr using PrefixSum " + ans);
    }

    //Sliding Window

    public static void findSlideWndwSum(int[] arr, int K) {
        int n = arr.length;
        //calculate sum of first  window
        long sum = 0;
        for(int i =0;i <K ;i ++){
            sum+=arr[i];
        }
        //Calculate sum for next windows

        int s =1;
        int e =K;
        long ans = Integer.MIN_VALUE;
        while(e<n){
            sum+= arr[e]-arr[s-1];
            ans = Math.max(ans, sum);
            s++;
            e++;
        }
        System.out.println("Sum of Max length subArr using Sliding Window " + ans);
    }
}
