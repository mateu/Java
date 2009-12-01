import java.util.HashMap;

class Hashme {

	public static void main(String[] args) {
		HashMap<Integer, String> hash = new HashMap<Integer, String>();

		hash.put(new Integer(0), "East");
		hash.put(new Integer(90), "North");
		hash.put(new Integer(180), "West");
		hash.put(new Integer(270), "South");
		System.out.println("Degree: " + hash.get(0));
		System.out.println("Degree: " + hash.get(270));
	}
}