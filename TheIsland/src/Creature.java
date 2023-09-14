import java.util.Random;

public class Creature {
	private String species;
	private String symbol;
	protected int hunger;
	protected int thirst;
	protected int x;
	protected int y;

	public Creature() {
		randomSpecies();
		randomX();
		randomY();
		randomHunger();
		randomThirst();
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
	
	private boolean withinBounds(int newX, int newY) {
		return newX > 0 && newX < 40 && newY > 0 && newY < 15;
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

	private void randomSpecies() {
		String[] speciesList = { "Rabbit" };
		int speciesIndex = new Random().nextInt(speciesList.length);
		species = speciesList[speciesIndex];
		if (species.equalsIgnoreCase("Rabbit")) {
			symbol = "🐇";
		} else {
			symbol = "?";
		}
	}

	// assigns starting x position between 0 and 30
	private void randomX() {
		this.x = (int) (Math.random() * 50);
	}

	// assigns starting y position between 0 and 15
	private void randomY() {
		this.y = (int) (Math.random() * 15);
	}

	// assigns starting hunger level between 0 and 20
	private void randomHunger() {
		this.hunger = (int) (Math.random() * 20);
	}

	// assigns starting thirst level between 0 and 20
	private void randomThirst() {
		this.thirst = (int) (Math.random() * 20);
	}

}
