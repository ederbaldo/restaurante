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
import model.FuncaoQualidade;
import model.FuncaoTreinamento;
import model.License;
import model.OpenLicense;
import model.SerialOpenLicense;
import model.Software;
import model.TipoLicense;
import model.TreinamentoQualidade;

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
//----------------TI-----------------------
    //----------------Computador----------------

    public Computador buscarFuncionario(String nome) {
        return (Computador) em.createNativeQuery("Select * from usinas.v_colab where nome_colab like '%" + nome + "%'", Computador.class).getResultList();
    }

    //----------------converter-----------------
    public Computador buscarFuncionarioConverter(String nome) {
        return (Computador) em.createNativeQuery("Select * from usinas.v_colab where nome_colab like '%" + nome + "%'", Computador.class).getResultList();
    }

    //----------------Colaborador----------------
    public List<Object[]> buscarColab() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select nome_colab, cd_colab from v_colab where dt_demis is null");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> buscarColaboradores(BigDecimal mat) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select colab_id, cd_colab, nome_colab from v_colab where dt_demis is null and cd_colab = " + mat);
        List<Object[]> results = query.getResultList();
        return results;
    }

    public Colab buscarColabConverter(String nome) {
        return (Colab) em.createNativeQuery("SELECT nome_colab, cd_colab FROM v_colab where nome_colab = '" + nome + "'", Colab.class).getSingleResult();
    }

    //----------------Fornecedor----------------
    public List<Object[]> buscarFornecedor(String nome) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT NOME, NOME_FANT, CORR_ID FROM CORR WHERE NOME like '%" + nome + "%'");
        List<Object[]> results = query.getResultList();
        return results;
    }

    //----------------Nota Fiscal----------------
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

    //----------------ip----------------
    public List<Object[]> buscarColaboradoresId(BigDecimal id) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select colab_id, cd_colab, nome_colab from v_colab where dt_demis is null and colab_id = " + id);
        List<Object[]> results = query.getResultList();
        return results;
        //public List<Object[]> buscarColaboradores(BigDecimal mat) usa esse metodo tbm
    }

    //----------------ComputadorSoftwareMB----------------
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

    //----------------Metodo converter usado no AUTOCOMPLETE----------------
    public Software buscarSoftwareConverter(String nome) {
        return (Software) em.createNativeQuery("SELECT * FROM software where key = '" + nome + "'", Software.class).getSingleResult();
    }

    public List<Computador> buscarComputador(String nome) {
        return (List<Computador>) em.createNativeQuery("SELECT * FROM computador where descricao like '%" + nome + "%'", Computador.class).getResultList();
    }

    public Computador buscarComputadorConverter(String nome) {
        return (Computador) em.createNativeQuery("SELECT * FROM computador where descricao = '" + nome + "'", Computador.class).getSingleResult();
    }

    public List<Computador> buscarTodosComputadores() {
        return (List<Computador>) em.createNativeQuery("SELECT * FROM computador order by descricao ", Computador.class).getResultList();
    }

    public List<Colab> buscarColaborador(int mat) {
        return (List<Colab>) em.createNativeQuery("SELECT nome_colab, cd_colab FROM v_colab where dt_demis is null  and cd_colab = " + mat, Colab.class).getResultList();
    }

    //----------------Serial OpenLicense -----------------------
    public List<SerialOpenLicense> buscarSerialOpen(String nome) {
        return (List<SerialOpenLicense>) em.createNativeQuery("SELECT * FROM serial_open_license where serial like '%" + nome + "%'", SerialOpenLicense.class).getResultList();
    }

    public SerialOpenLicense buscarSerialOpenConverter(String nome) {
        return (SerialOpenLicense) em.createNativeQuery("SELECT * FROM serial_open_license where serial = '" + nome + "'", SerialOpenLicense.class).getSingleResult();
    }

    public List<SerialOpenLicense> buscarTabelaSerial(BigDecimal numero) {
        return (List<SerialOpenLicense>) em.createNativeQuery("SELECT * FROM SERIAL_OPEN_LICENSE SE, TIPO_LICENSE TI\n"
                + "WHERE SE.ID_TIPO_LICENSE = TI.ID_TIPO_LICENSE\n"
                + "AND TI.ID_OPEN_LICENSE = " + numero, SerialOpenLicense.class).getResultList();
    }

    //----------------Open License -----------------------
//    public List<Object[]> buscarContrato(BigDecimal contrato) {
//        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT ID_OPEN_LICENSE, CONTRATO FROM OPEN_LICENSE where CONTRATO = " + contrato);
//        List<Object[]> results = query.getResultList();
//        return results;
//    }
    public List<License> buscarLicense(String nome) {
        return (List<License>) em.createNativeQuery("SELECT * FROM license where descricao like '%" + nome + "%'", License.class).getResultList();
    }

    public License buscarLicenseConverter(String nome) {
        return (License) em.createNativeQuery("SELECT * FROM license where descricao = '" + nome + "'", License.class).getSingleResult();
    }

    public List<TipoLicense> buscarContrato(BigDecimal contrato) {
        return (List<TipoLicense>) em.createNativeQuery("SELECT * FROM TIPO_LICENSE where ID_OPEN_LICENSE = " + contrato, TipoLicense.class).getResultList();
    }

    public List<Object[]> listarTabelaOpenLicense() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT A.CONTRATO,\n"
                + "  C.DESCRICAO,\n"
                + "  B.FORNECEDOR,\n"
                + "  B.QUANTIDADE,\n"
                + "  A.ID_OPEN_LICENSE\n"
                + "FROM OPEN_LICENSE A,\n"
                + "  TIPO_LICENSE B,\n"
                + "  LICENSE C\n"
                + "WHERE A.ID_OPEN_LICENSE = B.ID_OPEN_LICENSE(+)\n"
                + "AND C.ID_LICENSE        = B.ID_LICENSE");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<TipoLicense> buscarTabelaTipoLicense(Integer numero) {
        return (List<TipoLicense>) em.createNativeQuery("SELECT * FROM tipo_license where id_open_license = " + numero, TipoLicense.class).getResultList();
    }

    public OpenLicense buscarContratoConverter(String numero) {
        return (OpenLicense) em.createNativeQuery("SELECT * FROM open_license where contrato = " + numero, OpenLicense.class).getResultList();
    }
//----------------License -----------------------

    public List<License> pesquisarLicense(String nome) {
        return (List<License>) em.createNativeQuery("SELECT * FROM license where descricao like '%" + nome + "%'", License.class).getResultList();
    }
//----------------RECURSOS HUMANOS----------------------- 
    //----------------Treinamento -----------------------
//    public List<Object[]> buscarTreinamento(Integer idTreinamento) {
//        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT DISTINCT TE.ID,\n"
//                + "  TE.DESCRICAO AS TREINAMENTO,\n"
//                + "  VC. CD_COLAB,\n"
//                + "  VC.NOME_COLAB,\n"
//                + "   VC.NOME_CARGO,\n"
//                + "   VC.DESCR_LOCAL_TRAB\n"
//                + "FROM USINAS.v_colab vc,\n"
//                + "-- TI.FUNC_SGI FS,\n"
//                + "  TI.FUNC_MATRIZ_SGI FMS,\n"
//                + "  TI.FUNC_MATRIZ FM,\n"
//                + "  TI.FUNC_MATRIZ_TREINAMENTO FT,\n"
//                + "  TI.TREINAMENTO TE\n"
//                + "WHERE FMS.ID_MATRIZ     = FM.ID\n"
//                + "AND FM.ID             = FT.ID_FUNC_MATRIZ\n"
//                + "AND FT.ID_TREINAMENTO = TE.ID\n"
//                + "AND FMS.ID_SGI      = vc.FUNCAO_ID\n"
//                + "AND vc.DT_DEMIS      IS NULL\n"
//                + "AND VC.SIND_ID_ASSOC = 4\n"
//                + "and TE.ID =" + idTreinamento + "\n"
//                + "ORDER BY 2,4");
//        List<Object[]> results = query.getResultList();
//        return results;
//    }

    public List<Object[]> buscarTreinamento(Integer idTreinamento) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT  TE.ID,\n"
                + "    TE.DESCRICAO AS TREINAMENTO,\n"
                + "    VC.CD_COLAB,\n"
                + "    VC.NOME_COLAB,\n"
                + "    VC.NOME_CARGO,\n"
                + "    VC.DESCR_LOCAL_TRAB,\n"
                + "    TE.VALIDADE,\n"
                + "-----\n"
                + " (SELECT MAX(AC.DT_FIM) \n"
                + "    FROM AGENDA_CURSO AC ,\n"
                + "      CURSO C ,\n"
                + "      CURSO_FORN CF ,\n"
                + "      CURSO_COLAB CC ,\n"
                + "      ti.TREINAMENTO_CURSO_SGI TRE \n"
                + "    WHERE AC.CURSOFORN_ID = CF.CURSOFORN_ID\n"
                + "    AND   CF.CURSO_ID       = C.CURSO_ID\n"
                + "    AND   AC.AGENDACURS_ID  = CC.AGENDACURS_ID\n"
                + "    AND   CC.COLAB_ID       = VC.COLAB_ID\n"
                + "    AND   C.CURSO_ID        = TRE.ID_CURSO\n"
                + "    AND   TE.ID             = TRE.ID_TREINAMENTO\n"
                + "    ) as DATA_fim\n"
                + " ----\n"
                + "  FROM USINAS.v_colab vc,\n"
                + "    TI.FUNC_MATRIZ_SGI FMS,\n"
                + "    TI.FUNC_MATRIZ FM,\n"
                + "    TI.FUNC_MATRIZ_TREINAMENTO FT,\n"
                + "    TI.TREINAMENTO TE\n"
                + "  WHERE FMS.ID_MATRIZ   = FM.ID\n"
                + "  AND FM.ID             = FT.ID_FUNC_MATRIZ\n"
                + "  AND FT.ID_TREINAMENTO = TE.ID\n"
                + "  AND FMS.ID_SGI        = vc.FUNCAO_ID\n"
                + "  AND vc.DT_DEMIS       IS NULL\n"
                + "  AND VC.SIND_ID_ASSOC  = 4\n"
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
                + ",ac.DT_FIM\n"
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

    //----------------Treinamento Qualidade----------------
    public List<Object[]> buscarTreinamentoQualidade() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("select ID,TREINAMENTO FROM RH_TREINAMENTO_QUALIDADE ORDER BY ID DESC");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<TreinamentoQualidade> buscarTreinamentoQualidadeOrderAlfabetica() {
        return (List<TreinamentoQualidade>) em.createNativeQuery("SELECT * FROM RH_TREINAMENTO_QUALIDADE ORDER BY 2 ", TreinamentoQualidade.class).getResultList();
    }

    public List<TreinamentoQualidade> buscarTreinamentoVinculado(BigDecimal id) {
        return (List<TreinamentoQualidade>) em.createNativeQuery("SELECT B.ID,B.TREINAMENTO FROM RH_FUNCAO_TREINAMENTO a, RH_TREINAMENTO_QUALIDADE b WHERE A.ID_TREINAMENTO = B.ID AND  ID_FUNCAO = " + id + "ORDER BY B.ID", TreinamentoQualidade.class).getResultList();
    }

    public List<FuncaoTreinamento> buscarTreinamentoVinculado2(BigDecimal id) {
        return (List<FuncaoTreinamento>) em.createNativeQuery("SELECT * FROM RH_FUNCAO_TREINAMENTO WHERE ID_FUNCAO = " + id + "ORDER BY ID_TREINAMENTO", FuncaoTreinamento.class).getResultList();
    }

    public List<Object[]> buscarFuncao() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT * FROM rh_funcao_qualidade order by id desc");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> BuscarFuncaoSGI(BigDecimal funcaoId) {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT DISTINCT FUNCAO_ID, NOME_CARGO FROM v_colab WHERE FUNCAO_ID =" + funcaoId);
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> BuscarNovaFuncao() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT DISTINCT a.cd_colab,\n"
                + "                a.nome_colab,\n"
                + "                a.nome_cargo,\n"
                + "                a.CD_CCUSTO,\n"
                + "                a.FUNCAO_ID\n"
                + "FROM v_colab     a \n"
                + "WHERE a.dt_demis  IS NULL\n"
                + "AND SUBSTR(a.CD_CCUSTO,1,1) IN('1','2')\n"
                + "and not EXISTS (SELECT * FROM TI.FUNC_MATRIZ_SGI b where a.FUNCAO_ID = b.ID_SGI)\n"
                + "ORDER BY 1");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<Object[]> BuscarFuncaoFilha() {
        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery("SELECT DISTINCT\n"
                + "                a.nome_cargo,\n"
                + "                a.FUNCAO_ID\n"
                + "FROM v_colab     a \n"
                + "WHERE a.dt_demis  IS NULL\n"
                + "AND SUBSTR(a.CD_CCUSTO,1,1) IN('1','2')\n"
                + "and not EXISTS (SELECT * FROM TI.FUNC_MATRIZ_SGI b where a.FUNCAO_ID = b.ID_SGI)\n"
                + "ORDER BY 1");
        List<Object[]> results = query.getResultList();
        return results;
    }

    public List<FuncaoQualidade> pesquisarFuncaoQualidade(String nome) {
        return (List<FuncaoQualidade>) em.createNativeQuery("SELECT * FROM RH_FUNCAO_QUALIDADE  WHERE FUNCAO LIKE '%" + nome + "%' ORDER BY ID DESC", FuncaoQualidade.class).getResultList();
    }

    public List<TreinamentoQualidade> pesquisarTreinamentolidade(String nome) {
        return (List<TreinamentoQualidade>) em.createNativeQuery("SELECT * FROM RH_TREINAMENTO_QUALIDADE  WHERE TREINAMENTO LIKE '%" + nome + "%'", TreinamentoQualidade.class).getResultList();
    }

    public List<TreinamentoQualidade> pesquisarTreinamentoVinculado(String nome, BigDecimal id) {
        return (List<TreinamentoQualidade>) em.createNativeQuery("SELECT B.ID,B.TREINAMENTO FROM RH_FUNCAO_TREINAMENTO a, RH_TREINAMENTO_QUALIDADE b WHERE A.ID_TREINAMENTO = B.ID AND B.TREINAMENTO LIKE '%" + nome + "%' AND A.ID_FUNCAO = " + id, TreinamentoQualidade.class).getResultList();
    }
//----------------AGRICOLA-----------------------    
    //----------------CanaDiaFrenteMB----------------

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

}
