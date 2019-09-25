package flowers;

public class Jasmine {
	private int cost=15;
	public int jasmineCostCalculation(int flowerCount) {
		 return new Calculation().calculateCostOfFlowers(flowerCount, getCost());
	}
	public int getCost() {
		return cost;
	}
}
