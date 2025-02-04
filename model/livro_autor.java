package model;

public class livro_autor {
    private int id;
    private int idAutor;
    private int idLivro;

    public livro_autor(int id, int idAutor, int idLivro) {
        this.id = id;
        this.idAutor = idAutor;
        this.idLivro = idLivro;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAutor() {
        return this.idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

}
