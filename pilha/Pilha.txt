public class Pilha {
    private int[] elementos;
    private int topo;
    private int capacidade;

    // Construtor
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // Pilha vazia
    }

    // Método para adicionar um elemento (push)
    public void push(int elemento) {
        if (topo == capacidade - 1) {
            System.out.println("Pilha cheia!");
            return;
        }
        topo++;
        elementos[topo] = elemento;
    }

    // Método para remover o elemento do topo (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return -1; // ou lançar exceção
        }
        int elemento = elementos[topo];
        topo--;
        return elemento;
    }

    // Método para consultar o topo da pilha (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Retorna o tamanho atual da pilha
    public int size() {
        return topo + 1;
    }
}
