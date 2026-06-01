/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.servicos.MusicaServico;
import java.util.ArrayList;

/**
 *
 * @author 1071759
 */
public class MusicaControlador {

    private final MusicaServico musicaServico;

    public MusicaControlador(MusicaServico musicaServico) {
        this.musicaServico = musicaServico;
    }

    // Como sei que a música ja não existe?
    public boolean registrarMusica(
        String titulo,
        String compositor,
        String interprete,
        Double duracao
    ) {
        return musicaServico.registrarMusica(
            titulo,
            compositor,
            interprete,
            duracao
        );
    }

    public ArrayList<Musica> listarTodasMusicas() {
        return musicaServico.listarTodasMusicas();
    }

    public boolean editarMusica(
        int id,
        String titulo,
        String compositor,
        String interprete,
        double duracao
    ) {
        return musicaServico.editarMusica(
            id,
            titulo,
            compositor,
            interprete,
            duracao
        );
    }

    public Musica buscarPorId(int id) {
        return musicaServico.buscarPorId(id);
    }

    public boolean revomerMusica(int id) {
        return musicaServico.revomerMusica(id);
    }
}
