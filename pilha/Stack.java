// Classe Stack com duas pilhas
class Stack {
    int top1, top2, cap;
    int a[];

    public Stack(int cap) {
        this.cap = cap;
        top1 = -1;
        top2 = cap;
        a = new int[cap];
    }

    public boolean push1(int x) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            return false;
        }
        a[++top1] = x;
        return true;
    }

    public boolean push2(int x) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            return false;
        }
        a[--top2] = x;
        return true;
    }

    public int pop1() {
        if (top1 == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return a[top1--];
    }

    public int pop2() {
        if (top2 == cap) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return a[top2++];
    }

    public int peek1() {
        if (top1 == -1) {
            System.out.println("Stack 1 está vazia");
            return -1;
        }
        return a[top1];
    }

    public int peek2() {
        if (top2 == cap) {
            System.out.println("Stack 2 está vazia");
            return -1;
        }
        return a[top2];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == cap;
    }

    public class TesteDuasPilhas {
        public static void main(String[] args) {
            Stack stack = new Stack(10);

            // Testando push
            stack.push1(1);
            stack.push1(2);
            stack.push1(3);

            stack.push2(9);
            stack.push2(8);
            stack.push2(7);

            // Testando peek
            System.out.println("Topo da pilha 1: " + stack.peek1()); // Esperado: 3
            System.out.println("Topo da pilha 2: " + stack.peek2()); // Esperado: 7

            // Testando pop
            System.out.println("Removido da pilha 1: " + stack.pop1()); // Esperado: 3
            System.out.println("Removido da pilha 2: " + stack.pop2()); // Esperado: 7

            // Verificando se as pilhas estão vazias
            System.out.println("Pilha 1 está vazia? " + stack.isEmpty1()); // false
            System.out.println("Pilha 2 está vazia? " + stack.isEmpty2()); // false

            // Esvaziando a pilha 1
            stack.pop1();
            stack.pop1();
            System.out.println("Pilha 1 está vazia? " + stack.isEmpty1()); // true

            // Esvaziando a pilha 2
            stack.pop2();
            stack.pop2();
            System.out.println("Pilha 2 está vazia? " + stack.isEmpty2()); // true
        }
    }
}
