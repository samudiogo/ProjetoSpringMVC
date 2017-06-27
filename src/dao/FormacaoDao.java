package dao;

import java.util.List;

import javax.persistence.EntityManager;

import conexao.Conexao;
import negocio.Formacao;

public class FormacaoDao {

	private static EntityManager conexao = null;
	
	public static Formacao obterPorId(int id) {

		return Conexao.obterConexao().find(Formacao.class, id);
	}

	@SuppressWarnings("unchecked")
	public static List<Formacao> obterLista() {
		return Conexao.obterConexao().createQuery("FROM " + Formacao.class.getName()).getResultList();
	}

	public static void incluir(Formacao formacao) {
		
		try{
			conexao = Conexao.obterConexao();
			
			conexao.getTransaction().begin();
			
			conexao.persist(formacao);
			
			conexao.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			conexao.getTransaction().rollback();
		}		
		
	}

	public static void alterar(Formacao formacao) {
		
		try{
			conexao = Conexao.obterConexao();
			
			conexao.getTransaction().begin();
			
			conexao.merge(formacao);
			
			conexao.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			conexao.getTransaction().rollback();
		}
	}

	public static void excluir(Formacao formacao) {
		try{
			conexao = Conexao.obterConexao();
			
			conexao.getTransaction().begin();
			
			formacao = conexao.find(Formacao.class, formacao.getId());
			
			conexao.remove(formacao);
			
			conexao.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			conexao.getTransaction().rollback();
		}
	}

}
