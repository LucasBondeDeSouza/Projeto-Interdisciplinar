/**
 * 
 */

 function validar() {
	 
	 let nome = frmVenda.nome_produto.value
	 let data = frmVenda.data_venda.value
	 let quantidade = frmVenda.quantidade_produto.value
	 let valor = frmVenda.valor_produto.value
	 let vendedor = frmVenda.nome_vendedor.value
	 
	 if (nome === "") {
		 alert("Preencha o campo Nome Produto")
		 frmVenda.nome_produto.focus()
		 return false
	 } else if (data === "") {
		 alert("Preencha o campo Data da Venda")
		 frmVenda.data_venda.focus()
		 return false
	 } else if (quantidade === "") {
		 alert("Preencha o campo Quantidade")
		 frmVenda.quantidade_produto.focus()
		 return false
	 } else if (valor === "") {
		 alert("Preencha o campo Valor do Produto")
		 frmVenda.valor_produto.focus()
		 return false
	 } else if (vendedor === "") {
		 alert("Preencha o campo Nome Vendedor(a)")
		 frmVenda.nome_vendedor.focus()
		 return false
	 } else {
		 document.forms["frmVenda"].submit()
	 }
 }