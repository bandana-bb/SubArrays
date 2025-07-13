package dev.bandana;


import java.util.Scanner;

/*
Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.
 */
public class MinimumSwaps {
    public static void main(String[] args) {

        int [] arr = {1, 12, 10, 3, 14, 10, 5};
        Scanner in = new Scanner(System.in);
        int B = in.nextInt();

        findMinSwaps(arr, B);

    }

    public static void findMinSwaps(int[] arr, int B) {
        int min = Integer.MAX_VALUE;
        int numberlessB = 0;

        int n = arr.length;

        //find total elements with less B
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]<=B){
                numberlessB++;
            }
        }

        // try find bad element in first window
        int k = numberlessB;
        int temp = 0;
        for(int i =0 ;i <k;i++) {
            if(arr[i]>B){
               temp ++;
            }
        }

        int minSwaps = Integer.MAX_VALUE;
        minSwaps = temp;
        int swaps = minSwaps;

        int s =1;
        int e =k;

        while (e < n){
            if(arr[s-1]>B){
                swaps --;
            }
            if(arr[e]>B){
                swaps ++;
            }
            if(swaps<minSwaps){
                minSwaps = swaps;
            }
            s++;
            e++;
        }

        System.out.println("Total minimum swaps: " +
                minSwaps);
    }
}
