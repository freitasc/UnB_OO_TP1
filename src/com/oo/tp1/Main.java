package com.oo.tp1;

import java.util.Scanner;


class MeteorologiaMes {
    public int mes;
    public int ano;
    public double[] temperaturas;


    MeteorologiaMes(int mes, int ano, double[] temperaturas) {
        this.mes = mes;
        this.ano = ano;
        this.temperaturas = temperaturas;
    }

    public double[] getTemperaturas() {
        return temperaturas;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }
}


public class Main {

    public static void main(String[] args) {
        MeteorologiaMes[] obj;
        obj = new MeteorologiaMes[12];

        int escolha = 100;
        Scanner ler = new Scanner(System.in);
        int contaregistros = 0;
        MeteorologiaMes JaneiroRandomico;
        JaneiroRandomico = new MeteorologiaMes(1, 2020, new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31});


        while (escolha != 0) {
            System.out.println("Escolha a funcao:");
            System.out.println("Entrar valor de temperaturas de um mes = 1");
            System.out.println("Calcular temperatura media do mes = 2");
            System.out.println("Calcular temperatura minima do mes = 3");
            System.out.println("Calcular temperatura maxima do mes = 4");
            System.out.println("Gerar relatorio meteorologico = 5");
            System.out.println("Sair do programa = 0");
            System.out.println("Se nenhum mes tier sido inserido, dados aleatorios sobre janeiro serao gerados");
            escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    double[] tempMes = new double[31];
                    int mes;
                    int ano;
                    System.out.println("Digite o Mes");
                    mes = ler.nextInt();
                    System.out.println("Digite o Ano");
                    ano = ler.nextInt();
                    if (mes >= 1 && mes <= 12) {

                        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                            for (int i = 0; i < 31; i++) {
                                System.out.println("Digite a temperatura do dia " + (i+1));
                                tempMes[i] = ler.nextDouble();
                            }
                        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                            for (int i = 0; i < 30; i++) {
                                System.out.println("Digite a temperatura do dia " + (i+1));
                                tempMes[i] = ler.nextDouble();
                            }
                        } else {
                            for (int i = 0; i < 29; i++) {
                                System.out.println("Digite a temperatura do dia " + (i+1));
                                tempMes[i] = ler.nextInt();
                            }
                        }
                    } else {
                        System.out.println("Mes Invalido!");
                    }
                    obj[contaregistros] = new MeteorologiaMes(mes, ano, tempMes);
                    contaregistros = contaregistros + 1;
                    break;

                case 2:
                    double media = calculaMedia(obj, ler, contaregistros, JaneiroRandomico);
                    System.out.println("Temperatura media: " + media);
                    break;

                case 3:
                    double menor = calculaMinima(obj, ler, contaregistros, JaneiroRandomico);
                    System.out.println("Temperatura minima: " + menor);
                    break;

               case 4:
                   double maior = calculaMaxima(obj, ler, contaregistros, JaneiroRandomico);
                   System.out.println("Temperatura maxima: " + maior);
                   break;

               case 5:
                   calculaRelatorio(obj, ler, contaregistros, JaneiroRandomico);
                   break;
            }
        }
    }

    private static double calculaMaxima(MeteorologiaMes[] obj, Scanner ler, int contaregistros, MeteorologiaMes JaneiroRandomico) {
        double[] Temperatura;
        int Mes;
        int Ano;
        double maior = 0;
        if(contaregistros == 0){
            System.out.println("Nenhum mes foi inserido, usando Janeiro Randomico");
                Temperatura = JaneiroRandomico.getTemperaturas();
                    for(int y=0;y<31;y++){
                        if(Temperatura[y] > maior){
                            maior = Temperatura[y];
                        }
                    }
                }
        else{
            System.out.println("Digite o Mes");
            Mes = ler.nextInt();
            System.out.println("Digite o Ano");
            Ano = ler.nextInt();
            for(int i=0;i<12;i++){
                if (obj[i].getAno() == Ano && obj[i].getMes() == Mes){
                    Temperatura = obj[i].getTemperaturas();
                    for(int y=0;y<31;y++){
                        if(Temperatura[y] > maior){
                            maior = Temperatura[y];
                        }
                    }
                    break;
                }
            }
        }
        return maior;
    }

    private static double calculaMinima(MeteorologiaMes[] obj, Scanner ler, int contaregistros, MeteorologiaMes JaneiroRandomico) {
        double[] Temperatura;
        int Mes;
        int Ano;
        double menor = 1000;
        if(contaregistros == 0){
            System.out.println("Nenhum mes foi inserido, usando Janeiro Randomico");
            Temperatura = JaneiroRandomico.getTemperaturas();
            for(int y=0;y<31;y++){
                if(Temperatura[y] > menor){
                    menor = Temperatura[y];
                }
            }
        }
        else{
            System.out.println("Digite o Mes");
            Mes = ler.nextInt();
            System.out.println("Digite o Ano");
            Ano = ler.nextInt();
            for(int i=0;i<12;i++){
                if (obj[i].getAno() == Ano && obj[i].getMes() == Mes){
                    Temperatura = obj[i].getTemperaturas();
                    for(int y=0;y<31;y++){
                        if(Temperatura[y] < menor){
                            menor = Temperatura[y];
                        }
                    }
                    break;
                }
            }
        }
        return menor;
    }

    private static double calculaMedia(MeteorologiaMes[] obj, Scanner ler, int contaregistros, MeteorologiaMes JaneiroRandomico) {
        double[] Temperatura;
        int Mes;
        int Ano;
        double soma = 0;
        int counter = 0;
        if(contaregistros == 0){
            System.out.println("Nenhum mes foi inserido, usando Janeiro Randomico");
            Temperatura = JaneiroRandomico.getTemperaturas();
            for(int y=0;y<31;y++){
                if(Temperatura[y] != 0){
                    soma = soma + Temperatura[y];
                    counter++;
                }
            }
        }
        else{
            System.out.println("Digite o Mes");
            Mes = ler.nextInt();
            System.out.println("Digite o Ano");
            Ano = ler.nextInt();
            for(int i=0;i<12;i++){
                if (obj[i].getAno() == Ano && obj[i].getMes() == Mes){
                    Temperatura = obj[i].getTemperaturas();
                    for(int y=0;y<31;y++){
                        if(Temperatura[y] != 0){
                            soma = soma + Temperatura[y];
                            counter++;
                        }
                    }
                    break;
                }
            }
        }
        return soma/counter;
    }

    private static void calculaRelatorio(MeteorologiaMes[] obj, Scanner ler, int contaregistros, MeteorologiaMes JaneiroRandomico) {
        double[] Temperatura;
        int Mes;
        int Ano;
        double soma = 0;
        int counter = 0;
        double maior = 0;
        double menor = 1000;
        if(contaregistros == 0){
            System.out.println("Nenhum mes foi inserido, usando Janeiro Randomico");
            Temperatura = JaneiroRandomico.getTemperaturas();
            for(int y=0;y<31;y++){
                if(Temperatura[y] != 0){
                    soma = soma + Temperatura[y];
                    counter++;
                }
                if(Temperatura[y] < menor){
                    menor = Temperatura[y];
                }
                if(Temperatura[y] > maior){
                    maior = Temperatura[y];
                }
            }
        }
        else{
            System.out.println("Digite o Mes");
            Mes = ler.nextInt();
            System.out.println("Digite o Ano");
            Ano = ler.nextInt();
            for(int i=0;i<12;i++){
                if (obj[i].getAno() == Ano && obj[i].getMes() == Mes){
                    Temperatura = obj[i].getTemperaturas();
                    for(int y=0;y<31;y++){
                        if(Temperatura[y] != 0){
                            soma = soma + Temperatura[y];
                            counter++;
                        }
                        if(Temperatura[y] < menor){
                            menor = Temperatura[y];
                        }
                        if(Temperatura[y] > maior){
                            maior = Temperatura[y];
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("Temperatura maxima: " + maior);
        System.out.println("Temperatura minima: " + menor);
        System.out.println("Temperatura media: " + soma/counter);
    }
}