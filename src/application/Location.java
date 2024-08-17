package application;

public class Location implements Comparable<Location> {

	private String nameofLocation;
	private TreeBinarySearch<Date_Record> martyr_date=new TreeBinarySearch<>();
	public String getNameofLocation() {
		return nameofLocation;
	}
	public void setNameofLocation(String nameofLocation) {
		this.nameofLocation = nameofLocation;
	}
	public TreeBinarySearch<Date_Record> get_martyr_date() {
		return martyr_date;
	}
	public void setMartyr(TreeBinarySearch<Date_Record> martyr) {
		this.martyr_date = martyr;
	}
	@Override
	public String toString() {
		return nameofLocation ;
	}
	@Override
	public int compareTo(Location o) {
		// TODO Auto-generated method stub
		return this.nameofLocation.toLowerCase().compareTo(o.nameofLocation.toLowerCase());
	}
	
	
	
	
	
	
	
	
}
