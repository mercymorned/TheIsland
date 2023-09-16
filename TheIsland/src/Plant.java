import java.util.Random;

/**
 * The Plant class defines what a plant is and its behavior within The Island
 * program.
 */
public class Plant {
	private String plantSpecies;
	private String plantSymbol;
	private int x;
	private int y;
	private int size;

	/**
	 * Main constructor method that contains necessary information to display a
	 * Plant within The Island simulation.
	 * 
	 * @param plantSpecies the type of plant
	 * @param x            the x position of the plant on the island
	 * @param y            the y position of the plant on the island
	 * @param size         an integer between 1 and 9 signifying the size of the
	 *                     plant. A plant that is eaten will shrink in size.
	 */
	public Plant(String plantSpecies, int x, int y, int size) {
		super();
		this.plantSpecies = plantSpecies;
		if (plantSpecies.equalsIgnoreCase("Grass")) {
			plantSymbol = "🌱";
		} else if (plantSpecies.equalsIgnoreCase("Grain")) {
			plantSymbol = "🌾";
		} else {
			plantSymbol = "?";
		}
		this.x = x;
		this.y = y;
		this.size = size;
	}

	/**
	 * This method constructs a new plant using randomized options for the input
	 * fields.
	 */
	public Plant() {
		randomPlant();
		randomX();
		randomY();
		randomSize();
	}

	private void randomPlant() {
		String[] speciesList = { "Grass", "Grain" };
		int speciesIndex = new Random().nextInt(speciesList.length);
		plantSpecies = speciesList[speciesIndex];
		if (plantSpecies.equalsIgnoreCase("Grass")) {
			plantSymbol = "🌱";
		} else if (plantSpecies.equalsIgnoreCase("Grain")) {
			plantSymbol = "🌾";
		} else {
			plantSymbol = "?";
		}
	}

	// assigns starting x coordinate between 0 and 30
	private void randomX() {
		this.x = (int) (Math.random() * 30);
	}

	// assigns starting size between 1 and 9
	private void randomSize() {
		this.size = (int) (Math.random() * 8 + 1);
	}

	// assigns starting y coordinate between 0 and 15
	private void randomY() {
		this.y = (int) (Math.random() * 15);
	}

	/**
	 * @return the symbol used for this Plant
	 */
	public String getPlantSymbol() {
		return plantSymbol;
	}

	/**
	 * @param plantSymbol the emoji symbol to set to signify this Plant's species
	 */
	public void setPlantSymbol(String plantSymbol) {
		this.plantSymbol = plantSymbol;
	}

	/**
	 * @return the Plant's current x coordinate on The Island
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x coordinate to set the Plant's location on The Island
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the Plant's current y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y coordinate to set the Plant's location on The Island
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the Plant's current size, on a scale from 1 (smallest) to 9 (largest)
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set for this Plant
	 */
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Plant [ symbol = " + plantSymbol + ", x = " + x + ", y = " + y + ", size = " + size + " ]";
	}

}
