package model;

import java.math.BigDecimal;

public class Venda {

	private String usuarioId;
	private String idvenda;
	private String nome_produto;
	private String data_venda;
	private int quantidade_produto;
	private BigDecimal valor_produto;
	private String nome_vendedor;
	
	public Venda(String idvenda, String nome_produto, String data_venda, int quantidade_produto, BigDecimal valor_produto, String nome_vendedor) {
		super();
		this.idvenda = idvenda;
		this.nome_produto = nome_produto;
		this.data_venda = data_venda;
		this.quantidade_produto = quantidade_produto;
		this.valor_produto = valor_produto;
		this.nome_vendedor = nome_vendedor;
	}
	
	public Venda() {
		super();
	}
	
	public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

	public String getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(String idvenda) {
		this.idvenda = idvenda;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public int getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}

	public BigDecimal getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(BigDecimal valor_produto) {
		this.valor_produto = valor_produto;
	}

	public String getNome_vendedor() {
		return nome_vendedor;
	}

	public void setNome_vendedor(String nome_vendedor) {
		this.nome_vendedor = nome_vendedor;
	}
	
	public BigDecimal valor_total() {
       
        BigDecimal quantidade = new BigDecimal(this.quantidade_produto);
        return this.valor_produto.multiply(quantidade);
    }
}