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
			System.out.println("1-Ädd Zone");

			System.out.println("2-Add Cage");

			System.out.println("3-Add Animal");

			System.out.println("4-Remove Animal");
			System.out.println("5-Show Animal");
			System.out.println("6-Exit");
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1: {
				if (ZoneArea.size() < 2) {
					System.out.println("You can add 3 types of Zones\nMammal\nReptile\nBird");
					System.out.println("Numbers of zones currently available = "+ZoneArea.size());
					for(int i = 0; i < ZoneArea.size(); i++){
						System.out.println((i + 1)+" "+ZoneArea.get(i));
					}
					System.out.println("Enter Catergory of Zone");
					sc.nextLine();
					String Category = sc.nextLine();
					System.out.println("Enter Cage Capacity of Zone");
					int cageCapacity = sc.nextInt();
					System.out.println("is zone has park(true or false)");
					boolean park = sc.nextBoolean();
					System.out.println("is zone has canteen(true or false)");
					boolean canteen = sc.nextBoolean();
					System.out.println("is zone has washroom(true or false)");
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
					System.out.println("You can add these types of Cages \nLion\nCrocodile\nPeacock\n");
					System.out.println("Numbers of cages currently available = "+CageArea.size());
					for(int i = 0; i < CageArea.size(); i++){
						System.out.println((i + 1)+" "+CageArea.get(i));
					}
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
				if(ZoneArea.size() == 0){
		    		System.out.println("Please Create Zone");
		    	}
		    	else if(CageArea.size() == 0){
		    		System.out.println("Please Create Cage");
		    	}
		    	else{
		    		System.out.println("Enter Type of Animal");
		    		sc.nextLine();
			    	String animalType =sc.nextLine();
			    	System.out.println("Enter NAme of Animal");
			    	String animalName =sc.nextLine();
			    	System.out.println("Enter Weight of Animal");
					double animalWeight = sc.nextDouble();
					System.out.println("Enter Age of Animal");
					int animalAge = sc.nextInt();
			    	for (int i = 0; i < CageArea.size(); i++) {
						Cage CageObj = CageArea.get(i);
						if(animalType.equals(CageObj.cageType)){
							if(CageObj.Aniamlcapacity >0){
								CageObj.Aniamlcapacity = CageObj.Aniamlcapacity-1;
								Animal A1 = addAnimal(++id,animalName,animalType, animalWeight, animalAge);
								AnimalArea.add(A1);
							}else{
								System.out.println("Capacity full");
							}
						}
						else{
							System.out.println("Enter "+animalType+" type of cage");
						}
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
						System.out.println("\nWeight of Animal->" + A1.weight);
						System.out.println("\nAge Of Animal->" + A1.age);
						System.out.println();
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
	public static Animal addAnimal(int Id, String Name, String Type, double weight, int age) {
		if ("Lion".equals(Type)) {
			return new Lion(Id, Name, weight, age);
		} else if ("Crocodile".equals(Type)) {
			return new Crocodile(Id, Name, weight, age);
		} else if ("Peacock".equals(Type)) {
			return new Peacock(Id, Name, weight, age);
		} else {

			System.out.println("No Animal Found");
			return null;
		}
	}

}
