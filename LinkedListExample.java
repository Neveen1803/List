

//10, 12, 5, 6, 7, 13
public class LinkedListExample {
	public static void main(String[] args) throws Exception{
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.insertNode("10");
		linkedList.insertNode("12");
		linkedList.insertNode("5");
		linkedList.insertNode("6");
		linkedList.insertNode("7");
		linkedList.insertNode("13");
		System.out.println(linkedList);
		System.out.println(linkedList.deleteNode(1));
		System.out.println(linkedList);
		System.out.println(linkedList.deleteElement("5"));
		System.out.println(linkedList);
	}
	
}
class LinkedList<T>{
	private Node<T> head;
	// 10 -> 12 -> 5 -> 6 -> 7 -> 13
	public void insertNode(T elem) {
		Node<T> node = new Node<T>(elem, null);
		if(head == null) {
			head = node;
			
		}else {
			Node<T> currNode = head;
			while(currNode.nextNode != null) {
				currNode = currNode.nextNode;
			}
			currNode.nextNode = node;
		}
	}
	//delete Node
	public T deleteNode(int index) throws Exception{
		Node<T> currNode = head;
		Node<T> prevNode = null;
		for(int i=0; i< index; i++) {
			if(currNode != null && currNode.nextNode != null) {
				prevNode = currNode;
				currNode = currNode.nextNode;
			
			}else {
				throw new Exception("Linked List is smaller than you expected. ");
			}
		}
		Node<T> nodeToConnect = currNode.nextNode;
		prevNode.nextNode = nodeToConnect;
		currNode.nextNode = null;
		return currNode.data;
	}
	//delete Element
	
	public T deleteElement(T element) throws Exception{
		Node<T> currNode = head;
		Node<T> prevNode = null;
		while(currNode.data!=element) {
			if(currNode != null && currNode.nextNode != null) {
				prevNode = currNode;
				currNode = currNode.nextNode;
			}else {
				throw new Exception("Linked List is smaller than you expected. ");
			}
		}
		Node<T> nodeToConnect = currNode.nextNode;
		prevNode.nextNode = nodeToConnect;
		currNode.nextNode = null;
		return currNode.data;
			}
	
	
	//to String
	public String toString() {
		StringBuffer elements = new StringBuffer();
		Node<T> currNode = head;
		while(currNode.nextNode != null) {
			elements = elements.append(currNode.data).append(", ");
			currNode = currNode.nextNode;
		}
		elements = elements.append(currNode.data);
		return elements.toString();
	}
	

	
}
class Node<T>{
	T data;
	Node<T> nextNode;
	
	Node(T data, Node<T> nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
}