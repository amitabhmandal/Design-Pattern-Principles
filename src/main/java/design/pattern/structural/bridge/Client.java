package design.pattern.structural.bridge;


public class Client {

	public static void main(String[] args) {
	    
	    FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<Integer>());
	    collection.offer(10);
	    collection.offer(20);
	    collection.offer(30);
	    collection.offer(40);
            
		
	    System.out.println(collection.poll());
	    System.out.println(collection.poll());
	    System.out.println(collection.poll());
	    System.out.println(collection.poll());
            
	}

}
