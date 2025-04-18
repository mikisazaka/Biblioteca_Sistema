public class AudioBookEx03 extends LivrosEx03 {
    private int duracaoDoAudio;
    private String nomeNarrador;

    public AudioBookEx03(String codigoUnico, String titulo, String autor, int duracaoDoAudio, String nomeNarrador) {
        super(codigoUnico, titulo, autor);
        this.duracaoDoAudio = duracaoDoAudio;
        this.nomeNarrador = nomeNarrador;
    }

    @Override
    public String exibirInfo() {
        return "[AUDIOBOOK]" + super.exibirInfo() + 
               String.format("Duração do áudio (min): %d\nNome do narrador: %s\n", 
                            duracaoDoAudio, nomeNarrador);
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
