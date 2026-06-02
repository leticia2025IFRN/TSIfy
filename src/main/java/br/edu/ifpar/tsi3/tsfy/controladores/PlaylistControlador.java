package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

public class PlaylistControlador {

    private ArrayList<Playlist> listaPlaylists = new ArrayList<>();
    private final MusicaControlador musicaControlador;

    public PlaylistControlador(MusicaControlador musicaControlador) {
        super();
        this.musicaControlador = musicaControlador;
    }

    public boolean criarPlaylist(Usuario dono, String nome, String descricao) {
        Playlist novaPlaylist = new Playlist(dono, nome, descricao);

        for (Playlist playlist : listaPlaylists) {
            if (novaPlaylist.getNome().equals(playlist.getNome())) {
                return false;
            }
        }

        listaPlaylists.add(novaPlaylist);
        return true;
    }

    public ArrayList<Playlist> listarPlaylists() {
        return (ArrayList<Playlist>) listaPlaylists.clone();
    }

    public boolean adicionarMusicaPlaylist(int idPlaylist, int idMusica) {
        ArrayList<Musica> listaDemusicas =
            musicaControlador.listarTodasMusicas();

        if (idPlaylist < 0 || idPlaylist > listaPlaylists.size() - 1) {
            return false;
        }

        if (idMusica < 0 || idMusica > listaDemusicas.size() - 1) {
            return false;
        }

        Playlist playlistEncontrada = listaPlaylists.get(idPlaylist);
        Musica musicaEncontrada = listaDemusicas.get(idMusica);

        playlistEncontrada.getMusicas().add(musicaEncontrada);
        return true;
    }

    public boolean removerMusicaPlaylist(int idPlaylist, int idMusica) {
        if (idPlaylist < 0 || idPlaylist > listaPlaylists.size() - 1) {
            return false;
        }

        Playlist playlistEncontrada = listaPlaylists.get(idPlaylist);

        playlistEncontrada.getMusicas().remove(idMusica);
        return true;
    }

    public ArrayList<Musica> listarMusicasPlaylist(int idPlaylist) {
        if (idPlaylist < 0 || idPlaylist > listaPlaylists.size() - 1) {
            return null;
        }

        Playlist playlistEncontrada = listaPlaylists.get(idPlaylist);

        return playlistEncontrada.getMusicas();
    }

    public boolean removerPlaylist(int idPlaylist) {
        if (idPlaylist < 0 || idPlaylist > listaPlaylists.size() - 1) {
            return false;
        }

        listaPlaylists.remove(idPlaylist);
        return true;
    }

    public boolean editarPlaylist(
        int idPlaylist,
        String nome,
        String descricao
    ) {
        if (idPlaylist < 0 || idPlaylist > listaPlaylists.size() - 1) {
            return false;
        }
        Playlist playlistEncontrada = listaPlaylists.get(idPlaylist);
        playlistEncontrada.setDescricao(descricao);
        playlistEncontrada.setNome(nome);
        return true;
    }
}
