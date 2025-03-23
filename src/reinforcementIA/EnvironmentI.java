package reinforcementIA;

public interface EnvironmentI {

	/**
	 * Simulates the environment.
	 *
	 * @param a The action taken.
	 * @param p The probability of receiving a reward of 1 for the action.
	 * @return The reward: 1 with probability p(a), otherwise 0.
	 */
	int interact(int action, double probability);

}