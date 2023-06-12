package Tarefa_Modulo17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    //FORD
        Montadora<Carro<String>> ford = new Montadora<>("Ford");
        ford.addModelo(new Carro<>("Pick-Up", "Ranger"));
    //CHEVROLET
        Montadora<Carro<String>> chev = new Montadora<>("Chevrolet");
        chev.addModelo(new Carro<>("Sedan", "Onix Plus"));
        chev.addModelo(new Carro<>("Hatch", "Onix"));
    //FIAT
        Montadora<Carro<String>> fiat = new Montadora<>("Fiat");
        fiat.addModelo(new Carro<>("Sedan", "Cronos"));
        fiat.addModelo(new Carro<>("SUV", "Pulse"));
        fiat.addModelo(new Carro<>("Hatch", "Argo"));
    //TOYOTA
        Montadora<Carro<String>> toyota = new Montadora<>("Toyota");
        toyota.addModelo(new Carro<>("Sedan", "Corolla"));
        toyota.addModelo(new Carro<>("SUV", "Corolla Cross"));
        toyota.addModelo(new Carro<>("Hatch", "Yaris"));
        toyota.addModelo(new Carro<>("Pick-Up", "Hilux"));
    //HYUNDAI
        Montadora<Carro<String>> hyundai = new Montadora<>("Hyundai");
        hyundai.addModelo(new Carro<>("Sedan", "HB20S"));
        hyundai.addModelo(new Carro<>("Hatch", "HB20"));
    //VOLKSWAGEN
        Montadora<Carro<String>> vw = new Montadora<>("Volkswagen");
        vw.addModelo(new Carro<>("Sedan", "Virtus"));
        vw.addModelo(new Carro<>("SUV", "Nivus"));
        vw.addModelo(new Carro<>("Hatch", "Polo"));
        vw.addModelo(new Carro<>("Pick-Up", "Amarok"));
    //JEEP
        Montadora<Carro<String>> jeep = new Montadora<>("Jeep");
        jeep.addModelo(new Carro<>("SUV", "Renegade"));
        jeep.addModelo(new Carro<>("Pick-Up", "Gladiator"));

        List<Montadora<Carro<String>>> montadoras = new ArrayList<>();
        montadoras.add(ford);
        montadoras.add(chev);
        montadoras.add(fiat);
        montadoras.add(toyota);
        montadoras.add(hyundai);
        montadoras.add(vw);
        montadoras.add(jeep);


    // Logica do console

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar){
            System.out.println("Selecione uma opção:");
            System.out.println();
            System.out.println("1 - Visualizar as opções de veículos por Montadoras");
            System.out.println("2 - Visualizar as opções de veículos por Modelos");
            System.out.println("0 - Encerrar o programa");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> { //Montadora
                    System.out.println("Selecione uma Montadora");
                    for (int i = 0; i < montadoras.size(); i++) {
                        System.out.println((i + 1) + " - " + montadoras.get(i).getMarca());
                    }
                    int opcaoMontadoraIndex = scanner.nextInt();
                    if (opcaoMontadoraIndex >= 1 && opcaoMontadoraIndex <= montadoras.size()) {
                        Montadora<Carro<String>> opcaoMontadora = montadoras.get(opcaoMontadoraIndex - 1);
                        System.out.println("Opção de veículos da Montadora " + opcaoMontadora.getMarca() + ":");

                        List<Carro<String>> modelos = opcaoMontadora.getModelos();
                        for (Carro<String> modelo : modelos) {
                            System.out.println(modelo.getModelo() + " - " + modelo.getNome());
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }

                case 2 -> { //Modelo
                    System.out.println("Selecione um Modelo:");
                    System.out.println();
                    System.out.println("1 - Sedan");
                    System.out.println("2 - SUV");
                    System.out.println("3 - Hatch");
                    System.out.println("4 - Pick-Up");
                    int modeloDesejadoIndex = scanner.nextInt();
                    String modeloDesejado;
                    switch (modeloDesejadoIndex) {
                        case 1 -> modeloDesejado = "Sedan";
                        case 2 -> modeloDesejado = "SUV";
                        case 3 -> modeloDesejado = "Hatch";
                        case 4 -> modeloDesejado = "Pick-Up";

                        default -> {
                            System.out.println("Opção inválida!");
                            return;
                        }
                    }
                    System.out.println("Opções de veículos do modelo " + modeloDesejado + ":");
                    boolean encontrouCarros = false;
                    List<Carro<String>> carrosDoModelo = new ArrayList<>();
                    List<Montadora<Carro<String>>> montadorasEncontrada = new ArrayList<>();
                    for (Montadora<Carro<String>> montadora : montadoras) {
                        List<Carro<String>> modelos = montadora.getModelos();

                        for (Carro<String> modelo : modelos) {
                            if (modelo.getModelo().equalsIgnoreCase(modeloDesejado)) {
                                carrosDoModelo.add(modelo);
                                encontrouCarros = true;
                                montadorasEncontrada.add(montadora);
                            }
                        }
                    }
                    if (encontrouCarros) {
                        for (int i = 0; i < carrosDoModelo.size(); i++) {
                            Carro<String> carro = carrosDoModelo.get(i);
                            Montadora<Carro<String>> montadora = montadorasEncontrada.get(i);
                            System.out.println(montadora.getMarca() + " - " + carro.getNome());
                        }
                    }
                    if (!encontrouCarros) {
                        System.out.println("Nenhum carro do modelo " + modeloDesejado + " encontrado!");
                    }
                }
                case 0 -> { //Sair
                    continuar = false;
                    System.out.println("Até logo!");
                }
                default -> System.out.println("Opção inválida!");
            }
            if (continuar) {
                System.out.println();
                System.out.println("Deseja fazer mais consultas? (S/N)");
                String resposta = scanner.next();
                continuar = resposta.equalsIgnoreCase("S");
            }
        }

        scanner.close();
    }
}
