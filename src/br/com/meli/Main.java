package br.com.meli;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static Competitor getCompetitor() {
        System.out.println("Digite o nome:");

        String nome = scanner.next();

        System.out.println("Digite o sobrenome:");
        String sobrenome = scanner.next();

        System.out.println("Digite o número do celular:");
        String celular = scanner.next();

        System.out.println("Digite o número de emergência:");
        String emergencia = scanner.next();

        System.out.println("Digite o grupo sangúineo");
        String grupoSanguineo = scanner.next();

        System.out.println("Digite a idade");
        int idade = scanner.nextInt();

        System.out.println("Digite o rg:");
        String rg = scanner.next();

        return new Competitor(nome, sobrenome, celular, emergencia, grupoSanguineo, idade, rg);
    }

    private static void runInteractiveMenu(JungleRace jungleRace) {
        try {
            while (true) {
                System.out.println("Opções \n1 - Inscrever competidor \n2 - Exibir competidores por categoria " +
                        "\n3 - Cancelar inscrição de um competidor");

                int option = scanner.nextInt();

                redirectuserOption(jungleRace, option);

            }
        } finally {
            scanner.close();
        }
    }

    private static void redirectuserOption(JungleRace jungleRace, int option) {
        switch (option) {
            case 1:
                Competitor competior = getCompetitor();
                jungleRace.subscribe(competior);
                break;
            case 2:
                jungleRace.printCompetitorsByCategory();
                break;
            case 3:
                jungleRace.cancelSubscription();
                break;
            default:
                System.out.println("Opção não encontrada, tente novamente.");
                break;
        }
    }

    public static void main(String[] args) {

        Circuit shortCircuit = new Circuit("Pela selva e riacho", true, 1300,
                RaceCategory.SHORT, 2);
        shortCircuit.setUnderAgePrice(1500);

        Circuit mediumCircuit = new Circuit("Pela selva, riacho, lama", true, 2000,
                RaceCategory.MEDIUM, 5);
        mediumCircuit.setUnderAgePrice(2300);

        Circuit advancedCircuit = new Circuit("Pela selva, riacho, lama e escalada", false,
                2800, RaceCategory.MEDIUM, 10);

        JungleRace jungleRace = new JungleRace();
        jungleRace.addCircuit(shortCircuit);
        jungleRace.addCircuit(mediumCircuit);
        jungleRace.addCircuit(advancedCircuit);
        runInteractiveMenu(jungleRace);
    }
}
