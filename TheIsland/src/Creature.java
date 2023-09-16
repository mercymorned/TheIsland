import java.util.Random;

/**
 * The Creature class defines what a creature is within The Island program.
 * 
 * @param species the creature's species
 * @param symbol  the symbol that will be printed in the console to signify that
 *                creature, based on the creature's species
 * @param hunger  the creature's hunger level on a scale of 0 (not hungry) to 20
 *                (starving). A creature whose hunger level reaches 20 will die
 *                of hunger and be removed from the island.
 * @param thirst  the creature's thirst level on a scale from 0 (not thirsty) to
 *                20 (severe dehydration). A creature whose thirst level reaches
 *                20 will die of thirst and be removed from the island.
 * @param x the x position of the creature on the island
 * @param y the y position of the creature on the island
 */
public class Creature {
	private String species;
	private String symbol;
	private int hunger;
	private int thirst;
	private int x;
	private int y;

	public Creature() {
		randomSpecies();
		randomX();
		randomY();
		randomHunger();
		randomThirst();
	}

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
		this.symbol = symbol;
		this.symbol = symbol;
		this.hunger = hunger;
		this.thirst = thirst;
		this.x = x;
		this.y = y;
	}

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

	public void updateHunger() {
		int newHunger = hunger + 1;
		hunger = newHunger;
	}

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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		species = this.species;
		if (species.equalsIgnoreCase("Rabbit")) {
			symbol = "🐇";
		} else if (species.equalsIgnoreCase("Kiwi")) {
			symbol = "🔑🟤";
		} else {
			symbol = "?";
		}
		this.symbol = symbol;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

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
