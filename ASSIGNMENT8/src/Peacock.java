class Peacock extends Bird {
	Peacock(int id, String name, double weight, int age) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.age = age;
	}

	@Override
	public String getSound() {
		return "Scream";
	}

}