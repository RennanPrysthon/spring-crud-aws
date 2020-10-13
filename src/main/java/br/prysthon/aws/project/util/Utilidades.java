package br.prysthon.aws.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe para validaçoes e utilidades
 * @author Rennan Prysthon
 * @since 12/10/2020
 */
public abstract class Utilidades {
    /**
     * Retorna o primeiro valor nao nulo de uma lista de objetos
     * @param objects Objetos a serem verificados
     * @param <T> Tipo do objeto a ser retornado
     * @return O primeiro objeto nao nulo
     */
    public static <T> T nvl(T ...objects) {
        for(T object:objects) {
            if(object instanceof String ){
                if (!((String) object).isEmpty()){
                    return object;
                }
            }
            if (object != null)
                return object;
        }
        return null;
    }

    /**
     * Formata uma data no formato dd/MM/yyyy HH:mm:ss
     * @param data Data recebida
     * @return String com a data formatada
     */
    public static String formatDate(Date data) {
        if (data == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(data);
    }
}
