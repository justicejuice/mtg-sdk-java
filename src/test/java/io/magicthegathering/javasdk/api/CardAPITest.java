package io.magicthegathering.javasdk.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.magicthegathering.javasdk.api.testutil.DateUtil;
import io.magicthegathering.javasdk.filter.Filter;
import io.magicthegathering.javasdk.resource.Card;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import io.magicthegathering.javasdk.resource.Rule;
import org.junit.Test;

public class CardAPITest extends MTGAPITest {



	@Test
	public void testGetCard() {
		Card testCard = new Card();

		testCard.setMultiverseid(1);
		testCard.setName("Ankh of Mishra");
		testCard.setManaCost("{2}");


        assertEquals(testCard, CardAPI.getCard(1));
		assertFalse(testCard.equals(CardAPI.getCard(10)));
	}

    @Test
    public void testRulingsOfCard1() throws ParseException {
        Rule[] resultRules = CardAPI.getCard(1).getRulings();

        Rule rule1 = new Rule();
        Rule rule2 = new Rule();

        rule1.setText("This triggers on any land entering the battlefield. This includes playing a land or putting a land onto the battlefield using a spell or ability.");
        rule1.setDate(DateUtil.fromString("2004-10-04"));

        rule2.setText("It determines the land’s controller at the time the ability resolves. If the land leaves the battlefield before the ability resolves, the land’s last controller before it left is used.");
        rule2.setDate(DateUtil.fromString("2004-10-04"));

        assertEquals(rule1.getText(), resultRules[0].getText());
        assertEquals(rule1.getDate(), resultRules[0].getDate());

        assertEquals(rule2.getText(), resultRules[1].getText());
        assertEquals(rule2.getDate(), resultRules[1].getDate());

    }

	@Test
	public void testBadCardId() throws Exception {
		assertNull(CardAPI.getCard(-1));
	}

	@Test
	public void testGetAll() throws Exception {
		List<Card> testCardList = CardAPI.getAllCards();
		Card testCard = new Card();
		testCard.setMultiverseid(94);
		testCard.setName("Air Elemental");
		testCard.setManaCost("{3}{U}{U}");
		assertEquals(testCardList.get(0), testCard);
	}

	@Test
	public void testDeserializePictureUrl() throws Exception {
		List<Card> testCardList = CardAPI.getAllCards();
		assertEquals("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=94&type=card", testCardList.get(0).getImageUrl());
	}

	@Test
	public void testGetAllCardTypes() throws Exception {
		List<String> types = CardAPI.getAllCardTypes();
		assertTrue(types.contains("Artifact"));
		assertTrue(types.contains("Creature"));
		assertTrue(types.contains("Planeswalker"));
	}

	@Test
	public void testGetAllCardSupertypes() throws Exception {
		List<String> superTypes = CardAPI.getAllCardSupertypes();
		assertTrue(superTypes.contains("Legendary"));
		assertTrue(superTypes.contains("Basic"));
		assertTrue(superTypes.contains("Snow"));
	}

	@Test
	public void testGetAllCardSubtypes() throws Exception {
		List<String> superTypes = CardAPI.getAllCardSubtypes();
		assertTrue(superTypes.contains("Ape"));
		assertTrue(superTypes.contains("Elf"));
		assertTrue(superTypes.contains("Squid"));
	}

	@Test
	public void testCardFilterList(){
		ArrayList<String> filter = new ArrayList<>();
		filter.add("name=Air");

		Card testCard = new Card();
		testCard.setMultiverseid(94);
		testCard.setName("Air Elemental");
		testCard.setManaCost("{3}{U}{U}");
		assertTrue(CardAPI.getAllCards(filter).contains(testCard));
	}

    @Test
    public void testCardFilter() {
        // Arrange.
        Card airElemental = new Card();

        airElemental.setMultiverseid(94);
        airElemental.setName("Air Elemental");
        airElemental.setManaCost("{3}{U}{U}");

        Filter filter = new Filter().withName("Air").end();

        // Act.
        List<Card> cards = CardAPI.getAllCards(filter);

        // Assert.
        assertTrue(cards.contains(airElemental));
    }
}
