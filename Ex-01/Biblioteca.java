import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<LivroFisico> listaLivroFisico;
    private ArrayList<Ebook> listaEbook;
    private ArrayList<AudioBook> listaAudioBook;

    public Biblioteca() {
        this.listaLivroFisico = new ArrayList<>();
        this.listaEbook = new ArrayList<>();
        this.listaAudioBook = new ArrayList<>();
    }

    public ArrayList<LivroFisico> getListaLivroFisico() {
        return listaLivroFisico;
    }

    public void setListaLivroFisico(ArrayList<LivroFisico> listaLivroFisico) {
        this.listaLivroFisico = listaLivroFisico;
    }

	public ArrayList<Ebook> getListaEbook() {
        return listaEbook;
    }

    public void setListaEbook(ArrayList<Ebook> listaEbook) {
        this.listaEbook = listaEbook;
    }

    public ArrayList<AudioBook> getListaAudioBook() {
        return listaAudioBook;
    }

    public void setListaAudioBook(ArrayList<AudioBook> listaAudioBook) {
        this.listaAudioBook = listaAudioBook;
    }

}
