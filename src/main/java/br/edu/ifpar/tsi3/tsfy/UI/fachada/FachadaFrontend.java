/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI.fachada;

import br.edu.ifpar.tsi3.tsfy.controladores.MusicaControlador;
import br.edu.ifpar.tsi3.tsfy.controladores.PlaylistControlador;
import br.edu.ifpar.tsi3.tsfy.controladores.UsuarioControlador;
import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 1071759
 */
public class FachadaFrontend {

    private MusicaControlador controladorDeMusica;
    private PlaylistControlador controladorDePlaylist;
    private UsuarioControlador controladorDeUsuario;

    public FachadaFrontend() {
        this.controladorDeMusica = new MusicaControlador();
        this.controladorDePlaylist = new PlaylistControlador(controladorDeMusica);
        this.controladorDeUsuario = new UsuarioControlador();
    }

    public MusicaControlador getControladorDeMusica() {
        return controladorDeMusica;
    }

    public void setControladorDeMusica(MusicaControlador controladorDeMusica) {
        this.controladorDeMusica = controladorDeMusica;
    }

    public PlaylistControlador getControladorDePlaylist() {
        return controladorDePlaylist;
    }

    public void setControladorDePlaylist(PlaylistControlador controladorDePlaylist) {
        this.controladorDePlaylist = controladorDePlaylist;
    }

    public UsuarioControlador getControladorDeUsuario() {
        return controladorDeUsuario;
    }

    public void setControladorDeUsuario(UsuarioControlador controladorDeUsuario) {
        this.controladorDeUsuario = controladorDeUsuario;
    }

    public boolean registrarMusica(String titulo, String compositor, String interprete, Double duracao) {
        boolean sucesso = this.controladorDeMusica.registrarMusica(titulo, compositor, interprete, duracao);
        return sucesso;
    }

    public ArrayList<Musica> listarTodasMusicas() {
        return this.controladorDeMusica.listarTodasMusicas();
    }

    public boolean editarMusica(int id, String titulo, String compositor, String interprete, double duracao) {
        boolean sucesso = this.controladorDeMusica.editarMusica(id, titulo, compositor, interprete, duracao);
        return sucesso;
    }

    public Musica buscarPorId(int id) {
        Musica sucesso = this.controladorDeMusica.buscarPorId(id);
        return sucesso;
    }

    public boolean revomerMusica(int id) {
        boolean sucesso = this.controladorDeMusica.revomerMusica(id);
        return sucesso;
    }
    // Fim do bloco de musicas

    // Metodos de playlist
    public boolean registrarPlaylist(Usuario dono, String nome, String descricao) {
        boolean sucesso = this.controladorDePlaylist.registrarPlaylist(dono, nome, descricao);
        return sucesso;
    }

    public ArrayList<Playlist> listarPlaylists() {
        return this.controladorDePlaylist.listarPlaylists();
    }

    public boolean adicionarMusicaAPlaylist(int idPlaylist, int idMusica) {
        boolean sucesso = this.controladorDePlaylist.adicionarMusicaAPlaylist(idPlaylist, idMusica);
        return sucesso;

    }

    public boolean removerMusicaDaPlaylist(int idPlaylist, int idMusica) {
        boolean sucesso = this.controladorDePlaylist.removerMusicaDaPlaylist(idPlaylist, idMusica);
        return sucesso;
    }

    public ArrayList<Musica> listarMusicasDeUmaPlaylist(int idPlaylist) {
        ArrayList<Musica> sucesso = this.controladorDePlaylist.listarMusicasDeUmaPlaylist(idPlaylist);
        return sucesso;
    }

    public boolean removerPlaylist(int idPlaylist) {
        boolean sucesso = this.controladorDePlaylist.removerPlaylist(idPlaylist);
        return sucesso;
    }

    public boolean editarPlaylist(int idPlaylist, String nome, String descricao) {
        boolean sucesso = this.controladorDePlaylist.editarPlaylist(idPlaylist, nome, descricao);
        return sucesso;
    }
    // Fim do bloco de playlist

    // Metodos de usuario
    public boolean registrarUsuario(String nome, String cpf, String senha) {
        boolean sucesso = this.controladorDeUsuario.criarUsuario(nome, cpf, senha);
        return sucesso;
    }

    public Usuario autenticar(String cpf, String senha) {
        return this.controladorDeUsuario.autenticarUsuario(cpf, senha);
    }

}
