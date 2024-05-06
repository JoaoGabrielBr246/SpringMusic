package br.com.alura.SongsSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Genero genero;
    @ManyToOne
    private Artista artista;

    public Musica() {
    }
    public Musica(String nome, Genero genero, Artista artista) {
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero +
                '}';
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }
}
