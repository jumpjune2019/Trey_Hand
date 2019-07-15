
enum Light {
	GREEN("Green"), YELLOW("Yellow"), RED("Red");
	private String color;
	
	Light(String s) {
		color = s;
	}
	String getLight() {
		return color;
	}
}
