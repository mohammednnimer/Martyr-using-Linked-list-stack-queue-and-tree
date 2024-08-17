package application;

import java.time.LocalDate;

public class Location_Scene {
    private TreeBinarySearch<Location> location = new TreeBinarySearch<>();
	private Queue<Location> queue = new Queue<>();
	private Stack_Linked_list<Location> stack = new Stack_Linked_list<>();
    private Date_Record date;
    private Location negativ;
	public Location getNegativ() {
		return negativ;
	}
	public void setNegativ(Location negativ) {
		this.negativ = negativ;
	}
	
	
	public Date_Record getDate() {
		return date;
	}
	public void setDate(Date_Record date) {
		this.date = date;
	}
	public TreeBinarySearch<Location> getLocation() {
		return location;
	}
	public void setLocation(TNode<Location> location) {
		this.location.root = location;
	}
	
	public void fromto() {
		while (!queue.getfront().getNameofLocation().equals(negativ.getNameofLocation())) {
			stack.push(queue.dequeue());
		}	
	}
	public  Location next() {

		if (queue.getfront() == null) {
			return null;
		}

		Location ddd = (Location) queue.dequeue();

		if (queue.getfront() == null) {
			queue.enqueue(ddd);
			return null;
		}

		stack.push(ddd);
		Location dd = (Location) queue.getfront();
		return dd;

	}
	public Location prev() {

		Location dd = (Location) stack.peek();
		if (dd == null) {
			return null;
		}
		insertAtBottom(queue, (Location) stack.pop());
		return dd;
}
	

	public static void insertAtBottom(Queue<Location> queue, Location data) {

		if (queue.isEmpty()) {
			queue.enqueue(data);
		} else {

			int size = queue.size();
			Location[] temp = new Location[size];
			for (int i = 0; i < size; i++) {
				temp[i] = (Location) queue.dequeue();
			}

			queue.enqueue(data);

			for (int i = 0; i < size; i++) {
				queue.enqueue(temp[i]);
			}
		}

	}
	
	public void addLocation(String n) {

		Location d1 = new Location();
		d1.setNameofLocation(n);
          if(location.root==null)
          {
        	  location.insert(d1);
          negativ=location.root.getData();
          }
		
		location.insert(d1);
		
	}
	public Location deletLocation(String n) {
		Location d1 = new Location();
		d1.setNameofLocation(n);
		return (Location) location.delet(d1).getData();
	}
	public void abload() {
		if(location.getRoot()!=null)
		{
			queue=location.levelOrderTraversal();
		}
		
	}
	
	public String old()
	{if(negativ.get_martyr_date().root==null)
		return "";
	
	
	TNode<Date_Record> dd=negativ.get_martyr_date().root;
	while (dd.hasleft()) {
		dd=dd.getLeft();
	}
	return dd.getData().getDate()+"";
	
	}
	
	public String max()
	{
		if(negativ.get_martyr_date().root==null)
			return "";
        negativ.get_martyr_date().traverceInOreder();
		return max(negativ.get_martyr_date().root);		
	}
	
	private String max(TNode<Date_Record> t1) {
		Date_Record l1=t1.getData();
	return	max(t1,l1);
	}
	
	
	private String max(TNode<Date_Record> root,Date_Record d1) {
		
		if (root != null) {
			if (root.getLeft() != null)
				return max(root.getLeft(),d1);
			
			if(d1.getMartyr().length()<root.getData().getMartyr().length()) {
				d1=root.getData();
			}
			if (root.getRigth() != null)
				return max(root.getRigth(),d1);
		}
		return d1.getDate()+"";

	
	}

	public String young()
	{
		if(negativ.get_martyr_date().root==null)
			return "";
		
		
		TNode<Date_Record> dd=negativ.get_martyr_date().root;
		while (dd.hasRight()) {
			dd=dd.getRigth();
		}
		return dd.getData().getDate()+"";
	}
	
	
//	 private  void levelOrderTraversal(TNode root) {
//	        if (root == null)
//	            return;
//
//	        Queue<TNode<Location>> queue = new Queue();
//	        queue.enqueue(root);
//
//	        levelOrderUtil(queue);
//	    }
//
//	    
//	    private  void levelOrderUtil(Queue queue) {
//	    	
//	    	if (queue.isEmpty())
//	            return;
//	    	
//	        TNode<Location> node =(TNode<Location>) queue.dequeue();
//	        this.queue.enqueue(node.getData());
//	        if (node.getLeft() != null)
//	            queue.enqueue(node.getLeft());
//	        if (node.getRigth() != null)
//	            queue.enqueue(node.getRigth());
//	        levelOrderUtil(queue);
//	    }
//	
	
	
	public boolean ubdate(String old, String newn) {
		Location d1 = new Location();
		location.traverceInOreder();
		d1.setNameofLocation(old);
		if (location.find(d1) == null) {
			System.out.println("sorry");
			return false;
		}
		Location d2 = location.find(d1).getData();
		location.delet(d1);
		d2.setNameofLocation(newn);
		location.insert(d2);
		System.out.println(newn);
		location.traverceInOreder();
		return true;
	}
	public Queue<Location> getQueue() {
		return queue;
	}
	public void setQueue(Queue<Location> queue) {
		this.queue = queue;
	}
	public Stack_Linked_list<Location> getStack() {
		return stack;
	}
	public void setStack(Stack_Linked_list<Location> stack) {
		this.stack = stack;
	}	
	










}
