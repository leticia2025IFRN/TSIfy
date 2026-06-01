/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.UI.fachada.FachadaFrontend;
import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1071759
 */
public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);
    private FachadaFrontend fachada = new FachadaFrontend();
    private Usuario usuarioLogado = null;

    public void rodar() {

        int op;

        do {
            menuDeLogin();
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    criarNovoUsuario();
                    break;
                case 2:
                    autenticar();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (usuarioLogado == null);

        do {
            menu();
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    criarMusica();
                    break;
                case 2:
                    editarMusica();
                    break;

                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorID();
                    break;
                case 5:
                    removerMusica();
                    break;
                case 6:
                    registrarPlaylist();
                    break;
                case 7:
                    listarMusicasDeUmaPlaylist();
                    break;
                case 8:
                    removerMusicaDaPlaylist();
                    break;
                case 9:
                    editarPlaylist();
                    break;
                case 10:
                    listarPlaylists();
                    break;
                case 11:
                    removerPlaylist();
                    break;
                case 12:
                    adicionarMusicaAPlaylist();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (op != 0);

    }

    private void menu() {
        // Favoritar Musica
        System.out.println("------ Menu de Operacoes ------");
        System.out.println("1 - Criar musica");
        System.out.println("2 - Editar musica");
        System.out.println("3 - Listar musicas");
        System.out.println("4 - Buscar musica");
        System.out.println("5 - Remover musica");
        System.out.println("6 - Criar playlist");
        System.out.println("7 - Listar Musicas de uma playlist");
        System.out.println("8 - Remover uma musica de uma playlist");
        System.out.println("9 - Editar playlist");
        System.out.println("10 - Listar Playlists");
        System.out.println("11 - Remover Playlists");
        System.out.println("12 - Adicionar musica a uma Playlist");
        System.out.println("0 - Sair");
    }

    private void criarMusica() {
        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());

        boolean sucesso = this.fachada.registrarMusica(titulo, compositor, interprete, duracao);

        if (sucesso) {
            System.out.println("Música Criada com sucesso!");
        } else {
            System.out.println("Música já existente!");
        }
    }

    private void editarMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        fachada.listarTodasMusicas();

        System.out.println("Informe qual é o ID da música que você deseja editar: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());

        boolean sucesso = fachada.editarMusica(id, titulo, compositor, interprete, duracao);

        if (sucesso) {
            System.out.println("Musica editada com sucesso.");
        } else {
            System.out.println("Falha ao editar a musica.");
        }

    }

    private void listarMusicas() {
        ArrayList<Musica> listaDeMusicas = fachada.listarTodasMusicas();

        for (int i = 0; i < listaDeMusicas.size(); i++) {
            String musica = "[%d] - %s";
            System.out.println(String.format(musica, i, listaDeMusicas.get(i).getTitulo()));
        }

    }

    private void buscarMusicaPorID() {
        System.out.println("Informe qual é o ID da música que você deseja buscar: ");
        int id = Integer.parseInt(sc.nextLine());
        Musica sucesso = fachada.buscarPorId(id);

        if (sucesso != null) {
            System.out.println("Musica Encontrada." + sucesso.getTitulo() + "-" + sucesso.getCompositor());
        } else {
            System.out.println("Falha ao buscar a musica.");
        }
    }

    private void removerMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        fachada.listarTodasMusicas();

        System.out.println("Informe qual é o ID da música que você deseja remover: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean sucesso = fachada.revomerMusica(id);

        if (sucesso) {
            System.out.println("Musica removida com sucesso.");
        } else {
            System.out.println("Falha ao remover a musica.");
        }
    }

    private void menuDeLogin() {
        // Favoritar Musica
        System.out.println("------ Menu de Operacoes ------");
        System.out.println("1 - Criar novo usuario");
        System.out.println("2 - Autentica");
    }

    private void criarNovoUsuario() {
        // Não estou verificando se tenho mais do que um usuário com o mesmo cpf
        System.out.println("Informe seu nome:");
        String nome = sc.nextLine();
        System.out.println("Informe seu cpf: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();

        boolean sucesso = fachada.registrarUsuario(nome, cpf, senha);

        if (sucesso) {
            System.out.println("Usuário Criado com sucesso!");
        } else {
            System.out.println("Usuário Ja existente!");
        }
    }

    private void autenticar() {
        System.out.println("Informe seu cpf: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();

        usuarioLogado = fachada.autenticar(cpf, senha);

        if (usuarioLogado != null) {
            System.out.println("Usuario Logado");
        } else {
            System.out.println("Falha ao logar");
        }
    }

    private void registrarPlaylist() {
        System.out.println("Informe seu nome da playlist:");
        String nome = sc.nextLine();
        System.out.println("Informe a descrição da playlist: ");
        String descricao = sc.nextLine();

        boolean sucesso = fachada.registrarPlaylist(usuarioLogado, nome, descricao);

        if (sucesso) {
            System.out.println("Playlist Criada com sucesso!");
        } else {
            System.out.println("Playlist Ja existente!");
        }
    }

    private void listarPlaylists() {
        ArrayList<Playlist> listaDePlaylists = fachada.listarPlaylists();
        for (int i = 0; i < listaDePlaylists.size(); i++) {
            String playlist = "[%d] - %s, %s";
            System.out.println(String.format(playlist, i, listaDePlaylists.get(i).getNome(),
                    listaDePlaylists.get(i).getDescricao()));
        }

    }

    private void adicionarMusicaAPlaylist() {
        System.out.println("Essas são suas playlists: ");
        listarPlaylists();

        System.out.println("Informe o id da playlist: ");
        int idPlaylist = sc.nextInt();

        System.out.println("Essas são suas musicas: ");
        listarMusicas();
        System.out.println("Informe o id da musica: ");
        int idMusica = sc.nextInt();

        boolean sucesso = fachada.adicionarMusicaAPlaylist(idPlaylist, idMusica);

        if (sucesso) {
            System.out.println("Musica Adicionada com sucesso!");
        } else {
            System.out.println("Falha ao adicinar a musica!");
        }

    }

    private void removerMusicaDaPlaylist() {
        System.out.println("Essas são suas playlists: ");
        listarPlaylists();

        System.out.println("Informe o id da playlist: ");
        int idDaPlaylist = sc.nextInt();

        System.out.println("Essas são suas musicas: ");
        listarMusicas();
        System.out.println("Informe o id da musica que deseja remover: ");
        int idMusica = sc.nextInt();

        boolean sucesso = fachada.removerMusicaDaPlaylist(idDaPlaylist, idMusica);

        if (sucesso) {
            System.out.println("Musica Removida com sucesso!");
        } else {
            System.out.println("Falha ao Remover a musica!");
        }
    }

    private void listarMusicasDeUmaPlaylist() {
        System.out.println("Essas são suas playlists: ");
        listarPlaylists();

        System.out.println("Informe o id da playlist que deseja exibir as musicas: ");
        int idDaPlaylist = sc.nextInt();

        ArrayList<Musica> listaDeMusicasDaPlaylist = fachada.listarMusicasDeUmaPlaylist(idDaPlaylist);

        if (listaDeMusicasDaPlaylist != null) {
            for (int i = 0; i < listaDeMusicasDaPlaylist.size(); i++) {
                String musica = "[%d] - %s";
                System.out.println(String.format(musica, i, listaDeMusicasDaPlaylist.get(i).getTitulo()));
            }
        } else {
            System.out.println("Falha ao listar musicas da playlist");
        }

    }

    private void removerPlaylist() {
        System.out.println("Essas são suas playlists: ");
        listarPlaylists();

        System.out.println("Informe o id da playlist que deseja remover: ");
        int idDaPlaylist = sc.nextInt();

        boolean sucesso = fachada.removerPlaylist(idDaPlaylist);

        if (sucesso) {
            System.out.println("playlist removida com sucesso!");
        } else {
            System.out.println("Falha ao remover laylist");
        }
    }

    private void editarPlaylist() {
        System.out.println("Essas são suas playlists: ");
        listarPlaylists();

        System.out.println("Informe o id da playlist que deseja editar: ");
        int idDaPlaylist = sc.nextInt();

        System.out.println("Informe seu nome da playlist:");
        String nome = sc.nextLine();
        System.out.println("Informe a descrição da playlist: ");
        String descricao = sc.nextLine();

        boolean sucesso = fachada.editarPlaylist(idDaPlaylist, nome, descricao);

        if (sucesso) {
            System.out.println("playlist atualizada com sucesso!");
        } else {
            System.out.println("Falha ao atualizar laylist");
        }
    }
}
