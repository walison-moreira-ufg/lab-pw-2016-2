package jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CadastroAlunoJpaModel {

  private static EntityManager obterConexao() throws SQLException {
    EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("alunos");
    return emf.createEntityManager();
  }

  public static void salvar(Aluno aluno) throws SQLException {
    EntityManager em = obterConexao();
    em.getTransaction().begin();
    em.merge(aluno);
    em.getTransaction().commit();
  }


  public static void excluir(Aluno aluno) throws SQLException {
    EntityManager em = obterConexao();
    em.remove(aluno);
  }

  public static List<Aluno> listar() throws SQLException {
    EntityManager em = obterConexao();
    TypedQuery<Aluno> q = em.createQuery("from Aluno", Aluno.class);
    return q.getResultList();
  }

}
