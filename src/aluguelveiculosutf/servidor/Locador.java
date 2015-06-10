package aluguelveiculosutf.servidor;

import aluguelveiculosutf.interfaces.InterfaceCli;

/**
 *
 * @author Lucas
 */
public class Locador {
    private boolean locacaoFinalizada;
    private String modeloVeiculoLocado;
    private String localRetirada;
    private String localDevolucao;
    private String dataInicio;
    private String horaInicio;
    private String dataFim;
    private String horaFim;
    private String nomeCondutor;
    private int idadeCondutor;
    private String parcelaPagamentoCartao;
    private boolean receberNotificacao;

    private InterfaceCli refCli;

    /**
     *
     * @param modeloVeiculoLocado
     * @param localRetirada
     * @param localDevolucao
     * @param dataInicio
     * @param horaInicio
     * @param dataFim
     * @param horaFim
     * @param nomeCondutor
     * @param idadeCondutor
     * @param parcelaPagamentoCartao
     * @param refCli
     */
    public Locador(String modeloVeiculoLocado, String localRetirada, String localDevolucao, String dataInicio, String horaInicio, String dataFim, String horaFim, String nomeCondutor, int idadeCondutor, String parcelaPagamentoCartao, InterfaceCli refCli) {
        this.locacaoFinalizada = false;
        this.modeloVeiculoLocado = modeloVeiculoLocado;
        this.localRetirada = localRetirada;
        this.localDevolucao = localDevolucao;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        this.dataFim = dataFim;
        this.horaFim = horaFim;
        this.nomeCondutor = nomeCondutor;
        this.idadeCondutor = idadeCondutor;
        this.parcelaPagamentoCartao = parcelaPagamentoCartao;
        this.refCli = refCli;
    }
    
    /**
     * Locador.
     */
    public Locador() {
        
    }

    @Override
    public String toString() {
        return "Locador{" + "modeloVeiculoLocado=" + getModeloVeiculoLocado() + ", localRetirada=" + getLocalRetirada() + ", localDevolucao=" + getLocalDevolucao() + ", dataInicio=" + getDataInicio() + ", horaInicio=" + getHoraInicio() + ", dataFim=" + getDataFim() + ", horaFim=" + getHoraFim() + ", nomeCondutor=" + getNomeCondutor() + ", idadeCondutor=" + getIdadeCondutor() + ", parcelaPagamentoCartao=" + getParcelaPagamentoCartao() + ", receberNotificacao=" + isReceberNotificacao() + '}';
    }

    /**
     * @return the locacaoFinalizada
     */
    public boolean isLocacaoFinalizada() {
        return locacaoFinalizada;
    }

    /**
     * @param locacaoFinalizada the locacaoFinalizada to set
     */
    public void setLocacaoFinalizada(boolean locacaoFinalizada) {
        this.locacaoFinalizada = locacaoFinalizada;
    }

    /**
     * @return the modeloVeiculoLocado
     */
    public String getModeloVeiculoLocado() {
        return modeloVeiculoLocado;
    }

    /**
     * @param modeloVeiculoLocado the modeloVeiculoLocado to set
     */
    public void setModeloVeiculoLocado(String modeloVeiculoLocado) {
        this.modeloVeiculoLocado = modeloVeiculoLocado;
    }

    /**
     * @return the localRetirada
     */
    public String getLocalRetirada() {
        return localRetirada;
    }

    /**
     * @param localRetirada the localRetirada to set
     */
    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    /**
     * @return the localDevolucao
     */
    public String getLocalDevolucao() {
        return localDevolucao;
    }

    /**
     * @param localDevolucao the localDevolucao to set
     */
    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    /**
     * @return the dataInicio
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the dataFim
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the horaFim
     */
    public String getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the nomeCondutor
     */
    public String getNomeCondutor() {
        return nomeCondutor;
    }

    /**
     * @param nomeCondutor the nomeCondutor to set
     */
    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    /**
     * @return the idadeCondutor
     */
    public int getIdadeCondutor() {
        return idadeCondutor;
    }

    /**
     * @param idadeCondutor the idadeCondutor to set
     */
    public void setIdadeCondutor(int idadeCondutor) {
        this.idadeCondutor = idadeCondutor;
    }

    /**
     * @return the parcelaPagamentoCartao
     */
    public String getParcelaPagamentoCartao() {
        return parcelaPagamentoCartao;
    }

    /**
     * @param parcelaPagamentoCartao the parcelaPagamentoCartao to set
     */
    public void setParcelaPagamentoCartao(String parcelaPagamentoCartao) {
        this.parcelaPagamentoCartao = parcelaPagamentoCartao;
    }

    /**
     * @return the receberNotificacao
     */
    public boolean isReceberNotificacao() {
        return receberNotificacao;
    }

    /**
     * @param receberNotificacao the receberNotificacao to set
     */
    public void setReceberNotificacao(boolean receberNotificacao) {
        this.receberNotificacao = receberNotificacao;
    }

    /**
     * @return the refCli
     */
    public InterfaceCli getRefCli() {
        return refCli;
    }

    /**
     * @param refCli the refCli to set
     */
    public void setRefCli(InterfaceCli refCli) {
        this.refCli = refCli;
    }
    
}
