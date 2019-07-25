class Crocodile extends Reptile {
	Crocodile(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getSound() {

		return "Hiss";
	}

}