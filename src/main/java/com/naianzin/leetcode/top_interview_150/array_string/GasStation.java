package com.naianzin.leetcode.top_interview_150.array_string;

import static java.lang.System.out;

// https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {

    /*
    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to
    its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

    Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the
    circuit once in the clockwise direction, otherwise return -1.
    If there exists a solution, it is guaranteed to be unique
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var count = 0;
        var start = 0;
        int tank = 0;
        int leg;
        int boundary = gas.length;
        for (int i = 0; i < boundary; i++) {
            leg = gas[i] - cost[i];
            count += leg;
            tank += leg;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return count >= 0
                ? start
                : -1;
    }

    public static void main(String[] args) {
        var gasStation = new GasStation();

        out.println(gasStation.canCompleteCircuit(
                new int[] {1,2,3,4,5},
                new int[] {3,4,5,1,2})
                + " expected 3");

        out.println(gasStation.canCompleteCircuit(
                new int[] {2,3,4},
                new int[] {3,4,3})
                + " expected -1");

        out.println(gasStation.canCompleteCircuit(
                new int[] {2},
                new int[] {2})
                + " expected 0");

        out.println(gasStation.canCompleteCircuit(
                new int[] {5, 1, 2, 3, 4},
                new int[] {4, 4, 1, 5, 1})
                + " expected 4");
    }
}
