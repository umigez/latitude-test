import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Builder;
import lombok.Data;

public class StockProfitAlgorithm {

    /**
     * Finds the maximum profit that can be achieved from 1 purchase and 1 sale, using the prices passed into the
     * function.
     * Operates in O(n) time.
     *
     * @param prices An ordered array of prices. Assume prices are integers. Must contain at least 2 elements
     * @return Object representing the results of the algorithm. null if input has less than 2 elements.
     */
    public static MaxProfitResult findMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return null;
        }

        // We are really just trying to find the max difference between 2 elements, such that the larger
        // element appears after the smaller element.

        // Iterate through the array in order and store the current maxDiff, and the current minValue observed so far.
        // Always compare the maxDiff to (current - minValue). If this is more than the maxDiff, then current is the new sell index.

        // Start assuming buy and sell immediately - we'll see if we can do any better.
        int maxDiff = prices[1] - prices[0];
        int minValue = prices[0];

        // These values are not strictly necessary for the algorithm, but it is nice to report them.
        int minIndex = 0; //just used to figure out the buyIndex
        int buyPrice = prices[0];
        int buyIndex = 0;
        int sellPrice = prices[1];
        int sellIndex = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minValue > maxDiff) {
                maxDiff = prices[i] - minValue;

                buyIndex = minIndex;
                buyPrice = minValue;
                sellPrice = prices[i];
                sellIndex = i;
            }

            if (prices[i] < minValue) {
                minValue = prices[i];
                minIndex = i; // only used so we can set the buyIndex in the next iteration
            }
        }

        return MaxProfitResult.builder()
                .buyPrice(buyPrice)
                .buyTime(buyIndex)
                .sellPrice(sellPrice)
                .sellTime(sellIndex)
                .maxProfit(maxDiff)
                .build();
    }


    @Data
    @Builder
    @Immutable
    public static class MaxProfitResult {
        private final int maxProfit;
        private final int buyPrice;
        private final int buyTime;
        private final int sellPrice;
        private final int sellTime;
    }
}
