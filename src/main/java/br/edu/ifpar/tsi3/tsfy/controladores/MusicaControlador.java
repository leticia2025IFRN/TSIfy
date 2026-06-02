package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import java.util.ArrayList;

public class MusicaControlador {

    public ArrayList<Musica> todasAsMusicas = new ArrayList<>();

    // Como sei que a música ja não existe?
    public boolean registrarMusica(
        String titulo,
        String compositor,
        String interprete,
        Double duracao
    ) {
        Musica novaMusica = new Musica(titulo, compositor, interprete, duracao);
        this.todasAsMusicas.add(novaMusica);
        return true;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Musica> listarTodasMusicas() {
        return (ArrayList<Musica>) todasAsMusicas.clone();
    }

    public boolean editarMusica(
        int id,
        String titulo,
        String compositor,
        String interprete,
        double duracao
    ) {
        if (id < 0 || id > todasAsMusicas.size() - 1) {
            return false;
        }

        Musica musicaBuscada = todasAsMusicas.get(id);

        musicaBuscada.setTitulo(titulo);
        musicaBuscada.setCompositor(compositor);
        musicaBuscada.setInterprete(interprete);
        musicaBuscada.setDuracao(duracao);

        return true;
    }

    public Musica buscarPorId(int id) {
        if (id < 0 || id > todasAsMusicas.size() - 1) {
            return null;
        }

        Musica musicaBuscada = todasAsMusicas.get(id);
        return musicaBuscada;
    }

    public boolean revomerMusica(int id) {
        if (id < 0 || id > todasAsMusicas.size() - 1) {
            return false;
        }

        todasAsMusicas.remove(id);
        return true;
    }
}
