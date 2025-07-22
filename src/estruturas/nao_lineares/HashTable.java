package estruturas.nao_lineares;

public class HashTable {
    private static class Entry {
        String key;
        int value;
        Entry next;
        
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Entry[] table;
    private int capacity;
    private int size;
    
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }
    
    public HashTable() {
        this(16); // Capacidade padrão
    }
    
    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }
    
    public void put(String key, int value) {
        int index = hash(key);
        Entry entry = table[index];
        
        // Verifica se a chave já existe
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value; // Atualiza valor existente
                return;
            }
            entry = entry.next;
        }
        
        // Adiciona nova entrada no início da lista encadeada
        Entry newEntry = new Entry(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
    }
    
    public Integer get(String key) {
        int index = hash(key);
        Entry entry = table[index];
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        
        return null; // Chave não encontrada
    }
    
    public boolean remove(String key) {
        int index = hash(key);
        Entry entry = table[index];
        Entry prev = null;
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return true;
            }
            prev = entry;
            entry = entry.next;
        }
        
        return false; // Chave não encontrada
    }
    
    public boolean containsKey(String key) {
        return get(key) != null;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry entry = table[i];
            while (entry != null) {
                System.out.print("(" + entry.key + ", " + entry.value + ") ");
                entry = entry.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        
        hashTable.put("nome", 1);
        hashTable.put("idade", 25);
        hashTable.put("cidade", 2);
        
        System.out.println("Valor para 'nome': " + hashTable.get("nome"));
        System.out.println("Valor para 'idade': " + hashTable.get("idade"));
        
        hashTable.display();
        
        hashTable.remove("idade");
        System.out.println("\nApós remover 'idade':");
        hashTable.display();
    }
}
