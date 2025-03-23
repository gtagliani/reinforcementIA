package reinforcementIA;
import java.util.Random;

public class SimpleEnvironment implements EnvironmentI  {

    private static final Random random = new Random();

    /**
     * Simulates the environment.
     *
     * @param a The action taken.
     * @param p The probability of receiving a reward of 1 for the action.
     * @return The reward: 1 with probability p(a), otherwise 0.
     */
    @Override
	public int interact(int a, double p) {
        // Generate a random number between 0 and 1
        double randomValue = random.nextDouble();

        // Return 1 with probability p(a), otherwise 0
        if (randomValue < p) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // Example usage
        int action = 2; // Example action
        double probability = 0.7; // Probability of reward for the action
        EnvironmentI environment = new SimpleEnvironment();

        // Simulate the environment
        int reward = environment.interact(action, probability);

        // Print the result
        System.out.println("Action: " + action);
        System.out.println("Probability: " + probability);
        System.out.println("Reward: " + reward);
    }
}
