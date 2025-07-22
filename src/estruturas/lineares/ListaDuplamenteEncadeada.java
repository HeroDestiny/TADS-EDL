package estruturas.lineares;

class NodeDuplo {
    int data;
    NodeDuplo next;
    NodeDuplo prev;

    public NodeDuplo(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class ListaDuplamenteEncadeada {
    private NodeDuplo sentinel;

    public ListaDuplamenteEncadeada() {
        sentinel = new NodeDuplo(0);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void inserirInicio(int data) {
        NodeDuplo newNode = new NodeDuplo(data);
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    public void inserirFim(int data) {
        NodeDuplo newNode = new NodeDuplo(data);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }

    public void displayForward() {
        NodeDuplo current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void removerInicio() {
        if (sentinel.next == sentinel) {
            System.out.println("Lista vazia, não é possível remover.");
            return;
        }
        NodeDuplo noParaRemover = sentinel.next;
        sentinel.next = noParaRemover.next;
        noParaRemover.next.prev = sentinel;
        System.out.println("Removido do início: " + noParaRemover.data);
    }
}
