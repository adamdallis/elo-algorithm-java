package adamdallis;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EloSimpleTest {
	
	@Test
	public void testCalcRatingForADrawBetweenTwoEvenPlayers() {
		EloSimple eloSimple = new EloSimple();
		double newRating = eloSimple.calcRatingDifference(0, 0.5, 40);
		assertThat(newRating, is(equalTo(0.0)));
	}
	
	@Test
	public void testCalcRatingForADrawBetweenTwoUnEvenPlayersAndStrongPlayerLoses() {
		EloSimple eloSimple = new EloSimple();
		double difference = eloSimple.calcRatingDifference(100, 0, 10);
		assertEquals(-6.4, difference,0.1);
	}
	
	@Test
	public void testCalcRatingForADrawBetweenTwoUnEvenPlayersAndTheyDraw() {
		EloSimple eloSimple = new EloSimple();
		double difference = eloSimple.calcRatingDifference(100, 0.5, 10);
		assertEquals(- 1.4, difference,0.1);
	}
}
