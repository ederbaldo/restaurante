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
import model.OpenLicense;
import model.SerialOpenLicense;
import model.Software;
import model.TipoLicense;

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

    public void flush() {
        em.flush();
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

    //----------------ip -----------------------
    public List<Object[]> buscarColaboradoresId(BigDecimal id) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select colab_id, cd_colab, nome_colab from v_colab where dt_demis is null and colab_id = " + id);
        List<Object[]> results = query.getResultList();
        return results;
        //public List<Object[]> buscarColaboradores(BigDecimal mat) usa esse metodo tbm
    }

    //----------------ComputadorSoftwareMB -----------------------
    public List<Object[]> buscarSoftRelacionadoMicro(String key) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT\n"
                + "  CO.DESCRICAO MICRO ,\n"
                + "  SO.DESCRICAO,\n"
                + "  SO.KEY\n"
                + "FROM\n"
                + "  SOFTWARE SO ,\n"
                + "  COMPUTADOR CO ,\n"
                + "  COMPUTADOR_SOFTWARE CS\n"
                + "WHERE\n"
                + "  SO.ID_SOFTWARE     = CS.ID_SOFTWARE\n"
                + "AND CS.ID_COMPUTADOR = CO.ID_COMPUTADOR\n"
                + "AND SO.KEY           = '" + key + "'");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Software> buscarSoftware(String nome) {
        return (List<Software>) em.createNativeQuery("SELECT * FROM software where key like '%" + nome + "%'", Software.class).getResultList();
    }

    public List<Computador> buscarComputador(String nome) {
        return (List<Computador>) em.createNativeQuery("SELECT * FROM computador where descricao like '%" + nome + "%'", Computador.class).getResultList();
    }

    public List<Computador> buscarTodosComputadores() {
        return (List<Computador>) em.createNativeQuery("SELECT * FROM computador order by descricao ", Computador.class).getResultList();
    }

    public List<Colab> buscarColaborador(int mat) {
        return (List<Colab>) em.createNativeQuery("SELECT nome_colab, cd_colab FROM v_colab where dt_demis is null  and cd_colab = " + mat, Colab.class).getResultList();
    }

    //----------------Software -----------------------
    public List<SerialOpenLicense> buscarSerialOpen(String nome) {
        return (List<SerialOpenLicense>) em.createNativeQuery("SELECT * FROM serial_open_license where serial like '%" + nome + "%'", SerialOpenLicense.class).getResultList();
    }

    public SerialOpenLicense buscarSerialOpenConverter(String nome) {
        return (SerialOpenLicense) em.createNativeQuery("SELECT * FROM serial_open_license where serial = '" + nome + "'", SerialOpenLicense.class).getSingleResult();
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
                + "       ) total  \n"
                + "       ,FRE.CD\n"
                + "       ,FRC.DT_INIC\n"
                + "       ,FRC.DT_FIM\n"
                + "FROM FRENTE_CAPAC_DIARIA FRC\n"
                + "    ,FRENTE FRE\n"
                + "WHERE FRC.FRENTE_ID = FRE.FRENTE_ID\n"
                + "AND '18/11/2018' BETWEEN FRC.DT_INIC and FRC.DT_FIM\n"
                + "AND FRE.CD IN (1,2,3,4,5,57,72,76,77) \n"
                + "ORDER BY 1");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> buscarEntradaDeCanaFrente2(BigDecimal idFrente) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT (SUM(CC.PESO_BRUTO)-SUM(CC.TARA))/1000 TON_CANA\n"
                + "FROM CERT_CAMPO CC ,\n"
                + "  FRENTE FR ,\n"
                + "  LIB_COLH LC\n"
                + "WHERE LC.FRENTE_ID   = FR.FRENTE_ID\n"
                + "AND LC.LIBCOLH_ID  = CC.LIBCOLH_ID\n"
                + "AND TO_CHAR(CC.DT_HR_REF,'DD/MM/YYYY') = '18/11/2018'\n"
                + "AND FR.CD = " + idFrente + "\n"
                + "AND LC.MOTLIBER_ID = '1'\n"
                + "");
        List<Object[]> results = query.getResultList();
        return results;
    }

    //----------------Open License -----------------------
    public List<Object[]> buscarContrato(BigDecimal contrato) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT ID_OPEN_LICENSE, CONTRATO FROM OPEN_LICENSE where CONTRATO = " + contrato);
        List<Object[]> results = query.getResultList();
        return results;
    }

    //----------------Tipo License -----------------------        
    public List<TipoLicense> buscarTabelaTipoLicense(BigDecimal numero) {
        return (List<TipoLicense>) em.createNativeQuery("SELECT * FROM tipo_license where id_open_license = " + numero, TipoLicense.class).getResultList();
    }

    public OpenLicense buscarContratoConverter(String numero) {
        return (OpenLicense) em.createNativeQuery("SELECT * FROM open_license where contrato = " + numero, OpenLicense.class).getResultList();
    }

    //----------------Serial -----------------------
    public List<SerialOpenLicense> buscarTabelaSerial(BigDecimal numero) {
        return (List<SerialOpenLicense>) em.createNativeQuery("SELECT * FROM SERIAL_OPEN_LICENSE SE, TIPO_LICENSE TI\n"
                + "WHERE SE.ID_TIPO_LICENSE = TI.ID_TIPO_LICENSE\n"
                + "AND TI.ID_OPEN_LICENSE = " + numero, SerialOpenLicense.class).getResultList();
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

    //-----------------Recursos Humanos -----------------------
    
        //-----------------Treinamento -----------------------
    public List<Object[]> buscarTreinamento(Integer idTreinamento) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT DISTINCT TE.ID,\n"
                + "  TE.DESCRICAO AS TREINAMENTO,\n"
                + "  VC. CD_COLAB,\n"
                + "  VC.NOME_COLAB,\n"
                + "   VC.NOME_CARGO,\n"
                + "   VC.DESCR_LOCAL_TRAB\n"
                + "FROM USINAS.v_colab vc,\n"
                + "-- TI.FUNC_SGI FS,\n"
                + "  TI.FUNC_MATRIZ_SGI FMS,\n"
                + "  TI.FUNC_MATRIZ FM,\n"
                + "  TI.FUNC_MATRIZ_TREINAMENTO FT,\n"
                + "  TI.TREINAMENTO TE\n"
                + "WHERE FMS.ID_MATRIZ     = FM.ID\n"
                + "AND FM.ID             = FT.ID_FUNC_MATRIZ\n"
                + "AND FT.ID_TREINAMENTO = TE.ID\n"
                + "AND FMS.ID_SGI      = vc.FUNCAO_ID\n"
                + "AND vc.DT_DEMIS      IS NULL\n"
                + "AND VC.SIND_ID_ASSOC = 4\n"
                + "and TE.ID =" + idTreinamento + "\n"
                + "ORDER BY 2,4");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> buscarTreinamentoFeito(Integer idTreinamento, BigDecimal cdColab) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT te.id\n"
                + ",c.CURSO_ID\n"
                + ",ac.AGENDACURS_ID\n"
                + ",c.DESCR\n"
                + ",VC.CD_COLAB\n"
                + ",VC.NOME_COLAB\n"
                + ",ac.DT_INIC\n"
                + "FROM agenda_curso ac\n"
                + "  ,curso c\n"
                + "  ,curso_forn cf\n"
                + "  ,curso_colab cc\n"
                + "  ,V_COLAB VC\n"
                + "  ,TREINAMENTO_CURSO_SGI tre\n"
                + "  ,TREINAMENTO te\n"
                + "  WHERE ac.CURSOFORN_ID = cf.CURSOFORN_ID\n"
                + "   and cf.CURSO_ID = c.CURSO_ID\n"
                + "  and ac.AGENDACURS_ID = cc.AGENDACURS_ID\n"
                + "  and cc.COLAB_ID = VC.COLAB_ID\n"
                + "  and c.CURSO_ID = tre.ID_CURSO\n"
                + "  and te.ID = tre.ID_TREINAMENTO\n"
                + "  and vc.dt_demis is null\n"
                + "and TE.ID =" + idTreinamento + "\n"
                + "and vc.cd_colab =" + cdColab + "\n"
                + "ORDER BY 1,3"
        );
        List<Object[]> results = query.getResultList();
        return results;
    }
        //-----------------Treinamento Qualidade -----------------------
    public List<Object[]> buscarTreinamentoQualidade() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select ID,DESCRICAO FROM TREINAMENTO ORDER BY ID DESC");
        List<Object[]> results = query.getResultList();
        return results;
    }

}
