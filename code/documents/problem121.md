# LeetCode Problem 121: Best Time to Buy and Sell Stock

## Problem Description

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

## Solution Explanation

-   The simple problem is exhausting all possible cases, but this solution has average complex is O(n^2)
-   The smarter solution is to use dynamic programming. Considering some observations:
    -   If the following day has lower price than the previous day, we must set buy day as the day (has lower price) and continuous count sell day from the day.
    -   The maximum profit is the max between current profit and the considered profit.
