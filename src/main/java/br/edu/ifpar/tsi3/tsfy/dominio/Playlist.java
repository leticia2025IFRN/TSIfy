package br.edu.ifpar.tsi3.tsfy.dominio;

import java.util.ArrayList;
import java.util.Objects;

public class Playlist {
    
    private Usuario dono;
    
    private String nome;
    
    private String descricao;
    
    private ArrayList<Musica> musicas;
    
    public Playlist() { }

    public Playlist(Usuario dono, String nome, String descricao) {
        this.dono = dono;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }
    
    public void adicionarPlaylist(Musica musica){
        this.musicas.add(musica);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.dono);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Objects.hashCode(this.musicas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Playlist other = (Playlist) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.descricao, other.descricao);
    }
}
