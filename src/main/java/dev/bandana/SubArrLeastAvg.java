package dev.bandana;

import java.util.Scanner;

public class SubArrLeastAvg {
    public static void main(String[] args) {
        int [] arr = {3, 7, 5, 20, -10, 0, 12};
        Scanner in = new Scanner(System.in);
        int B = in.nextInt();

        findSubLeastAvg(arr, B);
    }
    public static void findSubLeastAvg(int[] arr, int B) {
        int n = arr.length;
        int sum = 0;
        //find sum of first window
        for(int i = 0; i < B; i++) {
            sum += arr[i];
        }

        int leastAvg = sum;

        int s =1;
        int e=B;
        int index = 0;
        while(e <n){
            sum = sum - arr[s-1]+arr[e];

            if(sum<leastAvg){
                leastAvg = sum;
                index  = s;
            }
            s++;
            e++;
        }
        System.out.println(index);
    }
}
