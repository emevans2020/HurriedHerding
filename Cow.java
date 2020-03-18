public class Cow implements Comparable<Cow> {
	String ID;
	int lowestWeight;
	int latestWeight;
	int numOfMilkings; // how many times the cow has been milked
	int allMilkings; // the total amount of milk produced by the cow

	public Cow(String ID) {
		this.ID = ID;
		this.latestWeight = 0;
		this.lowestWeight = 0;
		this.allMilkings = 0;
		this.numOfMilkings = 0;
	}

	public void getLowestWeight(int w) {
		if (w <= this.lowestWeight || this.lowestWeight == 0) {
			this.lowestWeight = w;
		}
		this.latestWeight = w;
	}

	public void updateMilk(int m) {
		this.allMilkings += m;
		this.numOfMilkings ++;
	}

	public int avgMilkProduction() {
		if (numOfMilkings == 0) {
			return 0;
		} else {
			return (allMilkings / numOfMilkings);
		}
	}

	@Override
	public int compareTo(Cow oc) {
		if (this.lowestWeight > oc.lowestWeight) {
			return 1;
		} else if (this.lowestWeight < oc.lowestWeight) {
			return -1;
		} else if (this.latestWeight > oc.latestWeight) {
			return 1;
		} else if (this.latestWeight < oc.latestWeight) {
			return -1;
		} else if (this.avgMilkProduction() > oc.avgMilkProduction()) {
			return 1;
		} else if (this.avgMilkProduction() < oc.avgMilkProduction()) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return ID + " " + lowestWeight + " " + latestWeight + " " + this.avgMilkProduction();
	}

	// there are no parameters because giving back hashcode of objects have now
	// hashCode is cheap
	// easiest way to remove duplications is to create a hashCode
	@Override
	public int hashCode() {
		return ID.hashCode();
		// every object has a hashCode - we are not computing hashCodes
	}

	@Override
	public boolean equals(Object otherCow) {
		return this.ID.equals(((Cow) otherCow).ID);
	}
}