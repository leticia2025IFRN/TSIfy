/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 1071759
 */
public class PlaylistControlador {

    private ArrayList<Playlist> listaDePlaylists = new ArrayList<>();
    private final MusicaControlador musicaControlador;

    public PlaylistControlador(MusicaControlador musicaControlador) {
        super();
        this.musicaControlador = musicaControlador;
    }

    public boolean registrarPlaylist(Usuario dono, String nome, String descricao) {
        Playlist novaPlaylist = new Playlist(dono, nome, descricao);

        for (Playlist playlist : listaDePlaylists) {
            if (novaPlaylist.getNome().equals(playlist.getNome())) {
                return false;
            }
        }

        listaDePlaylists.add(novaPlaylist);
        return true;
    }

    public ArrayList<Playlist> listarPlaylists() {
        return (ArrayList<Playlist>) listaDePlaylists.clone();
    }

    public boolean adicionarMusicaAPlaylist(int idPlaylist, int idMusica) {
        ArrayList<Musica> listaDemusicas = musicaControlador.listarTodasMusicas();

        if (idPlaylist < 0 || idPlaylist > listaDePlaylists.size() - 1) {
            return false;
        }

        if (idMusica < 0 || idMusica > listaDemusicas.size() - 1) {
            return false;
        }

        Playlist playlistEncontrada = listaDePlaylists.get(idPlaylist);
        Musica musicaEncontrada = listaDemusicas.get(idMusica);

        playlistEncontrada.getMusicas().add(musicaEncontrada);
        return true;
    }

    public boolean removerMusicaDaPlaylist(int idPlaylist, int idMusica) {
        if (idPlaylist < 0 || idPlaylist > listaDePlaylists.size() - 1) {
            return false;
        }

        Playlist playlistEncontrada = listaDePlaylists.get(idPlaylist);

        playlistEncontrada.getMusicas().remove(idMusica);
        return true;
    }

    public ArrayList<Musica> listarMusicasDeUmaPlaylist(int idPlaylist) {
        if (idPlaylist < 0 || idPlaylist > listaDePlaylists.size() - 1) {
            return null;
        }

        Playlist playlistEncontrada = listaDePlaylists.get(idPlaylist);

        return playlistEncontrada.getMusicas();
    }

    public boolean removerPlaylist(int idPlaylist) {
        if (idPlaylist < 0 || idPlaylist > listaDePlaylists.size() - 1) {
            return false;
        }

        listaDePlaylists.remove(idPlaylist);
        return true;
    }

    public boolean editarPlaylist(int idPlaylist, String nome, String descricao) {
        if (idPlaylist < 0 || idPlaylist > listaDePlaylists.size() - 1) {
            return false;
        }
        Playlist playlistEncontrada = listaDePlaylists.get(idPlaylist);
        playlistEncontrada.setDescricao(descricao);
        playlistEncontrada.setNome(nome);
        return true;
    }
}
