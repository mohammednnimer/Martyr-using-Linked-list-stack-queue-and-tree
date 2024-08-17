package application;

public class TreeBinarySearch<T extends Comparable<T>> {

	TNode<T> root;

	public TNode<T> getRoot() {
		return root;
	}

	public void setRoot(TNode<T> root) {
		this.root = root;
	}

//	public void traverceInOreder() {
//
//		traverceInOreder(root);
//System.out.println();
//	}
//
//	private void traverceInOreder(TNode<T> root) {
//
//		if (root != null) {
//
//			if (root.getLeft() != null)
//				traverceInOreder(root.getLeft());
//			System.out.print(root.getData() + "-->");
//			if (root.getRigth() != null)
//				traverceInOreder(root.getRigth());
//
//		}
//
//	}
//	
	public Queue<T> traverceInOreder() {
		Queue<T> newn=new Queue<>();
				traverceInOreder(root,newn);
		return newn;
			}

			private void traverceInOreder(TNode<T> root,Queue<T> newn) {

				if (root != null) {

					if (root.getLeft() != null)
						traverceInOreder(root.getLeft(),newn);
					newn.enqueue(root.getData());
					if (root.getRigth() != null)
						traverceInOreder(root.getRigth(),newn);
				}

			}

	public void preTraverc() {

		preTraverc(root);

	}

	public TNode<T> find(T data) {

		return find(data, root);

	}

	private TNode<T> find(T data, TNode<T> node) {
		  if (node != null) {
		        int comp = node.getData().compareTo(data);
		        if (comp == 0)
		            return node;
		        if (comp > 0 && node.hasleft())
		            return find(data, node.getLeft()); 
		        if (comp < 0 && node.hasRight()) 
		            return find(data, node.getRigth()); 
		    }
		   

		return null;

	}

	public TNode<T> getSmallest() {
		return getSmallest(root);

	}

	private TNode<T> getSmallest(TNode<T> root) {

		if (root != null) {

			if (!root.hasleft())
				return root;
			return getSmallest(root.getLeft());

		}
		return null;

	}

	public TNode<T> getLargest() {
		return getLargest(root);

	}

	private TNode<T> getLargest(TNode<T> root) {

		if (root != null) {

			if (!root.hasRight())
				return root;
			return getLargest(root.getRigth());

		}
		return null;

	}

	{

	}

	public int hiegth() {
		return hiegth(root);
	}

	public void insert(T data) {
		if (isEmpty())
			root = new TNode(data);
		else {
			insert(data, root);
		}

	}

	public void insert(T data, TNode<T> node) {

		if (data.compareTo(node.getData()) >= 0) {

			if (!node.hasRight()) {
				node.setRigth(new TNode<>(data));
			} else {
				insert(data, node.getRigth());
			}
		} else {
			if (!node.hasleft()) {
				node.setLeft(new TNode<>(data));
			} else {
				insert(data, node.getLeft());
			}

		}

	}

	public TNode delet(T data) {
		TNode<T> current = root;
		TNode<T> parent = root;
		boolean isleft = false;
		if (isEmpty())
			return null;
		while (current != null && current.getData().compareTo(data)!=0) {

			parent = current;
			
			if (data.compareTo((T)current.getData()) < 0) {
				current = current.getLeft();
				isleft = true;

			} else {
				current = current.getRigth();
				isleft = false;

			}
		}
	
		if (current == null)
			return null;

		if (!current.hasleft() && !current.hasRight()) {

			if (current == root)
				root = null;
			else {

				if (isleft) {
					parent.setLeft(null);

				} else {
					parent.setRigth(null);
				}

			}
		}

		else if (current.hasleft() && !current.hasRight()) {
 
			if (current == root) {
				root = root.getLeft();
			} else if (isleft) {
				parent.setLeft(current.getLeft());
			}

			else {
				parent.setRigth(current.getLeft());
			}
		} else if (current.hasRight() && !current.hasleft()) {

			if (current == root) {
				root = root.getRigth();
			} else if (isleft) {
				parent.setLeft(current.getRigth());
			}

			else {
				parent.setRigth(current.getRigth());
			}

		}

		else {

			TNode<T> successor = getSuccessor(current);
			if (current == root) {

				root = successor;

			} else if (isleft) {
				parent.setLeft(successor);
			} else {

				parent.setRigth(successor);

			}

			successor.setLeft(current.getLeft());

		}

		return current;

	}

	private TNode getSuccessor(TNode node) {

		TNode parentOfSuccessor = node;
		TNode succcessor = node;
		TNode current = node.getRigth();
		while (current != null) {

			parentOfSuccessor = succcessor;
			succcessor = current;
			current = current.getLeft();

		}
		if (succcessor != node.getRigth()) {
			parentOfSuccessor.setLeft(succcessor.getRigth());
			succcessor.setRigth(node.getRigth());

		}
		return succcessor;

	}

	public boolean isEmpty() {
		return root == null;
	}

	private int hiegth(TNode<T> root) {
		if (root == null)
			return 0;
		if (root.isleaf())
			return 1;
		int left = 0, rigth = 0;
		;
		if (root.hasleft())
			left = hiegth(root.getLeft());
		if (root.hasRight())

			rigth = hiegth(root.getRigth());
		return (left > rigth) ? (left + 1) : (rigth + 1);

	}

	private void preTraverc(TNode<T> root) {
		if (root != null) {
			System.out.print(root + " ");

			if (root.getLeft() != null)
				preTraverc(root.getLeft());
			if (root.getRigth() != null)
				preTraverc(root.getRigth());

		}

	}

	public void PostTraverc() {

		PostTraverc(root);

	}
//	public  void levelOrderTraversal( ) {
//		
//		levelOrderTraversal(root);
//		
//		
//	}
//	
//	 private  void levelOrderTraversal(TNode root) {
//	        if (root == null)
//	            return;
//
//	        Queue<TNode<T>> queue = new Queue();
//	        queue.enqueue(root);
//
//	        levelOrderUtil(queue);
//	    }
//
//	    // Recursive helper function to perform level order traversal
//	    private  void levelOrderUtil(Queue queue) {
//	        if (queue.isEmpty())
//	            return;
//
//	        TNode<T> node =(TNode<T>) queue.dequeue();
//	        System.out.print(node.getData() + "-->");
//
//	        if (node.getLeft() != null)
//	            queue.enqueue(node.getLeft());
//	        if (node.getRigth() != null)
//	            queue.enqueue(node.getRigth());
//
//	        levelOrderUtil(queue);
//	        
//	    }
	  public  Queue<T> levelOrderTraversal() {
			 Queue<TNode<T>> queue = new Queue(); 
			 Queue<T> ret = new Queue();
			 if (root == null)
		            return null;
		        queue.enqueue(root);
		        levelOrderUtil(queue,ret);
		        return ret;
		    }
		    private  void levelOrderUtil(Queue<TNode<T>> queue,Queue<T> ret) {
		        if (queue.isEmpty())
		            return;
		        TNode<T> node = queue.dequeue();
		        ret.enqueue(node.getData());
		        if (node.getLeft() != null)
		            queue.enqueue(node.getLeft());
		        if (node.getRigth() != null)
		            queue.enqueue(node.getRigth());
		        levelOrderUtil(queue,ret);   
		    }
	
		    
		    
	 private void PostTraverc(TNode<T> root) {
		if (root != null) {

			if (root.getLeft() != null)
				PostTraverc(root.getLeft());

			if (root.getRigth() != null)
				PostTraverc(root.getRigth());
			System.out.print(root.getData() + " ");

		}

	}

}
