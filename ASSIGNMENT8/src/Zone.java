public class Zone {
	String category;
	int cageCapity;
	int zoneCount;
	boolean park;
	boolean canteen;
	boolean washroom;

	Zone(String category, int cageCapity ,boolean park, boolean canteen, boolean washroom) {
		this.category = category;
		this.cageCapity = cageCapity;
		this.park = park;
		this.canteen = canteen;
		this.washroom = washroom;

	}

	public int getZoneCount() {
		return zoneCount;
	}

}
