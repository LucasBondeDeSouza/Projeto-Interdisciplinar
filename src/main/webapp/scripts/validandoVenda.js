/**
 * 
 */

function vendaValidar() {
	 
	 let comprador = frmVenda.comprador.value
	 var categoria = document.getElementById("nomeCategoria").value
	 let nome = frmVenda.nomeProduto.value
	 let data = frmVenda.dataVenda.value
	 let quantidade = frmVenda.quantidade.value
	 let valor = frmVenda.valorUnitario.value
	 let vendedor = frmVenda.vendedor.value
	 
	 if (comprador === "") {
		 alert("Preencha o campo Comprador")
		 frmVenda.comprador.focus()
		 return false
	 } else if (categoria === "") {
		 alert("Preencha o campo Categoria")
		 frmVenda.categoria.focus()
		 return false
	 } else if (nome === "") {
		 alert("Preencha o campo Nome Produto")
		 frmVenda.nomeProduto.focus()
		 return false
	 } else if (data === "") {
		 alert("Preencha o campo Data da Venda")
		 frmVenda.dataVenda.focus()
		 return false
	 } else if (quantidade === "") {
		 alert("Preencha o campo Quantidade")
		 frmVenda.quantidade.focus()
		 return false
	 } else if (valor === "") {
		 alert("Preencha o campo Valor do Produto")
		 frmVenda.valorUnitario.focus()
		 return false
	 } else if (vendedor === "") {
		 alert("Preencha o campo Nome Vendedor(a)")
		 frmVenda.vendedor.focus()
		 return false
	 } else {
		 document.forms["frmVenda"].submit()
	 }
 }