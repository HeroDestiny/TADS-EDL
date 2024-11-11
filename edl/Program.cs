using System;

public class NoDuplo<T>
{
    public T Valor { get; set; }
    public NoDuplo<T> Proximo { get; set; }
    public NoDuplo<T> Anterior { get; set; }

    public NoDuplo(T valor)
    {
        Valor = valor;
        Proximo = null;
        Anterior = null;
    }
}

public class Sequencia<T>
{
    private NoDuplo<T> cabeca;
    private NoDuplo<T> cauda;
    private int tamanho;

    public Sequencia()
    {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    public int Tamanho => tamanho;

    public bool EstaVazia() => tamanho == 0;

    public void AdicionarInicio(T valor)
    {
        NoDuplo<T> novoNo = new NoDuplo<T>(valor);

        if (EstaVazia())
        {
            cabeca = novoNo;
            cauda = novoNo;
        }
        else
        {
            novoNo.Proximo = cabeca;
            cabeca.Anterior = novoNo;
            cabeca = novoNo;
        }

        tamanho++;
    }

    public void AdicionarFim(T valor)
    {
        NoDuplo<T> novoNo = new NoDuplo<T>(valor);

        if (EstaVazia())
        {
            cabeca = novoNo;
            cauda = novoNo;
        }
        else
        {
            cauda.Proximo = novoNo;
            novoNo.Anterior = cauda;
            cauda = novoNo;
        }

        tamanho++;
    }

    public T RemoverInicio()
    {
        if (EstaVazia())
            throw new InvalidOperationException("A sequência está vazia.");

        T valor = cabeca.Valor;
        cabeca = cabeca.Proximo;

        if (cabeca != null)
            cabeca.Anterior = null;
        else
            cauda = null;

        tamanho--;
        return valor;
    }

    public T RemoverFim()
    {
        if (EstaVazia())
            throw new InvalidOperationException("A sequência está vazia.");

        T valor = cauda.Valor;
        cauda = cauda.Anterior;

        if (cauda != null)
            cauda.Proximo = null;
        else
            cabeca = null;

        tamanho--;
        return valor;
    }

    public T ObterElemento(int posicao)
    {
        if (posicao < 0 || posicao >= tamanho)
            throw new ArgumentOutOfRangeException(nameof(posicao), "Posição inválida.");

        NoDuplo<T> atual = cabeca;
        for (int i = 0; i < posicao; i++)
        {
            atual = atual.Proximo;
        }
        
        return atual.Valor;
    }

    public void InserirNaPosicao(int posicao, T valor)
    {
        if (posicao < 0 || posicao > tamanho)
            throw new ArgumentOutOfRangeException(nameof(posicao), "Posição inválida.");

        if (posicao == 0)
        {
            AdicionarInicio(valor);
        }
        else if (posicao == tamanho)
        {
            AdicionarFim(valor);
        }
        else
        {
            NoDuplo<T> novoNo = new NoDuplo<T>(valor);
            NoDuplo<T> atual = cabeca;

            for (int i = 0; i < posicao - 1; i++)
            {
                atual = atual.Proximo;
            }

            novoNo.Proximo = atual.Proximo;
            novoNo.Anterior = atual;
            atual.Proximo.Anterior = novoNo;
            atual.Proximo = novoNo;

            tamanho++;
        }
    }

    public T RemoverNaPosicao(int posicao)
    {
        if (posicao < 0 || posicao >= tamanho)
            throw new ArgumentOutOfRangeException(nameof(posicao), "Posição inválida.");

        if (posicao == 0)
        {
            return RemoverInicio();
        }
        else if (posicao == tamanho - 1)
        {
            return RemoverFim();
        }
        else
        {
            NoDuplo<T> atual = cabeca;

            for (int i = 0; i < posicao; i++)
            {
                atual = atual.Proximo;
            }

            T valor = atual.Valor;
            atual.Anterior.Proximo = atual.Proximo;
            atual.Proximo.Anterior = atual.Anterior;

            tamanho--;
            return valor;
        }
    }
}

public class Program
{
    public static void Main()
    {
        Sequencia<int> seq = new Sequencia<int>();
        seq.AdicionarFim(10);
        seq.AdicionarFim(20);
        seq.AdicionarInicio(5);
        seq.InserirNaPosicao(1, 15);

        Console.WriteLine("Elemento na posição 1: " + seq.ObterElemento(1));

        seq.RemoverNaPosicao(1);
        Console.WriteLine("Elemento removido do início: " + seq.RemoverInicio());
    }
}
