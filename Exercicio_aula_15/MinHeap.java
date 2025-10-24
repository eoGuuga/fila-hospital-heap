public class MinHeap<T extends Comparable<T>> {

    public int tamanho; 
    private final int capacidade;
    private final T[] heap;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser positiva.");
        }
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.heap = (T[]) new Comparable[capacidade];
    }

    private int getPai(int i) { return (i - 1) / 2; }
    private int getFilhoEsquerda(int i) { return (2 * i) + 1; }
    private int getFilhoDireita(int i) { return (2 * i) + 2; }

    private void checkCheio() {
        if (tamanho == capacidade) {
            throw new IllegalStateException("Heap está cheio.");
        }
    }

    private void checkVazio() {
        if (tamanho == 0) {
            throw new IllegalStateException("Heap está vazio.");
        }
    }

    private void trocar(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        T elemento = heap[i];
        while (i > 0 && elemento.compareTo(heap[getPai(i)]) < 0) {
            heap[i] = heap[getPai(i)];
            i = getPai(i);
        }
        heap[i] = elemento;
    }

    private void heapifyDown(int i) {
        T elemento = heap[i];
        int indiceMenorFilho;

        while (getFilhoEsquerda(i) < tamanho) {
            indiceMenorFilho = getFilhoEsquerda(i);
            
            int filhoDireita = getFilhoDireita(i);
            if (filhoDireita < tamanho && heap[filhoDireita].compareTo(heap[indiceMenorFilho]) < 0) {
                indiceMenorFilho = filhoDireita;
            }

            if (elemento.compareTo(heap[indiceMenorFilho]) <= 0) {
                break;
            }

            heap[i] = heap[indiceMenorFilho];
            i = indiceMenorFilho;
        }
        heap[i] = elemento;
    }

    public void inserir(T elemento) {
        checkCheio();
        System.out.println(" -> Inserindo: " + elemento);
        heap[tamanho] = elemento;
        heapifyUp(tamanho);
        tamanho++;
    }

    public T removerMin() {
        checkVazio();
        T minElemento = heap[0]; 
        System.out.println(" <- Atendendo: " + minElemento);
        
        tamanho--;
        heap[0] = heap[tamanho];
        heap[tamanho] = null; 
        
        if (tamanho > 0) {
            heapifyDown(0);
        }

        return minElemento;
    }
}