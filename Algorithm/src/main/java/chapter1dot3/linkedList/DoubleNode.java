package chapter1dot3.linkedList;

/**
 * ʵ��һ��˫������,ÿ���ڵ㺬��ǰһ������һ���ڵ������,��ʵ�ָ��ַ���
 */
public class DoubleNode {
	Node head;
	Node tail;
	class Node{
		Node next;
		Node previous;
		Object item;
		public Node(Object item) {
			this.item=item;
		}
	}
	public  void insertHead(Object item) {
		Node node=new Node(item);
		Node oldHead=head;
		if(head==null) {//ͷ�ڵ�Ϊ�����ʾ����һ��������
			head=node;
			tail=node;
			return;
		}
		oldHead.previous=node;
		head=node;
		head.next=oldHead;
	}
	public  Object deleteHead() {
		Object item=head.item;
		if(head.next==null) {//ͷû����һ���ڵ�,˵��ͷ�����һ���ڵ�
			tail=null;
			head=null;
			return item;
		}
		head=head.next;
		head.previous=null;
		return item;
	}
	public void insertTail(Object item) {
		Node node=new Node(item);
		Node oldTail=tail;
		if(tail==null) {//β�ڵ�Ϊ�����ʾ����һ��������
			head=node;
			tail=node;
			return;
		}
		oldTail.next=node;
		tail=node;
		tail.previous=oldTail;
	}
	
	public Object deleteTail() {
		Object item=tail.item;
		if(tail.previous==null) {//β�ڵ�û����һ���ڵ�,˵��β�ڵ���Ψһһ���ڵ�
			tail=null;
			head=null;
			return item;
		}
		tail=tail.previous;
		tail.next=null;
		return item;
	}
	public void insertBefore(int index,Object item) {
		Node nodeAfter=indexOf(index);
		Node nodeBefore=nodeAfter.previous;
		Node node=new Node(item);
		
		nodeAfter.previous=node;
		node.next=nodeAfter;
		if(nodeBefore==null) {//˵��nodeAfter��ͷ�ڵ�
			head=node;
			return;
		}
		nodeBefore.next=node;
		node.previous=nodeBefore;
	}
	public void insertAfter(int index,Object item) {
		Node nodeBefore=indexOf(index);
		Node nodeAfter=nodeBefore.next;
		Node node=new Node(item);
		nodeBefore.next=node;
		node.previous=nodeBefore;
		if(nodeAfter==null) {//˵��nodeBefore��β�ڵ�
			tail=node;
			return;
		}
		nodeAfter.previous=node;
		node.next=nodeAfter;
	}
	//ɾ��ָ���������Ľڵ�
	public Object deleteAt(int index) {
		Node node=indexOf(index);
		Object item=node.item;
		Node nodeBefore=node.previous;
		Node nodeAfter=node.next;
		if(nodeBefore==null) //node�ڵ���ͷ�ڵ�
			head=node.next;
		else
			nodeBefore.next=nodeAfter;
		//1  2
		if(nodeAfter==null)//node�ڵ���β�ڵ�
			tail=node.previous;
		else
			nodeAfter.previous=nodeBefore;
		return item;
	}
	/**
	 * ����ָ���������Ľڵ�
	 * @param index ����,��0��ʼ
	 */
	private Node indexOf(int index) {
		int indexAt=-1;
		Node first=head;
		for( 	;first!=null; first=first.next) {
			indexAt++;
			if(indexAt == index) {
				break;
			}
		}
		if(first==null)
			throw new RuntimeException("index out of the list:"+index);
		return first;
	}
	
	public static void main(String[] args) {
		DoubleNode dn=new DoubleNode();
		dn.insertHead(1);
		dn.insertHead(2);
		dn.insertTail(3);
		dn.insertTail(4);
		//2  1  3  4
		dn.insertBefore(1, "5");//2 5 1 3 4
		dn.insertAfter(0, "6");//2 6 5 1 3 4
		
		dn.deleteHead();//6  5  1  3  4
		dn.deleteTail();//6  5  1  3
		dn.deleteAt(0);// 5  1  3
		dn.deleteAt(6);//throw runtime exception
		System.out.println(dn);
	}
}
