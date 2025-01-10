package com.naianzin.leetcode.top_interview_150.array_string;

// https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
public class Candy {

    /*
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.
     */
    public int candy(int[] ratings) {
        var n = ratings.length;
        if (n < 1) {
            return 0;
        }

        var candies = new int[ratings.length];

        // from left
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i]++;
            }
        }

        // from right
        for (int i = n-1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                if (candies[i - 1] <= candies[i]) {
                    candies[i - 1]++;
                }
            }
        }

        int sum = candies.length;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        var candy = new Candy();

//        System.out.println(candy.candy(new int[] {1, 0, 2}) + " expected 5");
//        System.out.println(candy.candy(new int[] {1, 2, 2}) + " expected 4");
//        System.out.println(candy.candy(new int[] {1, 2, 87, 87, 87, 2, 1}) + " expected 13");
        System.out.println(candy.candy(new int[] {1, 3, 2, 2, 1}) + " expected 7");
    }

}
