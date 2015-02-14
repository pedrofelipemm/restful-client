package pmoreira.model;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pmoreira.client.Constants;
import pmoreira.model.rest.CustomLink;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cerveja {

    @XmlElement
    private String nome;

    @XmlElement
    private String descricao;

    @XmlElement
    private String cervejaria;

    @XmlElement
    private Tipo tipo;

    @XmlElement
    private CustomLink link;

    public Link getLink() {
        return Link.fromUri(Constants.HOST + link.getHref()).rel(link.getRel()).title(link.getTitle()).build();
    }

    public enum Tipo {
        LAGER, PILSEN, PALE_ALE, INDIAN_PALE_ALE, WEIZEN;
    }

    @SuppressWarnings("unused")
    private Cerveja() {
    }

    public Cerveja(String nome, String descricao, String cervejaria, Tipo tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.cervejaria = cervejaria;
        this.tipo = tipo;
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

    public String getCervejaria() {
        return cervejaria;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cervejaria == null) ? 0 : cervejaria.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cerveja)) {
            return false;
        }
        Cerveja other = (Cerveja) obj;
        if (cervejaria == null) {
            if (other.cervejaria != null) {
                return false;
            }
        } else if (!cervejaria.equals(other.cervejaria)) {
            return false;
        }
        if (descricao == null) {
            if (other.descricao != null) {
                return false;
            }
        } else if (!descricao.equals(other.descricao)) {
            return false;
        }
        if (nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!nome.equals(other.nome)) {
            return false;
        }
        if (tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao;
    }

}