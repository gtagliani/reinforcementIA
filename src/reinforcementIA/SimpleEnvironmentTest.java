package reinforcementIA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleEnvironmentTest {

	@Test
	void test() {
        // Example usage
        int action = 2; // Example action
        double probability = 0.7; // Probability of reward for the action
        double avgReward = 0;
        int events = 100;
        EnvironmentI environment = new SimpleEnvironment();

        for (int n = 1; n < events + 1; n ++) {
        	System.out.println("------------------------------------");
        	
        	// Simulate the environment
        int reward = environment.interact(action, probability);
        avgReward+= (reward - avgReward) / n;
        // Print the result
        System.out.println("Probability: " + probability);
        System.out.println("Reward: " + reward);
        System.out.println("avgReward: " + avgReward);
        System.out.println("n: " + n);
        }
	}

}
