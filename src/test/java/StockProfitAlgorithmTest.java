import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockProfitAlgorithmTest {

    @Test
    public void simple() {
        int[] p = {1, 10};

        StockProfitAlgorithm.MaxProfitResult maxProfit = StockProfitAlgorithm.findMaxProfit(p);
        assertEquals(9, maxProfit.getMaxProfit());
        assertEquals(1, maxProfit.getBuyPrice());
        assertEquals(0, maxProfit.getBuyTime());
        assertEquals(10, maxProfit.getSellPrice());
        assertEquals(1, maxProfit.getSellTime());
    }

    @Test
    public void simpleNegative() {
        int[] p = {10, 1};

        StockProfitAlgorithm.MaxProfitResult maxProfit = StockProfitAlgorithm.findMaxProfit(p);
        assertEquals(-9, maxProfit.getMaxProfit());
        assertEquals(10, maxProfit.getBuyPrice());
        assertEquals(0, maxProfit.getBuyTime());
        assertEquals(1, maxProfit.getSellPrice());
        assertEquals(1, maxProfit.getSellTime());
    }

    @Test
    public void easy() {
        int[] p = {10, 7, 5, 8, 11, 9};

        StockProfitAlgorithm.MaxProfitResult maxProfit = StockProfitAlgorithm.findMaxProfit(p);
        assertEquals(6, maxProfit.getMaxProfit());
        assertEquals(5, maxProfit.getBuyPrice());
        assertEquals(2, maxProfit.getBuyTime());
        assertEquals(11, maxProfit.getSellPrice());
        assertEquals(4, maxProfit.getSellTime());
    }

    @Test
    public void medium() {
        int[] p = {5, 10, 4, 2, 1, 1};

        StockProfitAlgorithm.MaxProfitResult maxProfit = StockProfitAlgorithm.findMaxProfit(p);
        assertEquals(5, maxProfit.getMaxProfit());
        assertEquals(5, maxProfit.getBuyPrice());
        assertEquals(0, maxProfit.getBuyTime());
        assertEquals(10, maxProfit.getSellPrice());
        assertEquals(1, maxProfit.getSellTime());
    }

    @Test
    public void hard() {
        int[] p = {5, 10, 4, 2, 3, 10, 1, 8};

        StockProfitAlgorithm.MaxProfitResult maxProfit = StockProfitAlgorithm.findMaxProfit(p);
        assertEquals(8, maxProfit.getMaxProfit());
        assertEquals(2, maxProfit.getBuyPrice());
        assertEquals(3, maxProfit.getBuyTime());
        assertEquals(10, maxProfit.getSellPrice());
        assertEquals(5, maxProfit.getSellTime());
    }
}