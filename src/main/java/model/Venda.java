package model;

public class Venda {

	private String idvenda;
	private String comprador;
	private String categoria;
	private String nomeProduto;
	private String dataVenda;
	private int quantidade;
	private float valorUnitario;
	private String vendedor;
	
	public Venda(String idvenda, String comprador, String categoria, String nomeProduto, String dataVenda, int quantidade,
			float valorUnitario, String vendedor) {
		super();
		this.idvenda = idvenda;
		this.comprador = comprador;
		this.categoria = categoria;
		this.nomeProduto = nomeProduto;
		this.dataVenda = dataVenda;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.vendedor = vendedor;
	}

	public Venda() {
		super();
	}
	
	public String getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(String idvenda) {
		this.idvenda = idvenda;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
}