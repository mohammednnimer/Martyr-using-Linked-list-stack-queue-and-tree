package application;

public class District implements Cloneable, Comparable<District> {
	
	
	private String name;
	private TreeBinarySearch<Location> location = new TreeBinarySearch<>();

	
	
	
	
	@Override
	public String toString() {
		return name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeBinarySearch<Location> getLocation() {
		return location;

	}

	public void setLocation(TreeBinarySearch<Location> location) {
		this.location = location;
	}

	@Override
	public int compareTo(District o) {
		// TODO Auto-generated method stub
		return this.name.toLowerCase().compareTo(o.name.toLowerCase());
	}

}
