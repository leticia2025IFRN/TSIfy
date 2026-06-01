package br.edu.ifpar.tsi3.tsfy.servicos;

import java.util.ArrayList;

import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;

public class UsuarioServico {

	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

	public boolean criarUsuario(String nome, String cpf, String senha) {
		Usuario novoUsuario = new Usuario(cpf, nome, senha);
		for(Usuario usuario : listaDeUsuarios) {
			if(usuario.equals(novoUsuario)) {
				return false;
			}
		}

		listaDeUsuarios.add(novoUsuario);
		return true;
	}

	public ArrayList<Usuario> listarUsuarios(){
		ArrayList<Usuario> listaDeUsuariosCopia = (ArrayList<Usuario>) listaDeUsuarios.clone();
		return listaDeUsuariosCopia;
	}
}
