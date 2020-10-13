package br.prysthon.aws.project.enums;

public enum UserStatus {
    ATIVO(1, "ativo"),
    INATIVO(2, "inativo"),
    DESLIGADO(3, "desligado");

    private String description;
    private int cod;

    UserStatus(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescription() {
        return this.description;
    }

    public static UserStatus toEnum(Integer cod) {
        if(cod == null || cod < 0) {
            return null;
        }

        for(UserStatus x: UserStatus.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

    public static UserStatus toEnum(String description) {
        if(description == null || description.isEmpty()) {
            return null;
        }

        for(UserStatus x: UserStatus.values()) {
            if(description.equals(x.getDescription())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Descricao inválido: " + description);
    }
}
