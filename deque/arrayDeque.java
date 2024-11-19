package deque;

public class arrayDeque<T> implements Deque<T> {
    private static class No<T> {
        T elemento;
        No<T> proximo;
        No<T> anterior;

        public No(T elemento) {
            this.elemento = elemento;
        }
    }

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public arrayDeque() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    @Override
    public void inserirInicio(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        tamanho++;
    }

    @Override
    public T removerInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("Deque está vazio.");
        }

        T elementoRemovido = inicio.elemento;

        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }

        tamanho--;
        return elementoRemovido;
    }

    @Override
    public void inserirFim(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = fim = novoNo;
        } else {
            novoNo.anterior = fim;
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    @Override
    public T removerFim() {
        if (estaVazia()) {
            throw new IllegalStateException("Deque está vazio.");
        }

        T elementoRemovido = fim.elemento; // pego o elemento do fim e atribuo a elementoRemovido

        if (tamanho == 1) {
            inicio = fim; //verifico se o tamanho é igual a 1 se for o inicio fica igual ao fim e o antigo fim fica nulo
            fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }

        tamanho--;
        return elementoRemovido;
    }

    @Override
    public T primeiro() {
        if (estaVazia()) {
            throw new IllegalStateException("Deque está vazio.");
        }

        return inicio.elemento;
    }

    @Override
    public T ultimo() {
        if (estaVazia()) {
            throw new IllegalStateException("Deque está vazio.");
        }

        return fim.elemento;
    }
    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

}
