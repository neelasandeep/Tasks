package giftitems;

public class GiftItems {
 private String type;
 private String chocalate;
 private int cost;
 private int weight;
 private int chocalateCount;


public GiftItems(String type, String chocalate, int cost, int weight, int chocalateCount) {
	super();
	this.type = type;
	this.chocalate = chocalate;
	this.cost = cost;
	this.weight = weight;
	this.chocalateCount = chocalateCount;
}
public int getChocalateCount() {
	return chocalateCount;
}
public String getType() {
	return type;
}
public String getChocalate() {
	return chocalate;
}
public int getCost() {
	return cost;
}
public int getWeight() {
	return weight;
}
public String toString() {
	return "[ Name="+chocalate+", Cost="+cost+", weight="+weight+", no of chocalates="+chocalateCount+"]";
}

}
