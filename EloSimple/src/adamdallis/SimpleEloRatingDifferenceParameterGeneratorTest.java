package adamdallis;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleEloRatingDifferenceParameterGeneratorTest {

	private SimpleEloRatingDifferenceParameterGenerator ratingGenerator;

	@Before
	public void setup(){
		ratingGenerator = new SimpleEloRatingDifferenceParameterGenerator();
		ratingGenerator.initialise();
	}
	
	@Test
	public void testForZeroDifference() {
		double strongRating = ratingGenerator.getWinningProbabilityForPlayer(0);
		assertThat(strongRating, is(equalTo(0.5)));
	}
	
	@Test
	public void testFor25Difference() {
		double strongRating = ratingGenerator.getWinningProbabilityForPlayer(25);
		assertThat(strongRating, is(equalTo(0.53)));
	}
	
	@Test
	public void testForBelow0DifferenceForStrongPlayer() {
		try{
			ratingGenerator.getWinningProbabilityForPlayer(-25);
			fail();
		}catch(RatingDifferenceException e){
			
		}
		
	}
	
	@Test
	public void testForBelow0DifferenceForWeakPlayer() {
		try{
			ratingGenerator.getWinningProbabilityForPlayer(-3);
			fail();
		}catch(RatingDifferenceException e){
			
		}
	}
	
	@Test
	public void testForAValueThatIsNotProvidedInTheStandardsRatingTable() {
		double strongRating = ratingGenerator.getWinningProbabilityForPlayer(26);
		assertThat(strongRating, is(equalTo(0.57)));
	}
	
	@Test
	public void testForAnotherValueThatIsNotProvidedInTheStandardsRatingTable() {
		double strongRating = ratingGenerator.getWinningProbabilityForPlayer(37);
		assertThat(strongRating, is(equalTo((0.57))));
	}
	
	@Test
	public void testForMaxValueThatIsNotProvidedInTheStandardsRatingTable() {
		double strongRating = ratingGenerator.getWinningProbabilityForPlayer(1337);
		assertThat(strongRating, is(equalTo((1.0))));
	}
}
