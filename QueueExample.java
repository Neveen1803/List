package QueueExample;
import java.util.Arrays;
//10, 12, 5, 6, 7, 13
class QueueExample {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(12);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue);
		System.out.println(queue.get(0));
	}
}
class Queue<N>{
	
	private N[] myElements;
	private int lengthOfTheQueue;
	private N removedElement;
	public Queue() {
		myElements = (N[])new Object[0];
		this.lengthOfTheQueue = 0;
	}
	public int getLengthOfTheQueue() {
		return this.lengthOfTheQueue;
	}
	
	public void enqueue(N elem) {
		myElements = Arrays.copyOf(myElements, lengthOfTheQueue+1);
		myElements[lengthOfTheQueue] = elem;
		lengthOfTheQueue = lengthOfTheQueue+1;
	}
	
	public N dequeue() 
	{
		
		if(myElements.length > 0) {
			removedElement = myElements[0];
		}
		if(myElements.length > 1) {
			myElements = Arrays.copyOfRange(myElements, 1, lengthOfTheQueue);
			lengthOfTheQueue-=1;
		}
		else if(myElements.length == 1) {
			myElements = (N[])new Object[0];
		}
		return removedElement;
	}
	
	public N get(int index) {
		return myElements[index];
		
	}
	
	public String toString() {
		StringBuffer elements = new StringBuffer();
		for(int i=0;i<myElements.length; i++) {
			elements = elements.append(myElements[i]).append(", ");
		}
		return elements.toString();
	}
}

