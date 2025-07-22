# Guia de Referência Rápida - Estruturas de Dados

## 📋 Estruturas Lineares

### 🔄 Fila (Queue) - `Fila<T>`
```java
Fila<String> fila = new Fila<>();
fila.enqueue("elemento");    // Adicionar ao final
String item = fila.dequeue(); // Remover do início
String primeiro = fila.peek(); // Consultar primeiro
boolean vazia = fila.isEmpty();
int tamanho = fila.size();
```

### 📚 Pilha (Stack) - `Pilha`
```java
Pilha pilha = new Pilha(10);
pilha.push(42);           // Adicionar ao topo
int item = pilha.pop();   // Remover do topo
int topo = pilha.peek();  // Consultar topo
boolean vazia = pilha.isEmpty();
int tamanho = pilha.size();
```

### ⚡ Fila de Prioridade - `FilaPrioridade`
```java
FilaPrioridade fila = new FilaPrioridade(10);
fila.insert(5);           // Inserir elemento
int minimo = fila.min();  // Consultar mínimo
int removido = fila.removeMin(); // Remover mínimo
```

### 🔗 Lista Ligada - `ListaLigada`
```java
ListaLigada lista = new ListaLigada();
lista.adicionar(10);      // Adicionar elemento
lista.remover(10);        // Remover elemento
lista.imprimirLista();    // Exibir lista
```

### ↔️ Lista Dupla - `ListaDuplamenteEncadeada`
```java
ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
lista.inserirInicio(1);   // Inserir no início
lista.inserirFim(2);      // Inserir no fim
lista.removerInicio();    // Remover do início
lista.displayForward();   // Exibir lista
```

### 🔄 Deque - `Deque<T>`
```java
Deque<Integer> deque = new Deque<>();
deque.addFirst(1);        // Adicionar no início
deque.addLast(2);         // Adicionar no fim
Integer primeiro = deque.removeFirst(); // Remover do início
Integer ultimo = deque.removeLast();    // Remover do fim
Integer inicio = deque.peekFirst();     // Consultar início
Integer fim = deque.peekLast();         // Consultar fim
```

## 🌳 Estruturas Não-Lineares

### 🌳 Árvore Binária - `BinaryTree`
```java
BinaryTree arvore = new BinaryTree();
arvore.insert(5);         // Inserir elemento
arvore.inorder();         // Travessia em ordem
arvore.preorder();        // Travessia pré-ordem
arvore.postorder();       // Travessia pós-ordem
```

### #️⃣ Tabela Hash - `HashTable`
```java
HashTable tabela = new HashTable(10);
tabela.put("chave", 42);  // Inserir par chave-valor
Integer valor = tabela.get("chave");    // Buscar valor
boolean existe = tabela.containsKey("chave"); // Verificar chave
boolean removido = tabela.remove("chave");    // Remover
tabela.display();         // Exibir tabela
```

## ⚡ Complexidades Resumidas

| Operação | Fila | Pilha | Lista | Árvore BST | Hash Table |
|----------|------|-------|-------|------------|------------|
| Inserção | O(1) | O(1)  | O(1)* | O(log n)** | O(1)***    |
| Remoção  | O(1) | O(1)  | O(n)  | O(log n)** | O(1)***    |
| Busca    | O(n) | O(n)  | O(n)  | O(log n)** | O(1)***    |

*Na cabeça da lista  
**Árvore balanceada (caso médio)  
***Sem muitas colisões (caso médio)

## 🎯 Quando Usar Cada Estrutura?

- **Fila**: FIFO, processamento em ordem, breadth-first search
- **Pilha**: LIFO, avaliação de expressões, depth-first search, chamadas recursivas
- **Lista Ligada**: Inserções/remoções frequentes, tamanho variável
- **Deque**: Necessita inserção/remoção em ambas extremidades
- **Árvore Binária**: Busca eficiente, dados ordenados, range queries
- **Tabela Hash**: Acesso direto por chave, dicionários, caches
