package adamdallis;

public class EloSimple {
	
	private DifferenceParameterGenerator simpleEloRatingDifferenceParameterGenerator = new SimpleEloRatingDifferenceParameterGenerator();

	public double calcRatingDifference(int difference, double result, int kFactor) {
		simpleEloRatingDifferenceParameterGenerator.initialise();
		double winningProbabilityForPlayer = simpleEloRatingDifferenceParameterGenerator.getWinningProbabilityForPlayer(difference);
		return kFactor * ( result - winningProbabilityForPlayer );
	}

}
