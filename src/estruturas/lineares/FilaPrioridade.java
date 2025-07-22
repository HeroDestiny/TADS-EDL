package estruturas.lineares;

public class FilaPrioridade {
    private int[] heap;
    private int size;
    
    public FilaPrioridade(int capacidade) {
        heap = new int[capacidade];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int min() {
        if (isEmpty()) {
            throw new RuntimeException("Heap vazio!");
        }
        return heap[0];
    }

    public void insert(int valor) {
        if (size == heap.length) {
            throw new RuntimeException("Heap cheio!");
        }

        heap[size] = valor;
        int i = size;

        while (i > 0 && heap[i] < heap[(i - 1) / 2]) {
            int pai = (i - 1) / 2;
            int temp = heap[i];
            heap[i] = heap[pai];
            heap[pai] = temp;
            i = pai;
        }

        size++;
    }

    public int removeMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap vazio!");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        int i = 0;

        while (true) {
            int menor = i;
            int esquerda = 2 * i + 1;
            int direita = 2 * i + 2;

            if (esquerda < size && heap[esquerda] < heap[menor]) {
                menor = esquerda;
            }

            if (direita < size && heap[direita] < heap[menor]) {
                menor = direita;
            }

            if (menor != i) {
                int temp = heap[i];
                heap[i] = heap[menor];
                heap[menor] = temp;
                i = menor;
            } else {
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade(10);

        fila.insert(4);
        fila.insert(2);
        fila.insert(9);
        fila.insert(1);

        System.out.println("Menor: " + fila.min());          // 1
        System.out.println("Remove menor: " + fila.removeMin()); // 1
        System.out.println("Novo menor: " + fila.min());     // 2
        System.out.println("Tamanho: " + fila.size());       // 3
        System.out.println("Está vazia? " + fila.isEmpty()); // false
    }
}
