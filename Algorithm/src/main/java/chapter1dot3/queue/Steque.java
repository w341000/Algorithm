package chapter1dot3.queue;
/**
 * 一个以栈为目标的队列,是一种支持push,pop和enqueue操作的数据类型
 */
public class Steque {
	private Node head;//头
	private Node tail;//尾
	
	class Node{
		Object item;
		Node next;
		public Node() {
		}
		public Node(Object item) {
			this.item=item;
		}
	}
	
	public void push(Object item) {
		Node node=new Node(item);
		node.next=head;
		head=node;
		if(tail==null) {//尾巴为空
			tail=node;
		}
	}
	
	public Object pop() {
		if(head==null)//栈中没有元素了
			return null;
		Object item=head.item;
		Node oldHead=head;
		if(head==tail) {//栈中最后一个元素被弹出
			head=null;
			tail=null;
		}else {
			head=head.next;
		}
		oldHead.next=null;
		return item;
	}
	/**
	 * 入队操作,相当于将元素放入了栈底
	 */
	public void enqueue(Object item){
		Node node=new Node(item);
		if(tail==null) {//栈中没有元素
			head=node;
			tail=node;
		}else {
			tail.next=node;
			tail=node;
		}
	}
	
	public static void main(String[] args) {
		Steque sq=new Steque();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		System.out.println(sq.pop());//print 3
		sq.enqueue(4);
		System.out.println(sq.pop());//2
		System.out.println(sq.pop());//1
		System.out.println(sq.pop());//4
		System.out.println(sq.pop());//null
	}

}
