class Peacock extends Bird {
	Peacock(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getSound() {
		return "Scream";
	}

}