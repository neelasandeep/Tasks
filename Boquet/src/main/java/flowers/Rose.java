package flowers;

public class Rose {
	private int cost=10;
	public int roseCostCalculation(int flowerCount) {
		 return new Calculation().calculateCostOfFlowers(flowerCount, getCost());
	}
	public int getCost() {
		return cost;
	}
	
}
