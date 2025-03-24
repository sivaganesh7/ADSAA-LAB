public class KnapsackSimple {
    // Keeps track of best value found
    private static int bestValue = 0;

    static class Item {
        int w;  // weight
        int v;  // value

        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    // Backtracking function
    private static void knapsack(int maxWeight, Item[] stuff, int pos, 
                               int currW, int currV) {
        // Stop if we've checked all items or gone over weight limit
        if (pos >= stuff.length || currW > maxWeight) {
            // Update bestValue if we haven't gone over weight
            if (currW <= maxWeight) {
                bestValue = Math.max(bestValue, currV);
            }
            return;
        }

        // Choice 1: Skip this item
        knapsack(maxWeight, stuff, pos + 1, currW, currV);

        // Choice 2: Take this item if it fits
        if (currW + stuff[pos].w <= maxWeight) {
            knapsack(maxWeight, stuff, pos + 1,
                    currW + stuff[pos].w,
                    currV + stuff[pos].v);
        }
    }

    public static void main(String[] args) {
        // Sample items: {weight, value}
        Item[] stuff = {
            new Item(2, 10),  // Item 1
            new Item(3, 15),  // Item 2
            new Item(5, 25),  // Item 3
            new Item(7, 35)   // Item 4
        };
        
        int maxWeight = 10;  // Bag size
        
        // Reset and run
        bestValue = 0;
        knapsack(maxWeight, stuff, 0, 0, 0);
        
        System.out.println("Best value: " + bestValue);
    }
}
