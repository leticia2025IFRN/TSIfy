/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import java.util.ArrayList;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;

/**
 *
 * @author 1071759
 */
public class UsuarioControlador {

    private ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

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

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaDeUsuariosCopia = (ArrayList<Usuario>) listaDeUsuarios.clone();
        return listaDeUsuariosCopia;
    }

    public Usuario autenticarUsuario(String cpf, String senha) {
 

        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }

        return null;
    }
}
