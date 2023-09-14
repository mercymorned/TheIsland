
public class Main {
	private static int worldHeight = 15;
	private static int worldWidth = 40;

	public Main() {
		drawIsland();
	}
	
	public void drawIsland() {
		System.out.print('+');
		for (int i = 0; i < worldWidth; i++)
			System.out.print('-');
		System.out.println('+');
		for (int y = 0; y < worldHeight; y++) {
			System.out.print('|');
//			for (int x = 0; x < worldWidth; x++) {
//				int i;
//				for (i = 0; i < plants.size(); i++) {
//					Plant p = plants.get(i);
//					if (p.getX() == x && p.getY() == y) {
//						System.out.print(p.getPlantSymbol());
//						break;
//					}
//				}
//				for (i = 0; i < obstacles.size(); i++) {
//					Obstacle o = obstacles.get(i);
//					if (o.getX() == x && o.getY() == y) {
//						System.out.print(o.getObstSymbol());
//						break;
//					}
//
//				}
//
//				for (i = 0; i < bugCitizens.size(); i++) {
//					Bug b = bugCitizens.get(i);
//					if (b.getX() == x && b.getY() == y) {
//						System.out.print(b.getSymbol());
//						break;
//					}
//				}
//
//				if (i == bugCitizens.size())
//					System.out.print(' ');
//			}
			System.out.println('|');
		}
		System.out.print('+');
		for (int i = 0; i < worldWidth; i++)
			System.out.print('-');
		System.out.println('+');
	}

	public static void main(String[] args) {
		new Main();
	}

}
