package br.com.alura.SongsSpring.model;

public enum TipoArtista {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String descricao;

    TipoArtista(String descricao){
        this.descricao = descricao;
    }
    public static TipoArtista fromString(String text){
        for(TipoArtista tipoArtista : TipoArtista.values()){
            if(tipoArtista.descricao.equalsIgnoreCase(text)){
                return  tipoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: "+text);
    }

}
