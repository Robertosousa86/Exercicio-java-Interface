package modelo_servico;

import entidades.AluguelCarro;
import entidades.NotaFiscal;


public class ServicosDeAluguel {

    private Double precoPorDia;
    private Double precoPorHora;

    private Taxas taxaBr;
    /*
     * Não é uma boa prática instaciar essa classe porque ela torna o código muito
     * acoplado, de dificil manutenção, com vários pontos de mudança no código, caso
     * haja uma mudança na regra de negócio.
     */

    public ServicosDeAluguel() {
    }

    public ServicosDeAluguel(Double precoPorDia, Double precoPorHora, Taxas taxaBr) {
        this.precoPorDia = precoPorDia;
        this.precoPorHora = precoPorHora;
        this.taxaBr = taxaBr;
    }

    public void gerarNotafiscal(AluguelCarro aluguelCarro) {
        long tempo = aluguelCarro.getDataInicial().getTime(); // getTime() pega o valor em milisecundos
        long tempo2 = aluguelCarro.getDataFinal().getTime();
        double horas = (double) (tempo2 - tempo) / 1000 / 60 / 60;

        double pagamentoBasico; // declarada aqui para ser usada fora do escopo do if
        if (horas <= 12) {
            pagamentoBasico = precoPorHora * Math.ceil(horas); // math.ceil arredonda
        } else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
        }
        double taxa = taxaBr.taxa(pagamentoBasico); // calcula o valor do imposto
        aluguelCarro.setNotaFiscal(new NotaFiscal(pagamentoBasico, taxa)); // novo objeto do tipo notafiscal asociado ao
                                                                           // objeto aluguelcarro
        /*
         * casting de double garante o resultado em double, o que torna possivel o
         * arredondamentodos minutos para converter para mili par seg div 1000, de seg
         * para min div por 60, min para hora div 60
         */
    }

}