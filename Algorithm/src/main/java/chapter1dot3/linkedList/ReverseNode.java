package chapter1dot3.linkedList;
/**
 * ��дһ������,����һ�������׽ڵ���Ϊ����,�ƻ��ԵĽ�ԭ����ת
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
