import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main<T> {
    private ArrayList<T> deque;

    public Main() {
        this.deque = new ArrayList<>();
    }

    public void inserirInicio(T element) {
        deque.add(0, element);
    }
    
    public void inserirFim(T element) {
        deque.add(element);
    }
    
    public T removerInicio() {
        if (estaVazia()) {
            throw new NoSuchElementException("Deque vazio!");
        }
        return deque.remove(0);
    }
    
    public T removerFim() {
        if (estaVazia()) {
            throw new NoSuchElementException("Deque vazio!");
        }
        return deque.remove(deque.size() - 1);
    }
    
    public T primeiro() {
        if (estaVazia()) {
            return null;
        }
        return deque.get(0);
    }
    
    public T ultimo() {
        if (estaVazia()) {
            return null;
        }
        return deque.get(deque.size() - 1);
    }

    public boolean estaVazia() {
        return deque.isEmpty();
    }
    
    public int tamanho() {
        return deque.size();
    }
    

    @Override
    public String toString() {
        return deque.toString(); // para debugar
    }
    public static void main(String[] args) {
        Main<Integer> deque = new Main<>();
        
        
        deque.inserirInicio(1);
        deque.inserirFim(2);
        deque.inserirInicio(0);
        System.out.println("Deque: " + deque); 

        System.out.println("Primeiro: " + deque.primeiro());
        System.out.println("Último: " + deque.ultimo());

        deque.removerInicio();
        System.out.println("remover o primeiro: " + deque);

        deque.removerFim();
        System.out.println("remover o último: " + deque);

        System.out.println("vazio " + deque.estaVazia());
        
    }
}
