package modelo_servico;

public class TaxaBrasileira {

    public double taxa(double valor) { // O método tem o tipo double primitivo porque assumimos que sempre havera um
                                       // valor
        if (valor <= 100.0) {
            return valor * 0.2;
        } else {
            return valor * 0.15;
        }
    }

}