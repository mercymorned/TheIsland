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
	// selected 10 x 30 as standard island size because it displays well
	private static int islandHeight = 10;
	private static int islandWidth = 30;
	private List<Creature> creatures = new ArrayList<>();
	private List<Creature> creatures2 = new ArrayList<>();
	private List<Plant> plants = new ArrayList<>();
	private List<Plant> plants2 = new ArrayList<>();

	/**
	 * Creates a single new island of standard width and height for simulation,
	 * populated with creatures and plants. Displays that island visually in the
	 * console, with objects displayed at their assigned x and y coordinates. The
	 * island can be updated a specified number of turns, and after those turns have
	 * passed the island will be draw again with new object positions for those
	 * objects that are capable of movement.
	 */
	public Main() {

		// add some rabbits on start to first island
		Creature rabbit1 = new Creature("rabbit", 2, 5, 10, 10);
		creatures.add(rabbit1);
		Creature rabbit2 = new Creature("rabbit", 2, 5, 10, 10);
		creatures.add(rabbit2);

		// add randomly generated creatures
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
		System.out.println("The Island simulation initiated. On the first turn, the island is inhabited by "
				+ creatures.size() + " creatures: ");
		for (Creature c : creatures)
			System.out.println(c.toString());
		System.out.println();
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

		// removing creatures who died from hunger
		for (int i = creatures.size() - 1; i >= 0; i--) {
			if (creatures.get(i).getHunger() >= 20) {
				creatures.remove(i);
			}
		}

		// removing creatures who died from thirst
		for (int i = creatures.size() - 1; i >= 0; i--) {
			if (creatures.get(i).getThirst() >= 20) {
				creatures.remove(i);
			}
		}

		// drawing island fresh after 10 moves
		System.out.println("The Island simulation updated. After 10 turns, there are " + creatures.size()
				+ " creatures remaining: ");
		for (Creature c : creatures)
			System.out.println(c.toString());
		System.out.println();
		drawIsland();

		// add some creatures on start to second island
		Creature r21 = new Creature();
		creatures2.add(r21);
		Creature r22 = new Creature();
		creatures2.add(r22);
		Creature r23 = new Creature();
		creatures2.add(r23);
		Creature r24 = new Creature();
		creatures2.add(r24);
		Creature r25 = new Creature();
		creatures2.add(r25);
		Creature r26 = new Creature();
		creatures2.add(r26);

		// add plants on start
		Plant pw21 = new Plant();
		plants2.add(pw21);
		Plant pw22 = new Plant();
		plants2.add(pw22);
		Plant pw23 = new Plant();
		plants2.add(pw23);
		Plant pw24 = new Plant();
		plants2.add(pw24);
		Plant pw25 = new Plant();
		plants2.add(pw25);
		Plant pw26 = new Plant();
		plants2.add(pw26);

		// drawing initial second island
		System.out
				.println("Second The Island simulation initiated. On the first turn, the second island is inhabited by "
						+ creatures2.size() + " creatures:");
		for (Creature c : creatures2)
			System.out.println(c.toString());
		System.out.println();
		drawSecondIsland();

		// updating second island for 10 turns
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();
		updateSecondIsland();

		// drawing second island fresh after 10 moves
		System.out.println("Second The Island simulation updated. After 10 turns, there are " + creatures2.size()
				+ " creatures remaining: ");
		for (Creature c : creatures2)
			System.out.println(c.toString());
		System.out.println();
		drawSecondIsland();
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
	 * This method creates a second island in the simulation alongside the first.
	 * The method reads the object data from different lists of creatures and plants
	 * than the first drawIsland method, then displays those objects visually in the
	 * console.
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
	public void drawSecondIsland() {
		System.out.print('+');
		for (int i = 0; i < islandWidth; i++)
			System.out.print('-');
		System.out.println('+');
		for (int y = 0; y < islandHeight; y++) {
			System.out.print('|');
			for (int x = 0; x < islandWidth; x++) {
				int i;
				for (i = 0; i < plants2.size(); i++) {
					Plant p = plants2.get(i);
					if (p.getX() == x && p.getY() == y) {
						System.out.print(p.getPlantSymbol());
						break;
					}
				}

				for (i = 0; i < creatures2.size(); i++) {
					Creature c = creatures2.get(i);
					if (c.getX() == x && c.getY() == y) {
						System.out.print(c.getSymbol());
						break;
					}
				}

				if (i == creatures2.size())
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
	 * creatures around the island. Each turn increases a creature's thirst and
	 * hunger levels by 1.
	 */
	public void updateIsland() {
		for (Creature c : creatures)
			c.moveCreature();
		for (Creature c : creatures)
			c.updateHunger();
		for (Creature c : creatures)
			c.updateThirst();
	}

	/**
	 * This method tells the second island to progress to the next turn, by moving
	 * creatures around the second island and updating their hunger and thirst levels.
	 */
	public void updateSecondIsland() {
		for (Creature c : creatures2)
			c.moveCreature();
	}

	/**
	 * The main method tells the program to initialize and run an island simulator
	 * program.
	 */
	public static void main(String[] args) {
		new Main();
	}

}
