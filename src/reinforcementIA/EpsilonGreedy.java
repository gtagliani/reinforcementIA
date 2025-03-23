package reinforcementIA;

import java.util.Random;

public class EpsilonGreedy {

    private static final Random random = new Random();

    // Parameters
    private final double epsilon; // Exploration probability (0 ≤ ε ≤ 1)
    private final int numActions; // Number of possible actions
    public final double[] avgRewards; // Average reward for each action
    public final int[] actionCounts; // Number of times each action has been chosen

    public EpsilonGreedy(double epsilon, int numActions) {
        this.epsilon = epsilon;
        this.numActions = numActions;
        this.avgRewards = new double[numActions]; // Initialize average rewards to 0
        this.actionCounts = new int[numActions]; // Initialize action counts to 0
    }

    /**
     * Chooses an action based on the ε-greedy policy.
     *
     * @return The chosen action.
     */
    public int chooseAction() {
        if (random.nextDouble() < epsilon) {
            // Exploration: choose a random action
            return random.nextInt(numActions);
        } else {
            // Exploitation: choose the action with the highest average reward
            return getBestAction();
        }
    }

    /**
     * Returns the action with the highest average reward.
     *
     * @return The best action.
     */
    public int getBestAction() {
        int bestAction = 0;
        double maxReward = avgRewards[0];

        for (int i = 1; i < numActions; i++) {
            if (avgRewards[i] > maxReward) {
                maxReward = avgRewards[i];
                bestAction = i;
            }
        }

        return bestAction;
    }

    /**
     * Updates the average reward and action count for the chosen action.
     *
     * @param action The chosen action.
     * @param reward The reward received.
     */
    public void update(int action, double reward) {
        // Increment the action count
        actionCounts[action]++;

        // Update the average reward using the incremental formula
        avgRewards[action] += (reward - avgRewards[action]) / actionCounts[action];
    }

    /**
     * Simulates the environment (for demonstration purposes).
     *
     * @param action The action taken.
     * @return The reward for the action.
     */
    public double getReward(int action) {
        // Simulate rewards for each action (e.g., action 0 has a mean reward of 1.0, action 1 has 2.0, etc.)
        double[] trueRewards = {1.0, 2.0, 1.5};
        return trueRewards[action] + random.nextGaussian() * 0.1; // Add some noise
    }

    public static void main(String[] args) {
        // Parameters
        double epsilon = 0.1; // Exploration probability
        int numActions = 3; // Number of possible actions
        int numSteps = 1000; // Number of steps to run the algorithm

        // Initialize the ε-greedy algorithm
        EpsilonGreedy epsilonGreedy = new EpsilonGreedy(epsilon, numActions);

        // Run the algorithm
        for (int step = 1; step <= numSteps; step++) {
            // Choose an action
            int action = epsilonGreedy.chooseAction();

            // Get the reward for the chosen action
            double reward = epsilonGreedy.getReward(action);

            // Update the algorithm with the observed reward
            epsilonGreedy.update(action, reward);

            // Print results periodically
            if (step % 100 == 0) {
                System.out.println("Step " + step + ":");
                System.out.println("  Chosen action: " + action);
                System.out.println("  Reward: " + reward);
                System.out.println("  Average rewards: " + java.util.Arrays.toString(epsilonGreedy.avgRewards));
                System.out.println("  Action counts: " + java.util.Arrays.toString(epsilonGreedy.actionCounts));
                System.out.println();
            }
        }
    }
}