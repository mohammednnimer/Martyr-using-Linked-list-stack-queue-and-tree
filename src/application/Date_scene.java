package application;

import java.util.ArrayList;

import javafx.scene.control.TableView;

public class Date_scene {
	private Date_Record negativ;
	private TreeBinarySearch<Date_Record> date = new TreeBinarySearch<>();
	private Queue<Date_Record> queue = new Queue<>();
	private Stack_Linked_list<Date_Record> stack = new Stack_Linked_list<>();

	public Date_Record getNegativ() {
		return negativ;
	}

	public void setNegativ(Date_Record negativ) {
		this.negativ = negativ;
	}

	public TreeBinarySearch<Date_Record> getDate() {
		return date;
	}

	public void setDate(TNode<Date_Record> date) {
		this.date.root = date;
	}

	public void fromto() {
		while (queue.getfront().getDate().compareTo(negativ.getDate()) != 0) {
			stack.push(queue.dequeue());
		}
	}

	private void loadtostack(TNode root, Stack_Linked_list date) {

		if (root != null) {
			if (root.getLeft() != null)
				loadtostack(root.getLeft(), date);
			date.push(root.getData());
			if (root.getRigth() != null)
				loadtostack(root.getRigth(), date);

		}

	}

	public Date_Record next() {

		if (queue.getfront() == null) {
			return null;
		}

		Date_Record ddd = (Date_Record) queue.dequeue();

		if (queue.getfront() == null) {
			queue.enqueue(ddd);
			return null;
		}

		stack.push(ddd);
		Date_Record dd = (Date_Record) queue.getfront();

		return dd;

	}

	public Date_Record prev() {

		Date_Record dd = (Date_Record) stack.peek();
		if (dd == null) {
			return null;
		}
		insertAtBottom(queue, (Date_Record) stack.pop());

		return dd;

	}

	public static void insertAtBottom(Queue<Date_Record> queue, Date_Record data) {

		if (queue.isEmpty()) {
			queue.enqueue(data);
		} else {

			int size = queue.size();
			Date_Record[] temp = new Date_Record[size];
			for (int i = 0; i < size; i++) {
				temp[i] = (Date_Record) queue.dequeue();
			}

			queue.enqueue(data);

			for (int i = 0; i < size; i++) {
				queue.enqueue(temp[i]);
			}
		}

	}

	public double avg() {
		Node<Martyr> d1 = negativ.getMartyr().getHead();
		if (d1 == null)
			return 0;
		double sum = 0;
		int count = 0;
		while (d1 != null) {
			System.out.println(d1.getData().toString());
			sum = sum + d1.getData().getAge();
			count++;
			d1 = d1.next;
		}
		return sum / count;
	}

	public void Search(String name, TableView<Martyr> m1) {
		Node<Martyr> head = negativ.getMartyr().getHead();
		negativ.getMartyr().travirce();
		for (; head != null; head = head.next) {
			if (head.getData().getName().toLowerCase().contains(name.toLowerCase())) {
				m1.getItems().add(head.getData());
			}
		}

	}

	public boolean deletmartyr(Martyr m) {
		Node<Martyr> curr = negativ.getMartyr().getHead();
		Node<Martyr> prev = null;
		negativ.getMartyr().travirce();
		if (negativ.getMartyr().getHead() == null) {
			return false;
		}
		for (; curr != null && curr.getData().getName().toLowerCase()
				.compareTo(m.getName().toLowerCase()) != 0; prev = curr, curr = curr.getNext())
			;
		if (curr == null)
			return false;

		if (prev == null) {
			negativ.getMartyr().setHead(curr.getNext());

		}

		else if (curr.getNext() == null) {
			prev.setNext(null);

		}

		else
			prev.setNext(curr.getNext());

		return true;

	}

	public Queue<Date_Record> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Date_Record> queue) {
		this.queue = queue;
	}

	public Stack_Linked_list<Date_Record> getStack() {
		return stack;
	}

	public void setStack(Stack_Linked_list<Date_Record> stack) {
		this.stack = stack;
	}

	public void setDate(TreeBinarySearch<Date_Record> date) {
		this.date = date;
	}

	public String youngest() {
		Node<Martyr> d1 = negativ.getMartyr().getHead();
		if (d1 == null)
			return "";
		Martyr young = d1.getData();

		while (d1 != null) {

			if (d1.data.getAge() < young.getAge())
				young = d1.getData();
			d1 = d1.next;
		}

		return young.toString();

	}

	public void name(TableView<Martyr> mm) {
		Node<Martyr> d1 = negativ.getMartyr().getHead();
		
		linked_List<Martyr> newn = new linked_List<>();

		while (d1 != null) {
			newn.setHead(insertto(newn.getHead(), d1.getData()));
			d1 = d1.next;
		}
		for (Node<Martyr> curr = newn.getHead(); curr != null; curr = curr.next) {
			mm.getItems().add(curr.getData());
		}

	}

	private Node<Martyr> insertto(Node<Martyr> head, Martyr m1) {
		Node<Martyr> newnode = new Node<>(m1);
		Node<Martyr> curr = head;
		Node<Martyr> prev = null;

		if (head == null) {
			return newnode;
		} else {

			while (curr != null && curr.getData().getName().toLowerCase().compareTo(m1.getName().toLowerCase()) < 0) {
				prev = curr;
				curr = curr.next;
			}

			if (prev == null) {
				newnode.next = head;
				return newnode;
			} else {
				prev.next = newnode;
				newnode.next = curr;
			}
		}
		return head;
	}

	public String oldest() {
		Node<Martyr> d1 = negativ.getMartyr().getHead();
		if (d1 == null)
			return "";
		Martyr young = d1.getData();

		while (d1 != null) {

			if (d1.data.getAge() > young.getAge())
				young = d1.getData();
			d1 = d1.next;
		}

		return young.toString();

	}
	public void abload() {

		queue=date.traverceInOreder();
	}
//	private void abload(TNode<Date_Record> root) {
//		if (root != null) {
//			if (root.getLeft() != null)
//				abload(root.getLeft());
//			if (root.getData().getMartyr().getHead() != null)
//				queue.enqueue(root.getData());
//
//			if (root.getRigth() != null)
//
//				abload(root.getRigth());
//
//		}
//
//	}

}
