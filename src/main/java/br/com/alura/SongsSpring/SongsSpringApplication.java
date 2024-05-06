package br.com.alura.SongsSpring;

import br.com.alura.SongsSpring.principal.Principal;
import br.com.alura.SongsSpring.repository.ArtistaRepository;
import br.com.alura.SongsSpring.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongsSpringApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repository;
	@Autowired
	private MusicaRepository repositorioMusica;

	public static void main(String[] args) {
		SpringApplication.run(SongsSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository,repositorioMusica);
		principal.exibirMenu();
	}
}
