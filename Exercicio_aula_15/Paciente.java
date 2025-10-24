public final class Paciente implements Comparable<Paciente> {

    private final String nome;
    private final int senha; 
    private final int prioridade; 

    public Paciente(String nome, int senha, int prioridade) {
        this.nome = nome;
        this.senha = senha;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo(Paciente outro) {
        if (this.prioridade != outro.prioridade) {
            return Integer.compare(this.prioridade, outro.prioridade);
        }
        return Integer.compare(this.senha, outro.senha);
    }

    @Override
    public String toString() {
        String p;
        switch (prioridade) {
            case 1: p = "ALTA"; break;
            case 2: p = "MÉDIA"; break;
            default: p = "BAIXA"; break;
        }
        return String.format("[Senha: %d | Prioridade: %s | Nome: %s]", senha, p, nome);
    }
}