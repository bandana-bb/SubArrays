package dev.bandana;

import java.util.Scanner;

public class PrintSubArr {

    public static void main(String[] args) {
        int []arr = {4, 2, 10, 3, 12, -2, 15};
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        printSubArray(arr);
        printSubArrStartToEnd(arr, start, end);
        findLenthOfSmallestSubArr(arr);
        findLengthOfSmallestSubArrOp(arr);

    }

    // Print all SubArray
    public static void printSubArray(int []a) {
        int n = a.length;
        int Total_Sub_Array = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
            System.out.println("***********************");
        }
        System.out.println("Total number of subArrays: " + n*(n+1)/2);

    }

    //Print SubArr from Start and End
    public static void printSubArrStartToEnd(int []a, int start, int end) {
        int n = a.length;
        int count = 0;
        for(int i=0; i<=end; i++) {
            for(int j=start; j<=i; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
            count++;
        }
        System.out.println("Total number of subArrays: " + count);


    }

    //Brute force approach
    public static void findLenthOfSmallestSubArr(int []a) {
        int n = a.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Smallest element: " + min + " " + "Largest element: " + max);

        //minLenth set to max so later we can compare to get smallest one
        int minLenth = n+1;
        for(int i =0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                boolean hasMin =false;
                boolean hasMax =false;
                for(int k=i; k<=j; k++) {
                    if(a[k] == min) {
                        hasMin = true;
                    }
                    if(a[k] == max){
                        hasMax = true;
                    }
                }

                //length starting at i and ending at j
                if(hasMin && hasMax) {
                    minLenth = Math.min(minLenth, j-i+1);
                }
            }
        }
        System.out.println("Brute Force Approach ---------------------");
        System.out.println("Smallest Lenth of SubArray Having min & max : " + minLenth);


    }

    //Optimized approach
    public static void findLengthOfSmallestSubArrOp(int []a) {
        int n = a.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }

        int last_min_Index = -1;
        int last_max_Index = -1;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(a[i] == min) {
                last_min_Index = i;
                if (last_max_Index != -1) {
                    ans = Math.min(ans, i - last_max_Index + 1);
                }
            }

            if(a[i] == max) {
                last_max_Index = i;
                if (last_min_Index != -1) {
                    ans = Math.min(ans, i - last_min_Index + 1);
                }
            }
        }
        System.out.println( " Optimized approach ");
        System.out.println( " Length of Smallest SubArray : " + ans );

    }

}


