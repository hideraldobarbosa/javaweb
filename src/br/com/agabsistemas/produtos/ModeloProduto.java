package br.com.agabsistemas.produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

@SuppressWarnings("unused")
public class ModeloProduto {
	

	private DataSource origemDados;
	public ModeloProduto(DataSource origemDados){
		this.origemDados=origemDados;
	}
	
	
	public List<Produto> buscaProdutos() throws Exception{
		
		List<Produto> produtos = new ArrayList<>();
		
		Connection minhaConexao = null;
		java.sql.Statement meuStatement = null;
		ResultSet meuResultset = null;
		
		try{
		//---- Estabelecer a conexão ---//
		
		minhaConexao = origemDados.getConnection();
		
		//--- criar a sentença Sql ---// 
		String instrucaoSql="select * from produto";
		
		//--- receber o result set obetido--//
		meuStatement = minhaConexao.createStatement();
		
		//-- executar instrução sql 
		meuResultset = meuStatement.executeQuery(instrucaoSql);
		
		
		while( meuResultset.next()){
			int    icodigo = meuResultset.getInt("codigo");
			String cdescricao = meuResultset.getString("Descricao");
			double dpreco = meuResultset.getDouble("preco");
			int    iqtde = meuResultset.getInt("quantidade");
			int    ifabcodigo=meuResultset.getInt("fabricante_codigo");
			
			Produto tempProduto = new Produto(icodigo,cdescricao,dpreco,iqtde,ifabcodigo);
			
			produtos.add(tempProduto);
		}
		
		}catch(Exception erro){
			erro.printStackTrace();
		}finally{
			
			meuStatement.close();
			minhaConexao.close();
		}
		
		return produtos;
		
		
	}


	public void insereProdutoNovo(Produto novoProduto) throws Exception {
		// TODO Auto-generated method stub
		
		Connection 			minhaConexao = null;
		PreparedStatement  meuStatement = null;
		
		// Obter a conexão 
		try{
			
			minhaConexao=origemDados.getConnection();
	
		
		// criar instrução sql de insert na tabela produto
		
		String sql="Insert into produto (codigo, descricao,preco,quantidade,fabricante_codigo) "+
		"values (?,?,?,?,?)";
		
		// estabelecer os parametros para produto
		meuStatement=minhaConexao.prepareStatement(sql);
		meuStatement.setInt(1,novoProduto.getCodigo());
		meuStatement.setString(2,novoProduto.getDescricao());
		meuStatement.setDouble(3,novoProduto.getPreco());
		meuStatement.setInt(4,novoProduto.getQuantidade());
		meuStatement.setInt(5,novoProduto.getFabricante_codigo());
		
		// executar a instrução sql
		meuStatement.execute();
		

		}catch(Exception erro){
			erro.printStackTrace();
		}finally{
			
			meuStatement.close();
			minhaConexao.close();
		}
		
		
	}


	public Produto buscaProduto(String cCodigo) throws Exception {
		// TODO Auto-generated method stub
		
		Produto oProduto=null;
		Connection minhaConexao = null;
		PreparedStatement meuStatement = null;
		ResultSet meuResultset  = null;
		String cProduto = cCodigo;
		
		try{		
			// Estabelecer a conexão com a base de dados
			minhaConexao=origemDados.getConnection();
		
			// criar sql instrunção que busque o produto
			String sql = "select * from produto where codigo=?";
			
			// criar a consulta preparada
			meuStatement= minhaConexao.prepareStatement(sql);			
			// definir os parametros
			meuStatement.setString(1,cProduto);
			
			// executar a consulta
			meuResultset=meuStatement.executeQuery();
			
			// resposta da consulta 
		
			if( meuResultset.next()){
				
				
				int    icodigo = meuResultset.getInt("codigo");
				String cdescricao = meuResultset.getString("Descricao");
				double dpreco = meuResultset.getDouble("preco");
				int    iqtde = meuResultset.getInt("quantidade");
				int    ifabcodigo=meuResultset.getInt("fabricante_codigo");
				
				oProduto = new Produto(icodigo,cdescricao,dpreco,iqtde,ifabcodigo);

			}else{
				throw new Exception("Não encontramos o produto-> "+cProduto);
			}	
			
		}finally{
			
			meuStatement.close();
			minhaConexao.close();
		}
		return oProduto;
	
	}


	public void alterarProduto(Produto produtoAlterado) throws Exception {
		// TODO Auto-generated method stub
	
		
		Connection 			minhaConexao = null;
		PreparedStatement   meuStatement = null;
		
		// Obter a conexão 
		try{
			
			minhaConexao=origemDados.getConnection();
		
		// criar setença sql de alteração do registro na tabela produto
		
		String sql="updete produto set descricao = ?, preco = ?,quantidade = ?,fabricante_codigo = ?"
				+ " where codigo = ? ";
		
		// estabelecer os parametros para produto
		meuStatement=minhaConexao.prepareStatement(sql);
		
		// insere os parametros
		meuStatement.setString(1,produtoAlterado.getDescricao());
		meuStatement.setDouble(2,produtoAlterado.getPreco());
		meuStatement.setInt(3,produtoAlterado.getQuantidade());
		meuStatement.setInt(4,produtoAlterado.getFabricante_codigo());
		meuStatement.setInt(5,produtoAlterado.getCodigo());
		
		// executar a instrução sql
		meuStatement.execute();
		
		}catch(Exception erro){
			erro.printStackTrace();
		}finally{
			
			meuStatement.close();
			minhaConexao.close();
		}
		
		
	}

	public  void excluirProduto(int iCodigo) throws Exception {
		// TODO Auto-generated method stub
		Connection 			minhaConexao = null;
		PreparedStatement   meuStatement = null;
		
		// Obter a conexão 
		try{
			
			minhaConexao=origemDados.getConnection();
		
			// criar setença sql de alteração do registro na tabela produto
			
			String sql="delete from produto "
					+ " where codigo = ? ";
			
			// estabelecer os parametros para produto
			meuStatement=minhaConexao.prepareStatement(sql);
			
			// insere os parametros
			meuStatement.setInt(1,iCodigo);
			
			// executar a instrução sql
			meuStatement.execute();
			

		}catch(Exception erro){
			erro.printStackTrace();
		}finally{
			
			meuStatement.close();
			minhaConexao.close();
		}
	
		// 
	}	
}
