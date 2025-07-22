package exemplos;

import estruturas.lineares.*;
import estruturas.nao_lineares.*;

/**
 * Classe demonstrativa do uso das estruturas de dados implementadas
 */
public class ExemplosUso {
    
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DAS ESTRUTURAS DE DADOS ===\n");
        
        demonstrarFila();
        demonstrarPilha();
        demonstrarListaLigada();
        demonstrarDeque();
        demonstrarArvore();
        demonstrarHashTable();
    }
    
    private static void demonstrarFila() {
        System.out.println("📋 FILA (Queue):");
        Fila<String> fila = new Fila<>();
        
        fila.enqueue("Primeiro");
        fila.enqueue("Segundo");
        fila.enqueue("Terceiro");
        
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Primeiro elemento: " + fila.peek());
        System.out.println("Removendo: " + fila.dequeue());
        System.out.println("Novo primeiro: " + fila.peek());
        System.out.println("Tamanho após remoção: " + fila.size());
        System.out.println();
    }
    
    private static void demonstrarPilha() {
        System.out.println("📚 PILHA (Stack):");
        Pilha pilha = new Pilha(10);
        
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        
        System.out.println("Tamanho: " + pilha.size());
        System.out.println("Topo: " + pilha.peek());
        System.out.println("Removendo: " + pilha.pop());
        System.out.println("Novo topo: " + pilha.peek());
        System.out.println();
    }
    
    private static void demonstrarListaLigada() {
        System.out.println("🔗 LISTA LIGADA:");
        ListaLigada lista = new ListaLigada();
        
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);
        
        System.out.print("Lista: ");
        lista.imprimirLista();
        
        lista.remover(2);
        System.out.print("Após remover 2: ");
        lista.imprimirLista();
        System.out.println();
    }
    
    private static void demonstrarDeque() {
        System.out.println("↔️ DEQUE:");
        Deque<Integer> deque = new Deque<>();
        
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);
        
        System.out.println("Tamanho: " + deque.size());
        System.out.println("Primeiro: " + deque.peekFirst());
        System.out.println("Último: " + deque.peekLast());
        System.out.println("Remove primeiro: " + deque.removeFirst());
        System.out.println("Remove último: " + deque.removeLast());
        System.out.println("Tamanho final: " + deque.size());
        System.out.println();
    }
    
    private static void demonstrarArvore() {
        System.out.println("🌳 ÁRVORE BINÁRIA:");
        BinaryTree arvore = new BinaryTree();
        
        int[] valores = {5, 3, 7, 2, 4, 6, 8};
        for (int valor : valores) {
            arvore.insert(valor);
        }
        
        System.out.print("Travessia em ordem: ");
        arvore.inorder();
        System.out.println();
        
        System.out.print("Travessia pré-ordem: ");
        arvore.preorder();
        System.out.println();
        System.out.println();
    }
    
    private static void demonstrarHashTable() {
        System.out.println("#️⃣ TABELA HASH:");
        HashTable tabela = new HashTable(5);
        
        tabela.put("Brasil", 1);
        tabela.put("Argentina", 2);
        tabela.put("Chile", 3);
        tabela.put("Uruguai", 4);
        
        System.out.println("Brasil: " + tabela.get("Brasil"));
        System.out.println("Argentina: " + tabela.get("Argentina"));
        System.out.println("Tamanho: " + tabela.size());
        System.out.println("Contém 'Chile': " + tabela.containsKey("Chile"));
        
        tabela.remove("Chile");
        System.out.println("Após remover Chile, tamanho: " + tabela.size());
        System.out.println();
    }
}
