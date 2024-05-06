package br.com.alura.SongsSpring.repository;

import br.com.alura.SongsSpring.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    @Query("SELECT m FROM Musica m JOIN m.artista a WHERE LOWER(a.nome) = LOWER(?1)")
    List<Musica> buscarMusicaPorArtistaIgnoreCase(String nomeArtista);
}
