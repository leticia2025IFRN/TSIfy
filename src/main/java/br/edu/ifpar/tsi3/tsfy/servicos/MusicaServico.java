package br.edu.ifpar.tsi3.tsfy.servicos;

import java.util.ArrayList;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;

public class MusicaServico {

	private ArrayList<Musica> todasAsMusicas = new ArrayList<>();

	public boolean registrarMusica(String titulo, String compositor, String interprete, Double duracao) {
		Musica novaMusica = new Musica(titulo, compositor, interprete, duracao);
		for (Musica musica : todasAsMusicas) {
			if (musica.equals(novaMusica)) {
				return false;
			}
		}
		this.todasAsMusicas.add(novaMusica);
		return true;
	}

	public  ArrayList<Musica> listarTodasMusicas() {
		return (ArrayList<Musica>) todasAsMusicas.clone();
	}

	public boolean editarMusica(int id, String titulo, String compositor, String interprete, double duracao) {
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
