package projetoGradle;

public class Produtos {

    private int id_nf = 0;
    private int id_item = 0;
    private int cod_prod = 0;
    private double valor_unit = 0;
    private double quantidade = 0;
    private double desconto = 0;

    public int getId_nf() {
        return id_nf;
    }

    public void setId_nf(int id_nf) {
        this.id_nf = id_nf;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public double getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(double valor_unit) {
        this.valor_unit = valor_unit;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    
}
