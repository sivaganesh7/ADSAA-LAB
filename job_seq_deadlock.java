import java.util.*;

class JobSequencing {

    // Function to find the maximum profit job sequence
    static ArrayList<Integer> jobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = id.length;
        // Result array: ans[0] -> Number of jobs, ans[1] -> Maximum Profit
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));

        // Step 1: Store jobs as {profit, deadline} pairs
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }

        // Step 2: Sort jobs in decreasing order of profit
        jobs.sort((a, b) -> b[0] - a[0]);

        // Step 3: Create a result array to track job placement (-1 means empty)
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Step 4: Try placing jobs in the latest available slot
        for (int i = 0; i < n; i++) {
            int latestSlot = Math.min(n, jobs.get(i)[1]) - 1; // Deadline-based slot
            for (int j = latestSlot; j >= 0; j--) {
                if (result[j] == -1) { // If slot is empty, assign job
                    result[j] = i;
                    break;
                }
            }
        }

        // Step 5: Count jobs performed and calculate max profit
        for (int i = 0; i < n; i++) {
            if (result[i] != -1) {
                ans.set(0, ans.get(0) + 1); // Increment job count
                ans.set(1, ans.get(1) + jobs.get(result[i])[0]); // Add profit
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Sample job data: {Job ID, Deadline, Profit}
        int[] id = {1, 2, 3, 4, 5};
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};

        // Find job sequence result
        ArrayList<Integer> ans = jobSequencing(id, deadline, profit);

        // Output: Number of jobs done and maximum profit
        System.out.println("Maximum Jobs Scheduled: " + ans.get(0));
        System.out.println("Maximum Profit: " + ans.get(1));
    }
}
