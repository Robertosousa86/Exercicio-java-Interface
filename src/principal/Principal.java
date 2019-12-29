package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.AluguelCarro;
import entidades.Veiculo;
import modelo_servico.ServicosDeAluguel;
import modelo_servico.TaxaBrasileira;

class Principal {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Digite a data do aluguél do veículo: ");
        System.out.print("Modelo do carro: ");
        String modelo = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy HH:ss): ");
        Date dataInicial = sdf.parse(sc.nextLine());
        System.out.print("Devolução (dd/MM/yyyy HH:ss): ");
        Date dataFinal = sdf.parse(sc.nextLine());
        AluguelCarro aluguelCarro = new AluguelCarro(dataInicial, dataFinal, new Veiculo(modelo));
        
        System.out.print("Digite o preço por hora: ");
        double precoPorHora = sc.nextDouble();
        System.out.print("Digite o preço por Dia: ");
        double precoPorDia = sc.nextDouble();
        ServicosDeAluguel servicosDeAluguel = new ServicosDeAluguel(precoPorDia, precoPorHora, new TaxaBrasileira());
        servicosDeAluguel.gerarNotafiscal(aluguelCarro);

        System.out.println("NOTA FISCAL: ");
        System.out.println("Pagamento Basico: " + String.format("%.2f", aluguelCarro.getNotaFiscal().getPagamentoBasico()));
        System.out.println("Taxa: " + String.format("%.2f", aluguelCarro.getNotaFiscal().getTaxa()));
        System.out.println("Pagamento Total: " + String.format("%.2f", aluguelCarro.getNotaFiscal().getPagamentoTotal()));
        



        sc.close();

    }

}