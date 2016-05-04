
public class Cost {
	private int goldCost;
	private int steelCost;
	private int woodCost;
	
	public Cost() {
		this(0, 0, 0);
	}
	
	//a good question is to find out whether constructor should use the class' public setters to init fields????
	public Cost(int gold, int steel, int wood) {
		this.goldCost = gold;
		this.steelCost = steel;
		this.woodCost = wood;
	}
	public int getGoldCost() {
		return goldCost;
	}
	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}
	public int getSteelCost() {
		return steelCost;
	}
	public void setSteelCost(int steelCost) {
		this.steelCost = steelCost;
	}
	public int getWoodCost() {
		return woodCost;
	}
	public void setWoodCost(int woodCost) {
		this.woodCost = woodCost;
	}
	
	
}
