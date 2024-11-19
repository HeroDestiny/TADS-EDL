package deque;

public interface Deque<T> {

    public void inserirInicio(T objeto);

    public T removerInicio();

    public void inserirFim(T objeto);

    public T removerFim();

    public T primeiro();

    public T ultimo();

    public int tamanho();

    public boolean estaVazia();
}