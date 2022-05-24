package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.Individual;
import entidades.companhia;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<Contribuinte>();
		
		System.out.print("Entre com o numero de contribuinte: ");
		
		int N = sc.nextInt();
		
		for ( int i =1; i <= N; i++) {
			System.out.println("Dados do Contruinte: " + i);
			System.out.print("Individual ou companhia (i/c)?");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Renda Anual: ");
			Double rendaAnual = sc.nextDouble();
			if (tipo == 'i') {
				System.out.print("Gastos com Saude: ");
				Double gastosComSaude = sc.nextDouble();
				Individual x = new Individual(nome, rendaAnual, gastosComSaude);
				list.add(x);
			}
			else {
				System.out.print("Numero de Funcionarios: ");
				Integer numeroFuncionarios = sc.nextInt();
				companhia y = new companhia(nome, rendaAnual, numeroFuncionarios);
				list.add(y);
			}
			
		}
		
		System.out.println();
		System.out.print("Imposto a Pagar: ");
		for (Contribuinte ct : list) {
			System.out.println(ct.getNome() + ": R$ " + String.format("%.2f", ct.taxa()));
		}
		
		double somaImposto = 0.0;
		for (Contribuinte ct : list) {
			somaImposto += ct.taxa();
		}
		
		System.out.println();
		System.out.println("Total de Imposto: R$ " + String.format("%.2f", somaImposto));
		
		sc.close();
	}

}
