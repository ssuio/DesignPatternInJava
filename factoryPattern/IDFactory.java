package factoryPattern;

import java.util.ArrayList;

public class IDFactory extends Factory{
	private ArrayList<Product> productList = new ArrayList<>();
	
	@Override
	protected Product createProduct(String owner) {
		ID id = new ID(owner);
		return id;
	}

	@Override
	protected void registerProduct(Product product) {
		productList.add(product);
	}
	
	public ArrayList<Product> getOwners(){
		return productList;
	}
}
