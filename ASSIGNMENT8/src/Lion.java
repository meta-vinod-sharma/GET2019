class Lion extends Mammal {
	Lion(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getSound() {
		return "roar";
	}

}