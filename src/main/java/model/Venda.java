package model;

public class Venda {

	private String vendaId;
    private String comprador;
    private String categoria;
    private String nomeProduto;
    private String dataVenda;
    private String quantidade;
    private String valorUnitario;
    
	public Venda(String vendaId, String comprador, String categoria, String nomeProduto, String dataVenda, String quantidade,
			String valorUnitario) {
		super();
		this.vendaId = vendaId;
		this.comprador = comprador;
		this.categoria = categoria;
		this.nomeProduto = nomeProduto;
		this.dataVenda = dataVenda;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	public Venda() {
		super();
	}

	public String getVendaId() {
		return vendaId;
	}

	public void setVendaId(String vendaId) {
		this.vendaId = vendaId;
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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
