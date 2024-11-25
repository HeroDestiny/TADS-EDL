class ValueNotFoundException extends RuntimeException {
    public ValueNotFoundException(String mensagem) {
        super(mensagem);
    }
}

class No {
    int valor;
    No proximo;

    public No(int valor, No proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }
}

class ListaBinaria {
    private No ponta;

    public No find(int i) throws ValueNotFoundException {
        return encontrar(ponta, i);
    }

    private No encontrar(No atual, int i){
        if (atual == null){
            throw new ValueNotFoundException("valor não encontrado");
        }
        if (atual.valor == i){
            return atual;
        }
        return encontrar(atual.proximo, i);
    }

    public void add(int valor) {
        ponta = new No(valor, ponta);
    }
}

public class Lista {
    public static void main(String[] args) {
        ListaBinaria list = new ListaBinaria();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);

        try {
            No result = list.find(7); // Valor presente
            System.out.println("Encontrado: " + result.valor);
        } catch (ValueNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            No result = list.find(4); // Valor ausente
            System.out.println("Encontrado: " + result.valor);
        } catch (ValueNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}