package lista;

class No {
    int data;
    No proximo;

    public No(int data){
        this.data = data;
        this.proximo = null;
    }
}

public class ListaLigada {
    No head;

    public void adicionar(int data){
        No novoNo = new No(data);

        if (head == null){
            head = novoNo;
            return;
        }

        No atual = head;
        while (atual.proximo != null){
            atual = atual.proximo;
        }

        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        No atual = head;

        while(atual != null){
            System.out.println(atual.data + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public void remover(int data){
        if (head == null){
            return;
        }

        if(head.data == data){
            head = head.proximo;
            return;
        }

        No atual = head;
        while(atual.proximo != null && atual.proximo.data != data){
            atual = atual.proximo;
        }

        if (atual.proximo != null){
            atual.proximo = atual.proximo.proximo;
        }
    }
}
