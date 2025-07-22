package estruturas.nao_lineares;

public class HashTable {
    private static class Entry {
        String key;
        int value;
        Entry next;
        boolean deleted; // Para marcação de exclusão no linear probing
        
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.deleted = false;
        }
    }
    
    private Entry[] table;
    private int capacity;
    private int size;
    private String mode; // "chaining" ou "linear"

    public HashTable(int capacity, String mode) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
        this.mode = mode;
    }

    public HashTable(String mode) {
        this(16, mode);
    }

    public HashTable(int capacity) {
        this(capacity, "chaining");
    }

    public HashTable() {
        this(16, "chaining");
    }
    
    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }
    
    public void insert(String key, int value) {
        if (mode.equals("chaining")) {
            int index = hash(key);
            Entry entry = table[index];
            while (entry != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            Entry newEntry = new Entry(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
            size++;
        } else if (mode.equals("linear")) {
            int index = hash(key);
            int startIndex = index;
            do {
                Entry entry = table[index];
                if (entry == null || entry.deleted) {
                    table[index] = new Entry(key, value);
                    size++;
                    return;
                } else if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                index = (index + 1) % capacity;
            } while (index != startIndex);
            throw new RuntimeException("HashTable está cheia");
        }
    }
    
    public Integer find(String key) {
        if (mode.equals("chaining")) {
            int index = hash(key);
            Entry entry = table[index];
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return null;
        } else if (mode.equals("linear")) {
            int index = hash(key);
            int startIndex = index;
            do {
                Entry entry = table[index];
                if (entry == null) {
                    return null;
                } else if (!entry.deleted && entry.key.equals(key)) {
                    return entry.value;
                }
                index = (index + 1) % capacity;
            } while (index != startIndex);
            return null;
        }
        return null;
    }
    
    public boolean remove(String key) {
        if (mode.equals("chaining")) {
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
            return false;
        } else if (mode.equals("linear")) {
            int index = hash(key);
            int startIndex = index;
            do {
                Entry entry = table[index];
                if (entry == null) {
                    return false;
                } else if (!entry.deleted && entry.key.equals(key)) {
                    entry.deleted = true;
                    size--;
                    return true;
                }
                index = (index + 1) % capacity;
            } while (index != startIndex);
            return false;
        }
        return false;
    }
    
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry entry = table[i];
            if (mode.equals("chaining")) {
                while (entry != null) {
                    System.out.print("(" + entry.key + ", " + entry.value + ") ");
                    entry = entry.next;
                }
            } else if (mode.equals("linear")) {
                if (entry != null && !entry.deleted) {
                    System.out.print("(" + entry.key + ", " + entry.value + ") ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Modo encadeamento:");
        HashTable hashTableChaining = new HashTable(5, "chaining");
        hashTableChaining.insert("nome", 1);
        hashTableChaining.insert("idade", 25);
        hashTableChaining.insert("cidade", 2);
        System.out.println("Valor para 'nome': " + hashTableChaining.find("nome"));
        System.out.println("Valor para 'idade': " + hashTableChaining.find("idade"));
        hashTableChaining.display();
        hashTableChaining.remove("idade");
        System.out.println("\nApós remover 'idade':");
        hashTableChaining.display();

        System.out.println("\nModo linear probing:");
        HashTable hashTableLinear = new HashTable(5, "linear");
        hashTableLinear.insert("nome", 1);
        hashTableLinear.insert("idade", 25);
        hashTableLinear.insert("cidade", 2);
        System.out.println("Valor para 'nome': " + hashTableLinear.find("nome"));
        System.out.println("Valor para 'idade': " + hashTableLinear.find("idade"));
        hashTableLinear.display();
        hashTableLinear.remove("idade");
        System.out.println("\nApós remover 'idade':");
        hashTableLinear.display();
    }
}
