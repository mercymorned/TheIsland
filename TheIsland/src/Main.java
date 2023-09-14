import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int worldHeight = 15;
	private static int worldWidth = 40;
	private List<Creature> creatures = new ArrayList<>();
	private List<Plant> plants = new ArrayList<>();

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

		drawIsland();
	}

	public void drawIsland() {
		System.out.print('+');
		for (int i = 0; i < worldWidth + 10; i++)
			System.out.print('-');
		System.out.println('+');
		for (int y = 0; y < worldHeight; y++) {
			System.out.print('|');
			for (int x = 0; x < worldWidth + 10; x++) {
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
		for (int i = 0; i < worldWidth + 10; i++)
			System.out.print('-');
		System.out.println('+');
	}

	public static void main(String[] args) {
		new Main();
	}

}
