package br.com.meli;

public class Competitor {
    private final String nome;
    private final String sobrenome;
    private final String numeroCelular;
    private final String numeroEmergencia;
    private final String grupoSanguineo;
    private final int idade;
    private int id;
    private final String rg;
    private int taxaInscricao;
    private RaceCategory raceCategory;


    public Competitor(String nome, String sobrenome, String numeroCelular, String numeroEmergencia, String grupoSanguineo,
                      int idade, String rg) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroCelular = numeroCelular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.idade = idade;
        this.rg = rg;
    }

    public boolean isUnderAge() {
        return idade < 18;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public int getIdade() {
        return idade;
    }

    public int getId() {
        return id;
    }

    public String getRg() {
        return rg;
    }

    public int getTaxaInscricao() {
        return taxaInscricao;
    }

    public void setTaxaInscricao(int taxaInscricao) {
        this.taxaInscricao = taxaInscricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RaceCategory getRaceTypes() {
        return raceCategory;
    }

    public void setRaceTypes(RaceCategory raceCategory) {
        this.raceCategory = raceCategory;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", raceCategory=" + raceCategory.label +
                '}';
    }
}
