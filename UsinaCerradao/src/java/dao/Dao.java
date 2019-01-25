package dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Computador;
import model.Colab;
import model.Software;

public class Dao implements Serializable {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Dao() {
        emf = Persistence.createEntityManagerFactory("testePU");
        em = emf.createEntityManager();
    }

    public void gravar(Object objeto) {
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
    }

    public void alterar(Object objeto) {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    public void remover(Object objeto) {
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }

    public Object buscar(Object objeto, int id) {
        return em.find(objeto.getClass(), id);
    }

    public List<?> buscarTodos(Class classe) {
        return em.createQuery("From " + classe.getName()).getResultList();
    }

    public Computador buscarFuncionario(String nome) {
        return (Computador) em.createNativeQuery("Select * from usinas.v_colab where nome_colab like '%" + nome + "%'", Computador.class).getResultList();
    }

    //-----------------Metodos para Classes converter -----------------------
    public Computador buscarFuncionarioConverter(String nome) {
        return (Computador) em.createNativeQuery("Select * from usinas.v_colab where nome_colab like '%" + nome + "%'", Computador.class).getResultList();
    }

    public List<Object[]> buscarColab() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select nome_colab, cd_colab from v_colab where dt_demis is null");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> buscarNF() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT A.NRO,a.SERIE,a.DT_EMISS,a.RAZAO_SOCIAL,a.NRO_NFE,b.CD_PROD,b.DESCR_PROD FROM NF_ENT a, ITNF_ENT b WHERE a.NFENT_ID = b.NFENT_ID AND b.CD_PROD  in ('54578','54579','54160','54164') order by a.DT_EMISS");
        //TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT A.NRO,a.SERIE,a.DT_EMISS,a.RAZAO_SOCIAL,a.NRO_NFE,b.CD_PROD,b.DESCR_PROD FROM NF_ENT a, ITNF_ENT b WHERE a.NFENT_ID = b.NFENT_ID AND b.CD_PROD  in ('54578','54579','54160','54164') and a.nro = 575842 and a.DT_EMISS = '27/04/2012' order by a.DT_EMISS");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> buscarNfPorCodigo(int nf, String data) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT A.NRO,a.SERIE,a.DT_EMISS,a.RAZAO_SOCIAL,a.NRO_NFE,b.CD_PROD,b.DESCR_PROD FROM NF_ENT a, ITNF_ENT b WHERE a.NFENT_ID = b.NFENT_ID AND b.CD_PROD  in ('54578','54579','54160','54164') and a.nro = " + nf + " and a.DT_EMISS  = '" + data + "' order by a.DT_EMISS");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> buscarColaboradores(BigDecimal mat) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select colab_id, cd_colab, nome_colab from v_colab where dt_demis is null and cd_colab = " + mat);
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Software> buscarSoftware(String nome) {
        return (List<Software>) em.createNativeQuery("SELECT * FROM software where key like '%" + nome + "%'", Software.class).getResultList();
    }

    public List<Computador> buscarComputador(String nome) {
        return (List<Computador>) em.createNativeQuery("SELECT * FROM computador where descricao like '%" + nome + "%'", Computador.class).getResultList();
    }

    public List<Colab> buscarColaborador(int mat) {
        return (List<Colab>) em.createNativeQuery("SELECT nome_colab, cd_colab FROM v_colab where dt_demis is null  and cd_colab = " + mat, Colab.class).getResultList();
    }
    //----------------CanaDiaFrenteMB -----------------------

    public List<Object[]> buscarEntradaDeCanaFrente() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT FRE.DESCR FRENTE\n"
                + "      ,FRC.CAPAC_COLHE\n"
                + "      ,(SELECT SUM(FRC.CAPAC_COLHE)\n"
                + "        FROM FRENTE_CAPAC_DIARIA FRC\n"
                + "          ,FRENTE FRE\n"
                + "        WHERE FRC.FRENTE_ID = FRE.FRENTE_ID\n"
                + "        AND '18/11/2018' BETWEEN FRC.DT_INIC and FRC.DT_FIM\n"
                + "        AND FRE.CD IN (1,2,3,4,5,57,72,76,77) \n"
                + "       ) total\n"
                + "FROM FRENTE_CAPAC_DIARIA FRC\n"
                + "    ,FRENTE FRE\n"
                + "WHERE FRC.FRENTE_ID = FRE.FRENTE_ID\n"
                + "AND '18/11/2018' BETWEEN FRC.DT_INIC and FRC.DT_FIM\n"
                + "AND FRE.CD IN (1,2,3,4,5,57,72,76,77) \n"
                + "ORDER BY 1");
        List<Object[]> results = query.getResultList();
        return results;
    }

    //----------------Classes converter -----------------------
    public Software buscarSoftwareConverter(String nome) {
        return (Software) em.createNativeQuery("SELECT * FROM software where key = '" + nome + "'", Software.class).getSingleResult();
    }

    public Computador buscarComputadorConverter(String nome) {
        return (Computador) em.createNativeQuery("SELECT * FROM computador where descricao = '" + nome + "'", Computador.class).getSingleResult();
    }

    public Colab buscarColabConverter(String nome) {
        return (Colab) em.createNativeQuery("SELECT nome_colab, cd_colab FROM v_colab where nome_colab = '" + nome + "'", Colab.class).getSingleResult();
    }

}
