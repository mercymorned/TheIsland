import java.util.Random;

/**
 * The Creature class defines what a creature is and its behavior within The
 * Island program.
 */

public class Creature {
	private String species;
	private String symbol;
	private int hunger;
	private int thirst;
	private int x;
	private int y;

	/**
	 * Main constructor method that contains necessary information about a creature
	 * within The Island simulation.
	 * 
	 * @param species the type of creature
	 * @param symbol  the symbol that will be printed in the console to signify that
	 *                creature, based on the creature's species. The symbol field is
	 *                not included in the constructor method, as it is automatically
	 *                generated based on the creature's species.
	 * @param hunger  the creature's hunger level on a scale of 0 (not hungry) to 20
	 *                (starving). A creature whose hunger level reaches 20 will die
	 *                of hunger and be removed from the island.
	 * @param thirst  the creature's thirst level on a scale from 0 (not thirsty) to
	 *                20 (severe dehydration). A creature whose thirst level reaches
	 *                20 will die of thirst and be removed from the island.
	 * @param x       the x position of the creature on the island
	 * @param y       the y position of the creature on the island
	 */

	/*
	 * Code in this method automatically selects a symbol based on the species
	 * entered by the user when constructing a Creature in the main method, so that
	 * there's no need for the user to look up the right emoji symbol.
	 */
	public Creature(String species, int hunger, int thirst, int x, int y) {
		super();
		this.species = species;
		if (species.equalsIgnoreCase("Rabbit")) {
			symbol = "🐇";
		} else if (species.equalsIgnoreCase("Kiwi")) {
			symbol = "🔑🟤";
		} else {
			symbol = "?";
		}
		this.hunger = hunger;
		this.thirst = thirst;
		this.x = x;
		this.y = y;
	}

	/**
	 * This method constructs a randomized creature, using sub-methods to generate a
	 * random entry based on established parameters for the species, x, y, hunger,
	 * and thirst fields.
	 */
	public Creature() {
		randomSpecies();
		randomX();
		randomY();
		randomHunger();
		randomThirst();
	}

	/**
	 * This method picks a random direction (Up, Down, Left, Right) and moves the
	 * creature one space in that direction on a turn.
	 */
	public void moveCreature() {
		int direction = randomDirection();
		int newX = x;
		int newY = y;
		if (direction == 0) {
			newY--;
		} else if (direction == 1) {
			newX++;
		} else if (direction == 2) {
			newY++;
		} else if (direction == 3) {
			newX--;
		}
		if (withinBounds(newX, newY)) {
			x = newX;
			y = newY;
		}
	}

	/**
	 * This method increases a creature's hunger level on a turn.
	 */
	public void updateHunger() {
		int newHunger = hunger + 1;
		hunger = newHunger;
	}

	/**
	 * This method increases a creature's thirst level on a turn.
	 */
	public void updateThirst() {
		int newThirst = thirst + 1;
		thirst = newThirst;
	}

	private boolean withinBounds(int newX, int newY) {
		return newX > 0 && newX < 30 && newY > 0 && newY < 10;
	}

	private int randomDirection() {
		return (int) (Math.random() * 4);
	}

	/**
	 * @return species of this particular Creature
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species name of a Creature type found within The Island to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return symbol that will illustrate this Creature when The Island is drawn in
	 *         the console to set
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the emoji symbol to set to signify this Creature's species
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the creature's current hunger level
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * @param hunger the Creature's level of hunger to set
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	/**
	 * @return the Creature's current thirst level
	 */
	public int getThirst() {
		return thirst;
	}

	/**
	 * @param thirst the Creature's level of thirst to set
	 */
	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	/**
	 * @return the Creature's current x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x coordinate to set the Creature's location on The Island
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the Creature's current y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y coordinate to set the Creature's location on The Island
	 */
	public void setY(int y) {
		this.y = y;
	}

	/*
	 * Species symbols are String instead of char so that you can use emoji as
	 * symbols, but it does throw off the display of the island since they take
	 * multiple spaces. I decided it didn't matter so much for this exercise and
	 * wanted to make it fun.
	 */
	private void randomSpecies() {
		String[] speciesList = { "Rabbit", "Kiwi" };
		int speciesIndex = new Random().nextInt(speciesList.length);
		species = speciesList[speciesIndex];
		if (species.equalsIgnoreCase("Rabbit")) {
			symbol = "🐇";
		} else if (species.equalsIgnoreCase("Kiwi")) {
			symbol = "🔑🟤";
		} else {
			symbol = "?";
		}
	}

	// assigns starting x position between 0 and 30
	private void randomX() {
		this.x = (int) (Math.random() * 30);
	}

	// assigns starting y position between 0 and 10
	private void randomY() {
		this.y = (int) (Math.random() * 10);
	}

	// assigns starting hunger level between 0 and 19, with 20 the maximum hunger
	// level possible before the creature dies.
	private void randomHunger() {
		this.hunger = (int) (Math.random() * 19);
	}

	// assigns starting thirst level between 0 and 19, with 20 the maximum thirst
	// level possible before the creature dies.
	private void randomThirst() {
		this.thirst = (int) (Math.random() * 19);
	}

	@Override
	public String toString() {
		return "Creature [ species = " + species + ", symbol = " + symbol + ", x = " + x + ", y = " + y + ", hunger = "
				+ hunger + ", thirst = " + thirst + " ]";
	}

}
