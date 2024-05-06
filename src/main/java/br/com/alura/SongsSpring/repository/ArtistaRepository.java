package br.com.alura.SongsSpring.repository;

import br.com.alura.SongsSpring.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM Artista a WHERE a.nome = :nomeArtista")
    Artista findByNome(String nomeArtista);
}
