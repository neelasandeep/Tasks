package flowers;

public class Lilly {
	private int cost=20;
	public int lillyCostCalculation(int flowerCount) {
		 return new Calculation().calculateCostOfFlowers(flowerCount, getCost());
	}
	public int getCost() {
		return cost;
	}
}
