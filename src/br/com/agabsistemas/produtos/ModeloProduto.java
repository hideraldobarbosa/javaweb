package br.com.agabsistemas.produtos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

public class ModeloProduto {
	

	private DataSource origemDados;
	public ModeloProduto(DataSource origemDados){
		this.origemDados=origemDados;
	}
	
	
	public List<Produtos> getProdutos() throws Exception{
		
		List<Produtos> produtos = new ArrayList<>();
		
		Connection minhaConexao = null;
		java.sql.Statement meuStatement = null;
		ResultSet meuResultset = null;
		
		//---- Estabelecer a conexão ---//
		
		minhaConexao = origemDados.getConnection();
		
		//--- criar a sentença Sql ---// 
		String instrucaoSql="select * from produto";
		
		//--- receber o result set obetido--//
		meuStatement = minhaConexao.createStatement();
		
		//-- executar instrução sql 
		meuResultset = meuStatement.executeQuery(instrucaoSql);
		
		
		while( meuResultset.next()){
			int    i_codigo = meuResultset.getInt("codigo");
			String c_descricao = meuResultset.getString("Descricao");
			double d_preco = meuResultset.getDouble("preco");
			int    i_qtde = meuResultset.getInt("quantidade");
			
			@SuppressWarnings("unused")
			Produtos tempProduto = new Produtos(i_codigo,c_descricao,d_preco,i_qtde);
			
			produtos.add(tempProduto);
		}
		return produtos;
		
		
	}	
}
