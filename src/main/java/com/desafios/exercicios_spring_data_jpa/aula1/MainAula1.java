package com.desafios.exercicios_spring_data_jpa.aula1;

import com.desafios.exercicios_spring_data_jpa.aula1.enums.CodigoErro;
import com.desafios.exercicios_spring_data_jpa.aula1.enums.Mes;
import com.desafios.exercicios_spring_data_jpa.aula1.enums.Moeda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainAula1 {
    public void exibirMenu() {
        //ex1
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        input.stream()
                .map(str -> {
                    try{
                        return Optional.of(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
                        return Optional.<Integer>empty();
                    }
                })
                .filter(Optional::isPresent).map(Optional::get).forEach(System.out::println);

        //ex2
        System.out.println(processaNumero(Optional.of(5)));
        System.out.println(processaNumero(Optional.of(-3)));
        System.out.println(processaNumero(Optional.empty()));

        //ex3
        System.out.println(obterPrimeiroEUltimoNome("  João Carlos Silva   ")); // Saída: "João Silva"
        System.out.println(obterPrimeiroEUltimoNome("Maria   "));
        System.out.println(obterPrimeiroEUltimoNome("  Carla Soares Silva       "));

        //ex4
        System.out.println(ehPalindromo("socorram me subi no onibus em marrocos"));
        System.out.println(ehPalindromo("Java"));

        //ex5
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(converterEmails(emails));

        //ex6
        System.out.println(Mes.FEVEREIRO.getNumeroDeDias());
        System.out.println(Mes.AGOSTO.getNumeroDeDias());

        //ex7
        System.out.println(Moeda.DOLAR.converterPara(100));
        System.out.println(Moeda.EURO.converterPara(100));

        //ex8
        System.out.println(CodigoErro.NOT_FOUND.getCodigo());
        System.out.println(CodigoErro.BAD_REQUEST.getDescricao());
    }

    //ex2
    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        return numero.filter(n -> n > 0).map(n -> n * n);
    }

    //ex3
    public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
        String[] partes = nomeCompleto.trim().split("\\s+");

        String primeiroNome = partes[0];
        String ultimoNome = partes[partes.length - 1];

        if (partes.length == 1) {
             return primeiroNome;
        }
        return primeiroNome + " " + ultimoNome;
    }

    //ex4
    public static boolean ehPalindromo(String palavra) {
        String p= palavra.replace(" ", "").toLowerCase();
        return new StringBuilder(p).reverse().toString().equalsIgnoreCase(p);
    }

    //ex5
    public List<String> converterEmails(List<String> emails) {
        return emails.stream()
                .map(String::toLowerCase).collect(Collectors.toList());
    }
}
