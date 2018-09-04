package br.com.agabsistemas.produtos;

public class Produto {
			
		private int codigo;
		private String descricao;
		private double preco;
		private int quantidade;
		private int fabricante_codigo;
		
		public Produto(int codigo, String descricao, double preco, int quantidade, int fabricante_codigo) {

			this.codigo = codigo;
			this.descricao = descricao;
			this.preco = preco;
			this.quantidade = quantidade;
			this.fabricante_codigo= fabricante_codigo;
		}
		
		
		public Produto(String descricao, double preco, int quantidade, int fabricante_codigo) {
			this.descricao = descricao;
			this.preco = preco;
			this.quantidade = quantidade;
			this.fabricante_codigo = fabricante_codigo;
		}

		

		public int getCodigo() {
			return codigo;
		}


		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}


		public String getDescricao() {
			return descricao;
		}


		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		public double getPreco() {
			return preco;
		}


		public void setPreco(double preco) {
			this.preco = preco;
		}


		public int getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public int getFabricante_codigo() {
			return fabricante_codigo;
		}


		public void setFabricante_codigo(int fabricante_codigo) {
			this.fabricante_codigo = fabricante_codigo;
		}


		@Override
		public String toString() {
			return "Produtos [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
					+ quantidade + ", fabricante_codigo=" + fabricante_codigo + "]";
		}



		
		
}
