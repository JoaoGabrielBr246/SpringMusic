package br.com.alura.SongsSpring.principal;

import br.com.alura.SongsSpring.model.*;
import br.com.alura.SongsSpring.repository.ArtistaRepository;
import br.com.alura.SongsSpring.repository.MusicaRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final Scanner scanner;
    private final ArtistaRepository artistaRepository;
    private final MusicaRepository musicaRepository;

    public Principal(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            exibirOpcoesMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);
    }

    private void exibirOpcoesMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1- Cadastrar novo artista");
        System.out.println("2- Cadastrar nova música");
        System.out.println("3- Listar todas as músicas");
        System.out.println("4- Buscar músicas por artista");
        System.out.println("0- Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarArtista() {
        System.out.println("\n=== CADASTRAR ARTISTA ===");
        System.out.print("Digite o nome do artista: ");
        String nomeArtista = scanner.nextLine();

        System.out.print("Informe o tipo desse artista (SOLO, DUPLA, BANDA): ");
        String tipoArtistaStr = scanner.nextLine();
        TipoArtista tipoArtista = TipoArtista.fromString(tipoArtistaStr);

        Artista artista = new Artista(nomeArtista, tipoArtista);
        artistaRepository.save(artista);
        System.out.println("Artista cadastrado com sucesso!");
    }

    private void cadastrarMusica() {
        System.out.println("\n=== CADASTRAR MÚSICA ===");
        System.out.print("Digite o nome da música: ");
        String nomeMusica = scanner.nextLine();

        System.out.print("Digite o gênero musical: ");
        String generoMusical = scanner.nextLine();
        Genero genero = Genero.fromString(generoMusical);

        System.out.print("Digite o nome do artista da música: ");
        String nomeArtista = scanner.nextLine();
        Artista artista = artistaRepository.findByNome(nomeArtista);

        if (artista != null) {
            Musica musica = new Musica(nomeMusica, genero, artista);
            musicaRepository.save(musica);
            System.out.println("Música cadastrada com sucesso!");
        } else {
            System.out.println("Artista não encontrado. Por favor, cadastre o artista primeiro.");
        }
    }

    private void listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();

        if (musicas != null && !musicas.isEmpty()) {
            musicas.stream()
                    .sorted(Comparator.comparing(Musica::getNome))
                    .forEach(musica -> {
                        String artista = musica.getArtista() != null ? musica.getArtista().getNome() : "Artista desconhecido";
                        System.out.println("Música: " + musica.getNome() + " - Artista: " + artista + " - Gênero: " + musica.getGenero());
                    });
        } else {
            System.out.println("Não há músicas cadastradas.");
        }
    }


    private void buscarMusicaPorArtista() {
        System.out.println("\n=== BUSCAR MÚSICAS POR ARTISTA ===");
        System.out.print("Digite o nome do artista: ");
        String nomeArtista = scanner.nextLine();

        nomeArtista = nomeArtista.toLowerCase();
        List<Musica> musicas = musicaRepository.buscarMusicaPorArtistaIgnoreCase(nomeArtista);

        if (!musicas.isEmpty()) {
            System.out.println("Músicas do artista '" + nomeArtista + "':");
            musicas.forEach(musica -> System.out.println("- " + musica.getNome()));
        } else {
            System.out.println("Nenhuma música encontrada para o artista '" + nomeArtista + "'.");
        }
    }
}
