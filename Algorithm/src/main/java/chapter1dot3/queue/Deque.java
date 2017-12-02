package chapter1dot3.queue;

import java.util.Iterator;

/**
 * 一个双向队列,和栈或队列类似,但它同时支持在两端添加或删除元素.
 */
public class Deque<T> implements Iterable<T> {
	private Node left;//最左边的元素
	private Node right;//最右边的元素
	private int size=0;//元素数量,初始为0
	class Node{
		T item;
		Node left;
		Node right;
		public Node(T t) {
			this.item=t;
		}
	}
	class MyIterator implements Iterator<T>{
		Node current=left;

		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public T next() {
			T item=current.item;
			current=current.right;
			return item;
		}
		
	}
	/**
	 * 创建空双向队列
	 */
	public Deque() {}

	@Override
	public Iterator<T> iterator() {
		
		return new MyIterator();
	}
	/**
	 * 双向队列是否为空
	 */
	public boolean isEmpty() {
		return left==null&& right==null;
	}
	/**
	 * 双向队列中的元素数量
	 */
	public int size() {
		return size;
	}
	/**
	 * 向左端添加一个元素
	 */
	public void pushLeft(T t) {
		Node node=new Node(t);
		Node oldLeft=left;
		size++;
		if(isEmpty()) {
			left=node;
			right=node;
			return ;
		}
		left.left=node;
		left=node;
		left.right=oldLeft;
	}
	/**
	 * 向右端添加一个元素
	 */
	public void pushRight(T t) {
		Node node=new Node(t);
		Node oldRight=right;
		size++;
		if(isEmpty()) {
			left=node;
			right=node;
			return ;
		}
		right.right=node;
		right=node;
		right.left=oldRight;
	}
	/**
	 * 从左端删除一个元素
	 */
	public T popLeft() {
		if(isEmpty()) {
			return null;
		}
		T item=left.item;
		if(--size==0) {//删除后队列为空
			left=null;
			right=null;
		}else {
			left=left.right;
			left.left=null;
		}
		return item;
	}
	/**
	 * 从右端删除一个元素
	 */
	public T popRight() {
		if(isEmpty()) {
			return null;
		}
		T item=right.item;
		if(--size==0) {//删除后队列为空
			left=null;
			right=null;
		}else {
			right=right.left;
			right.right=null;
		}
		return item;
	}
	
	public static void main(String[] args) {
		Deque<Integer> dq=new Deque<>();
		dq.pushLeft(1);
		dq.pushLeft(2);//2  1
		dq.pushRight(3);
		dq.pushRight(4);//2  1  3  4
		for (Integer integer : dq) {//默认从左往右遍历,输出2  1  3  4
			System.out.println(integer);
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println(dq.popLeft());//2
		System.out.println(dq.popLeft());//1
		System.out.println(dq.popRight());//4
		System.out.println(dq.popRight());//3
		System.out.println(dq.popRight());//null
		for (Integer integer : dq) {//默认从左往右遍历,此时为空不输出
			System.out.println(integer);
		}
	}
}
