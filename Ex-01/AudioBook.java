public class AudioBook extends Livros {
    private int duracaoDoAudio;
    private String nomeNarrador;

    public AudioBook(String codigoUnico, String titulo, String autor, int duracaoDoAudio, String nomeNarrador) {
        super(codigoUnico, titulo, autor);
        this.duracaoDoAudio = duracaoDoAudio;
        this.nomeNarrador = nomeNarrador;
    }

    public int getDuracaoDoAudio() {
        return duracaoDoAudio;
    }

    public void setDuracaoDoAudio(int duracaoDoAudio) {
        this.duracaoDoAudio = duracaoDoAudio;
    }

    public String getNomeNarrador() {
        return nomeNarrador;
    }

    public void setNomeNarrador(String nomeNarrador) {
        this.nomeNarrador = nomeNarrador;
    }
}