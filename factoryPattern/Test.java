package factoryPattern;

public class Test {
	public static void main(String[] args) {
		IDFactory idF = new IDFactory();
		Product id = idF.create("A");
		
		id.use();
		
		for(Product p : idF.getOwners())
			System.out.println(((ID)p).getOwner());
	}
}
