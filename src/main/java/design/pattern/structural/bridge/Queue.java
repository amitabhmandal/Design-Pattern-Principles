package design.pattern.structural.bridge;


//A refined abstraction.
public class Queue<T> implements FifoCollection<T>{
	
    //This composition 'list' is what bridge is all about.
    private LinkedList<T> list;
    
    public Queue(LinkedList<T> list) {
        this.list = list;
    }

    @Override
    public void offer(T element) {
        list.addFirst(element);
        
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }
    
    
	
}
