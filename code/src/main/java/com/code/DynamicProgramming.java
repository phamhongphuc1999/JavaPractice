package com.code;

public class DynamicProgramming {
  // problem 121
  static int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int profit = 0;
    int buy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < buy)
        buy = prices[i];
      else
        profit = Math.max(profit, prices[i] - buy);
    }
    return profit;
  }

  // problem 122
  static int maxProfit122(int[] prices) {
    if (prices.length == 0)
      return 0;
    int buy = prices[0];
    int totalProfit = 0;
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < buy) {
        buy = prices[i];
        if (maxProfit > 0) {
          totalProfit += maxProfit;
          maxProfit = 0;
        }
      } else {
        int _profit = prices[i] - buy;
        if (maxProfit > _profit) {
          totalProfit += maxProfit;
          buy = prices[i];
          maxProfit = 0;
        } else
          maxProfit = _profit;
      }
    }
    totalProfit += maxProfit;
    return totalProfit;
  }
}
