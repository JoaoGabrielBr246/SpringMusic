package br.com.alura.SongsSpring.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private TipoArtista tipoArtista;

    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas = new ArrayList<>();

    public Artista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public Artista(String nome, TipoArtista tipoArtista) {
        this.nome = nome;
        this.tipoArtista = tipoArtista;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", tipoArtista=" + tipoArtista +
                '}';
    }
}
