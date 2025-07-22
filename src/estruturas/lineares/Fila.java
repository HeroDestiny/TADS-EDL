package estruturas.lineares;

public class Fila<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Início da fila
    private Node<T> tail; // Fim da fila
    private int size;     // Tamanho da fila

    public Fila() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Adiciona um elemento ao final da fila
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    // Remove e retorna o elemento do início da fila
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    // Retorna o elemento do início da fila sem removê-lo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return head.data;
    }

    // Retorna o tamanho da fila
    public int size() {
        return size;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return size == 0;
    }
}
