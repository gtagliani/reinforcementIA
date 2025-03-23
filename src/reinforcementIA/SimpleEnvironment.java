package reinforcementIA;
import java.util.Random;

public class SimpleEnvironment implements EnvironmentI  {

    private static final Random random = new Random();

    private final double probabilityPerAction[];
    public SimpleEnvironment(double probabilityPerAction[]) {
    	this.probabilityPerAction = probabilityPerAction;
    }
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
    
    @Override
	public int interact(int a) {
    	try {
    		return interact(a,probabilityPerAction[a]);
    	} catch (Exception e) {
    		return 0;
    	}
    }

    
}
