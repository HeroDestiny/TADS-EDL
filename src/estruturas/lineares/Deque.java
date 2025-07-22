package estruturas.lineares;

public class Deque<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;
        
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node<T> front;
    private Node<T> rear;
    private int size;
    
    public Deque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    // Adiciona elemento no início
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }
    
    // Adiciona elemento no final
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }
    
    // Remove elemento do início
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        
        T data = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        
        size--;
        return data;
    }
    
    // Remove elemento do final
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        
        T data = rear.data;
        rear = rear.prev;
        
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        
        size--;
        return data;
    }
    
    // Consulta primeiro elemento
    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        return front.data;
    }
    
    // Consulta último elemento
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque está vazio");
        }
        return rear.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}
