package factoryPattern;

public class ID extends Product{
	private String owner;
	
	public ID(String owner){
		this.owner = owner;
	}
	@Override
	public void use() {
		System.out.println("Use: " + owner);
	}
	
	public String getOwner(){
		return owner;
	}
	
	

}
