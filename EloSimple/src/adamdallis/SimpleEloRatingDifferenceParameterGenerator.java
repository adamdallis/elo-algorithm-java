package adamdallis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleEloRatingDifferenceParameterGenerator implements DifferenceParameterGenerator{

	private Map<Integer,Double> ratingsTable = new HashMap<>();
	
	public void initialise(){
		populateRatingsMap();
	}

	private void populateRatingsMap() {
		ratingsTable.put(0, 0.5);
		ratingsTable.put(25, 0.53);
		ratingsTable.put(50, 0.57);
		ratingsTable.put(100, 0.64);
		ratingsTable.put(150, 0.70);
		ratingsTable.put(200, 0.76);
		ratingsTable.put(250, 0.81);
		ratingsTable.put(300, 0.85);
		ratingsTable.put(350, 0.89);
		ratingsTable.put(400, 0.92);
		ratingsTable.put(450, 0.94);
		ratingsTable.put(500, 0.96);
		ratingsTable.put(735, 0.99);
	}

	@Override
	public double getWinningProbabilityForPlayer(int difference) {
		validateDifferenceValue(difference);
		Double rating = ratingsTable.get(new Integer(difference));
		if(rating == null){
			rating = getClosestRating(difference);
		}
		return rating;
	}

	private Double getClosestRating(int difference) {
		Double rating = 0d;
		Set<Integer> keySet = ratingsTable.keySet();
		Integer[] ratingValues = new Integer[keySet.size()];
		keySet.toArray(ratingValues);
		Arrays.sort(ratingValues);
		
		for (int i = 0; i < ratingValues.length; i++) {
			if(difference > ratingValues[i] ){
				if(i + 1 < ratingValues.length){
					rating = ratingsTable.get(ratingValues[i + 1]);
				}else{
					rating = 1d;
				}
			}
		}
		return rating;
	}

	private void validateDifferenceValue(int difference) {
		if(difference < 0){
			throw new RatingDifferenceException(); 
		}
	}
}
