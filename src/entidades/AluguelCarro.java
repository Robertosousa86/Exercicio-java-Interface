package entidades;

import java.util.Date;

public class AluguelCarro {

    private Date dataInicial;
    private Date dataFinal;

    private Veiculo veiculo;
    private NotaFiscal notaFiscal;

    public AluguelCarro() {

    }

    public AluguelCarro(Date dataInicial, Date datafinal, Veiculo veiculo) {
        this.dataInicial = dataInicial;
        this.dataFinal = datafinal;
        this.veiculo = veiculo;
    }


    public Date getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public NotaFiscal getNotaFiscal() {
        return this.notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }



}