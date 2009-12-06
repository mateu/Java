class Horse {
	void talk(String s) {
		System.out.println(s);
	}
	void think() {
		System.out.println("I am thinking...");
	}
}

class Unicorn extends Horse {
	void horn() {
		System.out.println("have a horn");
	}
	void talk() {
		String word = "Howdy";
		super.talk(word);
		//System.out.println("Bonjour");
	}
}

class Goat extends Horse {
	
}

class Story {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse a, b;
		a = new Horse();
		b = new Unicorn();
		String texas_talk = "Howdy";
		String indy_talk = "Yo";
		//a.talk(texas_talk);
		b.talk(indy_talk);
		//b.horn();
		
		Unicorn uni = new Unicorn();
		uni.talk("Hey");
		uni.horn();
				
		Goat g;
		// g = new Horse();
	}

}


