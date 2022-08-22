 package br.com.bytebank.banco.test.util;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

 public class Test {
    public static void main(String[] args) {
        Conta cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<Conta>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        // Lambda function
        lista.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));

        // Lambda function
        Comparator<Conta> porNomeTitular = (Conta c1, Conta c2) -> {
            String nomeC1 = c1.getTitular().getNome();
            String nomeC2 = c2.getTitular().getNome();
            return nomeC1.compareTo(nomeC2);
        };

        /*
        lista.forEach(new Consumer<Conta>() {
            @Override
            public void accept(Conta conta) {
                System.out.println(conta + ", " + conta.getSaldo());
            }
        });
        */
        lista.forEach((Conta conta) -> System.out.println(conta + ", " + conta.getSaldo()));

        // Exemplo



        List<String> nomes = new ArrayList<>();
        nomes.add("Super Mario");
        nomes.add("Yoshi");
        nomes.add("Donkey Kong");

        /*
        Collections.sort(nomes, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        */
        Collections.sort(nomes, (s1, s2) -> s1.length() - s2.length());
        BigDecimal test1;
        System.out.println("Double bytes " + BigDecimal.ONE);
        System.out.println(nomes);
    }
}


