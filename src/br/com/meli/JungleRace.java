package br.com.meli;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JungleRace implements AutoCloseable {
    private final Map<Integer, Competitor> competitorsMap;
    private final Map<Integer, Circuit> availableCircuits;
    private int lastSubscribedId;
    private int lastCircuitIndex;
    private final Scanner scanner;

    public JungleRace() {
        this.competitorsMap = new HashMap<>();
        this.availableCircuits = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.lastSubscribedId = 0;
    }

    public void addCircuit(final Circuit circuit) {
        this.availableCircuits.put(this.lastCircuitIndex, circuit);
        this.lastCircuitIndex++;
    }

    public void subscribe(final Competitor competitor) {
        boolean isValidOption = false;
        Circuit selectedCircuit;

        do {
            System.out.println("Opções de circuitos disponíveis:");

            this.availableCircuits.entrySet().stream().forEach(circuitItem -> {
                Circuit circuit = circuitItem.getValue();
                int circuitId = circuitItem.getKey();

                System.out.printf("Circuito: %s - Taxa: %d - ID: %d - Comprimento: %d km - Descrição: %s",
                        circuit.getRaceTypes().label, circuit.getRegularPrice(), circuitId, circuit.getCircuitLength(),
                        circuit.getDescription());

                if (circuit.isUnderageAllowed()) {
                    System.out.printf(" - Preço para menores: %d", circuit.getUnderAgePrice());
                }
                System.out.println();
            });

            System.out.println("Digite o circuito desejado:");
            int selectedOption = scanner.nextInt();

            selectedCircuit = availableCircuits.get(selectedOption);

            if (selectedCircuit == null) {
                System.out.println("Circuito inválido, tente novamente");
                continue;
            }

            if (!selectedCircuit.isUnderageAllowed() && competitor.getIdade() < 18) {
                System.out.println("Circuito não permitido para menores de idade, escolha outro");
                continue;
            }

            isValidOption = true;

        } while (!isValidOption);

        int price = competitor.getIdade() < 18 && selectedCircuit.isUnderageAllowed() ? selectedCircuit.getUnderAgePrice() : selectedCircuit.getRegularPrice();
        competitor.setTaxaInscricao(price);
        competitor.setId(this.lastSubscribedId);
        competitor.setRaceTypes(selectedCircuit.getRaceTypes());
        this.competitorsMap.put(competitor.getId(), competitor);
        this.lastSubscribedId++;

        System.out.println("Inscrição feita com sucesso!");
        System.out.printf("Número de inscrição: %d - Taxa de inscrição: %d\n", competitor.getId(), selectedCircuit.getRegularPrice());

    }

    public void printCompetitorsByCategory() {
        System.out.println("Digite a categoria que deseja lista");
        Arrays.stream(RaceCategory.values()).forEach(raceCategory -> System.out.println(raceCategory.label));

        System.out.println("Digite a categoria:");
        final String category = scanner.next();

        boolean isValidCategory = Arrays.stream(RaceCategory.values()).anyMatch(raceCategory -> raceCategory.label.equalsIgnoreCase(category));

        if (!isValidCategory) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        this.competitorsMap.values().stream().filter(competitor -> competitor.getRaceTypes().label.equalsIgnoreCase(category))
            .forEach(competitor -> System.out.printf("Número de registro: %d; Dados gerais: %s\n", competitor.getId(), competitor.toString()));
    }

    public void cancelSubscription() {
        System.out.println("Digite o id do competidor");
        int competitorId = scanner.nextInt();

        if (!this.competitorsMap.containsKey(competitorId)) {
            System.out.println("Nenhum competidor encontrado com o id informado.");
            return;
        }

        this.competitorsMap.remove(competitorId);
        System.out.println("Cancelamento da inscrição feita com sucesso.");
    }

    @Override
    public void close() throws Exception {
        this.scanner.close();
    }
}
