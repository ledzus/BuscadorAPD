/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Matheus
 */
public class Produto {
    private String Nome;
    private String Desc;
    private String Link;
    private String Img;
    private String Preco;
    private String Loja;

    public Produto() {
    }

    public Produto(String Nome, String Desc, String Link, String Img, String Preco, String Loja) {
        this.Nome = Nome;
        this.Desc = Desc;
        this.Link = Link;
        this.Img = Img;
        this.Preco = Preco;
        this.Loja = Loja;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String Preco) {
        this.Preco = Preco;
    }

    public String getLoja() {
        return Loja;
    }

    public void setLoja(String Loja) {
        this.Loja = Loja;
    }
}
