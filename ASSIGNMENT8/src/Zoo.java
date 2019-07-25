import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Vinod
 *
 *class Zoo contains methods to add zone ,add cage ,add animal
 */
public class Zoo {
	
	static int id = 0;
	static ArrayList<Zone> ZoneArea = new ArrayList<Zone>();  //store zones
	static ArrayList<Cage> CageArea = new ArrayList<Cage>();   // stores cages
	static ArrayList<Animal> AnimalArea = new ArrayList<Animal>();   //stores animal details

	
	public static void main(String[] args) {

		int exit = 0;
		Scanner sc = new Scanner(System.in);

		while (exit != -1) {
			System.out.println("1-�dd Zone");

			System.out.println("2-Add Cage");

			System.out.println("3-Add Animal");

			System.out.println("4-Remove Animal");
			System.out.println("5-Show Animal");
			System.out.println("6-Exit");
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1: {
				if (ZoneArea.size() < 2) {
					System.out.println(ZoneArea.size());
					System.out.println("Enter Catergory of Zone");
					sc.nextLine();
					String Category = sc.nextLine();
					System.out.println("Enter Cage Capacity of Zone");
					int cageCapacity = sc.nextInt();
					System.out.println("is zone has park");
					boolean park = sc.nextBoolean();
					System.out.println("is zone has canteen");
					boolean canteen = sc.nextBoolean();
					System.out.println("is zone has washroom");
					boolean washroom = sc.nextBoolean();
					switch (Category) {
					case "Mammal": {
						Zone Z1 = addZone("Mammal", cageCapacity, park, canteen, washroom);
						ZoneArea.add(Z1);
						break;
					}

					case "Reptile": {
						Zone Z1 = addZone("Reptile", cageCapacity, park, canteen, washroom);
						ZoneArea.add(Z1);
						break;
					}

					case "Bird": {
						Zone Z1 = addZone("Bird", cageCapacity, park, canteen, washroom);
						ZoneArea.add(Z1);
						break;
					}

					}
				} else {
					System.out.println("Zone Full");
				}
				break;
			}

			case 2: {
				if (ZoneArea.size() == 0) {
					System.out.println("Please Create Zone");
				} else {
					System.out.println("Enter Type of Cage");
					sc.nextLine();
					String cageType = sc.nextLine();
					System.out.println("Enter Animal Capacity of cage");
					int animalCapacity = sc.nextInt();
					if ("Lion".equals(cageType)) {
						String zoneType = Lion.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType);

					} else if ("Crocodile".equals(cageType)) {
						String zoneType = Crocodile.class.getSuperclass()
								.getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType);

					} else if ("Peacock".equals(cageType)) {
						String zoneType = Peacock.class.getSuperclass()
								.getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType);

					} else {
						System.out.println("We dont't Have Your Choise");
					}

				}
				break;

			}

			case 3:
				if (ZoneArea.size() == 0) {
					System.out.println("Please Create Zone");
				} else if (CageArea.size() == 0) {
					System.out.println("Please Create Cage");
				} else {
					System.out.println("Enter Type of Animal");
					sc.nextLine();
					String animalType = sc.nextLine();
					System.out.println("Enter NAme of Animal");
					String animalName = sc.nextLine();
					int count = 0;
					for (int i = 0; i < CageArea.size(); i++) {
						Cage CageObj = CageArea.get(i);
						
						if (animalType.equals(CageObj.cageType)) {
							if (CageObj.Aniamlcapacity > 0) {
								CageObj.Aniamlcapacity = CageObj.Aniamlcapacity - 1;
								Animal A1 = addAnimal(id++, animalName,
										animalType);
								AnimalArea.add(A1);
							} else {
								System.out.println("Capacity full");
							}
						}
						count++;
					}
					if(count == CageArea.size()){
						System.out.println("Create "+animalType+" Cage \n");
					}
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter Name of Animal");
				String animalName = sc.nextLine();
				for (int i = 0; i < AnimalArea.size(); i++) {
					Animal A1 = AnimalArea.get(i);
					if (animalName.equals(A1.name)) {
						AnimalArea.remove(i);
					}
				}
				break;

			case 5:
				sc.nextLine();
				System.out.println("Enter NAme of Animal");
				String animalName1 = sc.nextLine();
				for (int i = 0; i < AnimalArea.size(); i++) {
					Animal A1 = AnimalArea.get(i);
					if (animalName1.equals(A1.name)) {
						System.out.println("\nName of Animal->" + A1.name);
						System.out.println("\nId of Animal->" + A1.id);
						System.out.println("\nSound Of Animal->" + A1.getSound());
					} else {
						System.out.println("Animal Not Found");
					}
				}
				break;
			case 6:
				System.out.println("Thanks For Visiting");
				System.exit(0);

			}
		}
	}

	private static void insertIntoTheCage(String zoneType, int animalCapacity,
			String cageType) {
		for (int i = 0; i < ZoneArea.size(); i++) {
			Zone ZoneAreaObj = ZoneArea.get(i);
			if (zoneType.equals(ZoneAreaObj.category)) {
				if (ZoneAreaObj.cageCapity > 0) {
					ZoneAreaObj.cageCapity = ZoneAreaObj.cageCapity - 1;
					Cage c1 = addCage(cageType, animalCapacity);
					CageArea.add(c1);

				} else {
					System.out.println("Cage Size Full");
				}
				break;
			}
		}

	}

	/**
	 * @param zoneType
	 * @param Cagecapacity
	 * @param park
	 * @param canteen
	 * @param washroom
	 * @return
	 */
	public static Zone addZone(String zoneType, int Cagecapacity, boolean park, boolean canteen, boolean washroom) {

		return new Zone(zoneType, Cagecapacity, park, canteen, washroom);
	}

	/**
	 * @param CageType
	 * @param Acapacity
	 * @return
	 */
	public static Cage addCage(String CageType, int Acapacity) {

		return new Cage(CageType, Acapacity);

	}

	/**
	 * @param Id
	 * @param Name
	 * @param Type
	 * @return
	 */
	public static Animal addAnimal(int Id, String Name, String Type) {
		if ("Lion".equals(Type)) {

			return new Lion(Id, Name);
		} else if ("Crocodile".equals(Type)) {
			return new Crocodile(Id, Name);
		} else if ("Peacock".equals(Type)) {
			return new Peacock(Id, Name);
		} else {

			System.out.println("No Animal Found");
			return null;
		}
	}

}
