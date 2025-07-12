package dev.bandana;

/*
  Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.

 */

import java.util.Arrays;

public class Leaders {
    public static void main(String[] args) {
        int [] arr = {16, 17, 4, 3, 5, 2};

        int [] result = selectLeaders(arr) ;
        System.out.println("Brute Leaders: ");
        for(int i : result){
            System.out.println(i);
        }

        int [] optResult = selectLeadersOptimized(arr);
        System.out.println("Optimized Leaders: ");
        for(int i : optResult){
            System.out.println(i);
        }

    }

    //Brute force approach
    public static int [] selectLeaders(int [] A){
        int n = A.length;
        int [] B = new int[n];
        int index = 0;
        for(int i=0;i<n;i++){
            boolean isLeader = true;
            for(int j = i+1; j<n; j++){
                if(A[i]<=A[j]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader){
                B[index++]=A[i];
            }

        }
        return Arrays.copyOf(B,index);
    }

    //Optimized approach

    public static  int [] selectLeadersOptimized(int [] A){
        int n = A.length;
        int max =A[n-1];
        int count = 1;

        //Count number of maximum count

        for(int i =n-2; i>=0; i--){
            if(A[i]>max){
                max = A[i];
                count++;
            }
        }

        //select leaders
        int [] leaders = new int[count];
        max =A[n-1];
        leaders[0] = max;
        int index = 1;
        for(int i=n-2; i>=0; i--){
            if(A[i]>max){
                max = A[i];
                leaders[index++] = max;
            }
        }
        return leaders;
    }

}
