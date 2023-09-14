import java.util.Random;

public class Plant {
	private String plantSymbol;
	private int x;
	private int y;
	private int size;

	public Plant() {
		randomSymbol();
		randomX();
		randomY();
		randomSize();
	}
	
	private void randomSymbol() {
		String[] symbolList = {"'"};
		int symbolIndex = new Random().nextInt(symbolList.length);
		plantSymbol = symbolList[symbolIndex];
	}
	//assigns starting x coordinate between 0 and 40
	private void randomX() {
		this.x = (int) (Math.random() * 40);
	}
	//assigns starting size between 1 and 9
	private void randomSize() {
		this.size = (int) (Math.random() * 8 + 1);
	}
	
	//assigns starting y coordinate between 0 and 15
	private void randomY() {
		this.y = (int) (Math.random() * 15);
	}
	
	public String getPlantSymbol() {
		return plantSymbol;
	}

	public void setPlantSymbol(String plantSymbol) {
		this.plantSymbol = plantSymbol;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Plant [ symbol = " + plantSymbol + ", x = " + x + ", y = " + y + ", size = " + size +" ]";
	}

}
