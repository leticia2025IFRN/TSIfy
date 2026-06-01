/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.servicos.UsuarioServico;

/**
 *
 * @author 1071759
 */
public class UsuarioControlador {

    private final UsuarioServico usuarioServico;

    public UsuarioControlador(UsuarioServico usuarioServico) {
        super();
        this.usuarioServico = usuarioServico;
    }

    public boolean registrarUsuario(String nome, String cpf, String senha) {
        return usuarioServico.criarUsuario(nome, cpf, senha);
    }
}
