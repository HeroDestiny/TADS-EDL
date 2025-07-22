# TADS - Estruturas de Dados em Java 📚

Este repositório contém implementações de estruturas de dados fundamentais em Java, organizadas de forma didática para estudos de Tipo Abstrato de Dados (TADS).

## 🗂️ Estrutura do Projeto

```
src/
├── estruturas/
│   ├── lineares/           # Estruturas lineares
│   │   ├── Fila.java              # Fila (Queue) com lista ligada
│   │   ├── FilaPrioridade.java    # Fila de prioridade (Min-Heap)
│   │   ├── Pilha.java             # Pilha (Stack) com array
│   │   ├── DuasPilhas.java        # Duas pilhas em um array
│   │   ├── ListaLigada.java       # Lista simplesmente ligada
│   │   ├── ListaDuplamenteEncadeada.java  # Lista duplamente ligada
│   │   └── Deque.java             # Deque (Double-ended queue)
│   └── nao_lineares/       # Estruturas não-lineares
│       ├── BinaryTree.java        # Árvore binária de busca
│       └── HashTable.java         # Tabela hash com encadeamento
└── exemplos/
    └── ExemplosUso.java           # Demonstração de uso de todas as estruturas
```

## 📋 Estruturas Implementadas

### Estruturas Lineares

#### 🔄 Fila (Queue)
- **Arquivo**: `Fila.java`
- **Tipo**: Genérica (`Fila<T>`)
- **Implementação**: Lista ligada
- **Operações**: `enqueue()`, `dequeue()`, `peek()`, `isEmpty()`, `size()`

#### ⚡ Fila de Prioridade
- **Arquivo**: `FilaPrioridade.java`
- **Implementação**: Min-Heap
- **Operações**: `insert()`, `removeMin()`, `min()`, `isEmpty()`, `size()`

#### 📚 Pilha (Stack)
- **Arquivo**: `Pilha.java`
- **Implementação**: Array
- **Operações**: `push()`, `pop()`, `peek()`, `isEmpty()`, `size()`

#### 🔄 Duas Pilhas
- **Arquivo**: `DuasPilhas.java`
- **Implementação**: Duas pilhas em um único array
- **Operações**: `push1()`, `push2()`, `pop1()`, `pop2()`, `peek1()`, `peek2()`

#### 🔗 Lista Ligada
- **Arquivo**: `ListaLigada.java`
- **Implementação**: Lista simplesmente ligada
- **Operações**: `adicionar()`, `remover()`, `imprimirLista()`

#### ↔️ Lista Duplamente Encadeada
- **Arquivo**: `ListaDuplamenteEncadeada.java`
- **Implementação**: Lista com nó sentinela
- **Operações**: `inserirInicio()`, `inserirFim()`, `removerInicio()`, `displayForward()`

#### 🔄 Deque
- **Arquivo**: `Deque.java`
- **Tipo**: Genérico (`Deque<T>`)
- **Implementação**: Lista duplamente ligada
- **Operações**: `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`, `peekFirst()`, `peekLast()`

### Estruturas Não-Lineares

#### 🌳 Árvore Binária de Busca
- **Arquivo**: `BinaryTree.java`
- **Operações**: `insert()`, `inorder()`, `preorder()`, `postorder()`
- **Inclui**: Exemplo de uso com diferentes tipos de travessia

#### #️⃣ Tabela Hash
- **Arquivo**: `HashTable.java`
- **Implementação**: Encadeamento para resolução de colisões
- **Operações**: `put()`, `get()`, `remove()`, `containsKey()`, `display()`

## 🚀 Como Usar

### Usando o Script de Build (Recomendado)
```bash
# Executar o script de compilação e execução
./build.sh
```

### Compilação Manual
```bash
# Navegar até o diretório src
cd src

# Compilar todas as classes
javac estruturas/lineares/*.java
javac estruturas/nao_lineares/*.java
javac exemplos/ExemplosUso.java
```

### Execução de Exemplos
```bash
# Executar demonstração completa
java exemplos.ExemplosUso

# Ou executar exemplos individuais:
java estruturas.lineares.FilaPrioridade
java estruturas.lineares.DuasPilhas
java estruturas.nao_lineares.BinaryTree
java estruturas.nao_lineares.HashTable
```

## 📖 Conceitos Abordados

### Estruturas Lineares
- **FIFO** (First In, First Out) - Filas
- **LIFO** (Last In, First Out) - Pilhas
- **Listas Encadeadas** - Organização sequencial com ponteiros
- **Deque** - Inserção e remoção em ambas as extremidades

### Estruturas Não-Lineares
- **Árvores Binárias de Busca** - Organização hierárquica
- **Tabelas Hash** - Acesso direto por chave com função hash

## 🎯 Complexidades

| Estrutura | Inserção | Remoção | Busca | Espaço |
|-----------|----------|---------|-------|---------|
| Fila      | O(1)     | O(1)    | O(n)  | O(n)    |
| Pilha     | O(1)     | O(1)    | O(n)  | O(n)    |
| Lista Ligada | O(1)* | O(n)    | O(n)  | O(n)    |
| Árvore Binária | O(log n)** | O(log n)** | O(log n)** | O(n) |
| Tabela Hash | O(1)*** | O(1)*** | O(1)*** | O(n) |

*Inserção no início  
**Caso médio (árvore balanceada)  
***Caso médio (sem muitas colisões)

## 🤝 Contribuição

Este é um projeto educativo. Sugestões de melhorias são bem-vindas!

## 📄 Licença

Projeto desenvolvido para fins educativos - TADS (Tipos Abstratos de Dados).

---

**Estruturas de Dados** • **Java** • **Algoritmos** • **TADS**
