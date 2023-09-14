import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class maintains the system interface for The Island simulation program.
 * <p>
 * The Island is a program designed to simulate an ecosystem consisting of
 * animals, plants, and geographical features on an island for theoretical
 * biologists.
 * <p>
 * Created for SWEN 502 @ Victoria University Wellington.
 * 
 * @author Ronan Griffin
 *         <a href="mailto:griffirona@myvuw.ac.nz">griffirona@myvuw.ac.nz</a>
 * @version 1.0
 * @since 2023-14-09
 */

public class Main {
	private static int islandHeight = 15;
	private static int islandWidth = 50;
	private List<Creature> creatures = new ArrayList<>();
	private List<Plant> plants = new ArrayList<>();

	/**
	 * Creates a single new island of standard width and height for simulation,
	 * populated with creatures and plants. Displays that island visually in the
	 * console, with objects displayed at their assigned x and y coordinates. The
	 * island can be updated a specified number of turns, and after those turns have
	 * passed the island will be draw again with new object positions for those
	 * objects that are capable of movement.
	 */
	public Main() {

		// add some rabbits on start
		Creature r1 = new Creature();
		creatures.add(r1);
		Creature r2 = new Creature();
		creatures.add(r2);
		Creature r3 = new Creature();
		creatures.add(r3);
		Creature r4 = new Creature();
		creatures.add(r4);
		Creature r5 = new Creature();
		creatures.add(r5);
		Creature r6 = new Creature();
		creatures.add(r6);

		// add plants on start
		Plant pw1 = new Plant();
		plants.add(pw1);
		Plant pw2 = new Plant();
		plants.add(pw2);
		Plant pw3 = new Plant();
		plants.add(pw3);
		Plant pw4 = new Plant();
		plants.add(pw4);
		Plant pw5 = new Plant();
		plants.add(pw5);
		Plant pw6 = new Plant();
		plants.add(pw6);

		// drawing initial island
		drawIsland();

		// updating island for 10 turns
		updateIsland();
		updateIsland();
		updateIsland();
		updateIsland();
		updateIsland();
		updateIsland();
		updateIsland();
		updateIsland();
		updateIsland();

		// drawing new island after 10 moves
		drawIsland();
	}

	/**
	 * This method reads the object data from lists of creatures and plants, then
	 * displays those objects visually in the console.
	 * 
	 * @param islandWidth  This is the width of the island in pixels, as displayed
	 *                     in the console. The width has been set to a standard size
	 *                     used for all islands created with this program.
	 * @param islandHeight This is the height of the island in pixels, as displayed
	 *                     in the console. The width has been set to a standard size
	 *                     for all islands created by this program.
	 * @param x            This is the x coordinate where the object will be drawn.
	 * @param y            This is the y coordinate where the object will be drawn.
	 */
	public void drawIsland() {
		System.out.print('+');
		for (int i = 0; i < islandWidth; i++)
			System.out.print('-');
		System.out.println('+');
		for (int y = 0; y < islandHeight; y++) {
			System.out.print('|');
			for (int x = 0; x < islandWidth; x++) {
				int i;
				for (i = 0; i < plants.size(); i++) {
					Plant p = plants.get(i);
					if (p.getX() == x && p.getY() == y) {
						System.out.print(p.getPlantSymbol());
						break;
					}
				}

				for (i = 0; i < creatures.size(); i++) {
					Creature c = creatures.get(i);
					if (c.getX() == x && c.getY() == y) {
						System.out.print(c.getSymbol());
						break;
					}
				}

				if (i == creatures.size())
					System.out.print(' ');
			}
			System.out.println('|');
		}
		System.out.print('+');
		for (int i = 0; i < islandWidth; i++)
			System.out.print('-');
		System.out.println('+');
	}

	/**
	 * This method tells the island to progress to the next turn, by moving
	 * creatures around the island.
	 */
	public void updateIsland() {
		for (Creature c : creatures)
			c.moveCreature();
	}

	/**
	 * The main method tells the program to initialize and run an island simulator
	 * program. If there should be more than one island, additional islands may be
	 * initalized here.
	 */
	public static void main(String[] args) {
		new Main();
	}

}
