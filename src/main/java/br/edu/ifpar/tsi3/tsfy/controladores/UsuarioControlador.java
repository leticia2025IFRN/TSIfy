package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

public class UsuarioControlador {

    private final ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

    public boolean criarUsuario(String nome, String cpf, String senha) {
        Usuario novoUsuario = new Usuario(cpf, nome, senha);
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.equals(novoUsuario)) {
                return false;
            }
        }

        listaDeUsuarios.add(novoUsuario);
        return true;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuariosCopia = (ArrayList<
            Usuario
        >) listaDeUsuarios.clone();
        return listaUsuariosCopia;
    }

    public Usuario autenticarUsuario(String cpf, String senha) {
        for (Usuario usuario : listaDeUsuarios) {
            if (
                usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)
            ) {
                return usuario;
            }
        }

        return null;
    }
}
