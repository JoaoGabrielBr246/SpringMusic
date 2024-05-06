package br.com.alura.SongsSpring.model;

public enum Genero {
    ROCK("Rock"),
    SERTANEJO("Sertanejo"),
    POP("Pop"),
    ELETRONICA("Eletronica"),
    GOSPEL("Gospel"),
    RAP("Rap");

    private String descricao;

    Genero(String descricao){
        this.descricao = descricao;
    }

    public static Genero fromString(String text){
        for(Genero genero:Genero.values()){
            if(genero.descricao.equalsIgnoreCase(text)){
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}


