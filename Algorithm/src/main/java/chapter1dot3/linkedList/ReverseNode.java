package chapter1dot3.linkedList;
/**
 * 编写一个函数,接受一个链表首节点作为参数,破坏性的将原链表反转
 */
public class ReverseNode {
//1 ->2 -> 3 ->4
//1     2      3
	class Node{
		Object item;
		Node next;
	}
	
	public Node reverse(Node node) {
		Node first=node;
		Node second=null;
		Node reverse=null;
		while(first!=null) {
			second=first.next;
			first.next=reverse;
			reverse=first;
			first=second;
		}
		return reverse;
	}
}
