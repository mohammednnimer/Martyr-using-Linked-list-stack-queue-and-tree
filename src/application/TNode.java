package application;

public class TNode<T extends Comparable<T>> implements Comparable<TNode<T>>{

	private TNode<T> Left;
	private TNode<T> Rigth;
	private T data;
	public TNode<T> getLeft() {
		return Left;
	}
	public void setLeft(TNode<T> left) {
		Left = left;
	}
	public TNode<T> getRigth() {
		return Rigth;
	}
	public void setRigth(TNode<T> rigth) {
		Rigth = rigth;
	}
	public TNode(T data) {
		super();
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TNode(TNode<T> left, TNode<T> rigth, T data) {
		super();
		Left = left;
		Rigth = rigth;
		this.data = data;
	}
	public TNode() {
	}
	
	public boolean isleaf()
	{
		
		return (Rigth==null&&Left==null);
		
	}
	public boolean hasleft()
	{
		
		return Left!=null;
		
	}
	public boolean hasRight()
	{
		
		return Rigth!=null;
		
	}
	@Override
	public String toString() {
		return "TNode [data=" + data + "]";
	}

	
	@Override
	public int compareTo(TNode<T> o) {
		// TODO Auto-generated method stub
		return this.data.compareTo(o.data);
	}
	
	
}

