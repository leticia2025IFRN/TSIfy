package br.edu.ifpar.tsi3.tsfy.dominio;

import java.util.Objects;

public class Musica {

    private String titulo;
    private String compositor;
    private String interprete;
    private double duracao;

    public Musica(
        String titulo,
        String compositor,
        String interprete,
        double duracao
    ) {
        this.titulo = titulo;
        this.compositor = compositor;
        this.interprete = interprete;
        this.duracao = duracao;
    }

    public Musica(String titulo, String compositor) {
        this.titulo = titulo;
        this.compositor = compositor;
    }

    public Musica() {
        //Contrutor padrão
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.titulo);
        hash = 41 * hash + Objects.hashCode(this.compositor);
        hash = 41 * hash + Objects.hashCode(this.interprete);
        hash =
            41 * hash +
            (int) (Double.doubleToLongBits(this.duracao) ^
                (Double.doubleToLongBits(this.duracao) >>> 32));
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
        final Musica other = (Musica) obj;
        if (
            Double.doubleToLongBits(this.duracao) !=
            Double.doubleToLongBits(other.duracao)
        ) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.compositor, other.compositor)) {
            return false;
        }
        return Objects.equals(this.interprete, other.interprete);
    }
}
