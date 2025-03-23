package test.java;

import org.junit.jupiter.api.Test;

import reinforcementIA.EpsilonGreedy;

class EpsilonGreedyTest {

	@Test
	void test() {
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

