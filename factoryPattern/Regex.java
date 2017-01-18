package factoryPattern;

public class Regex {
	public static void main(String[] args) {
		String s = "123";
		System.out.println(s.matches("(?!1234)(123.*)"));
		
	}
}
