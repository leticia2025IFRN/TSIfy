/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import br.edu.ifpar.tsi3.tsfy.servicos.PlaylistServico;
import java.util.ArrayList;

/**
 *
 * @author 1071759
 */
public class PlaylistControlador {

    private final PlaylistServico playlistServico;

    public PlaylistControlador(PlaylistServico playlistServico) {
        super();
        this.playlistServico = playlistServico;
    }

    public boolean criarPlaylist(Usuario dono, String nome, String descricao) {
        return playlistServico.criarPlaylist(dono, nome, descricao);
    }

    public ArrayList<Playlist> listarPlaylists() {
        return playlistServico.listarPlaylists();
    }

    public boolean adicionarMusicaPlaylist(int idPlaylist, int idMusica) {
        return playlistServico.adicionarMusicaPlaylist(idPlaylist, idMusica);
    }

    public boolean removerMusicaPlaylist(int idPlaylist, int idMusica) {
        return playlistServico.removerMusicaPlaylist(idPlaylist, idMusica);
    }

    public ArrayList<Musica> listarMusicasPlaylist(int idPlaylist) {
        return playlistServico.listarMusicasPlaylist(idPlaylist);
    }

    public boolean removerPlaylist(int idPlaylist) {
        return playlistServico.removerPlaylist(idPlaylist);
    }

    public boolean editarPlaylist(
        int idPlaylist,
        String nome,
        String descricao
    ) {
        return playlistServico.editarPlaylist(idPlaylist, nome, descricao);
    }
}
