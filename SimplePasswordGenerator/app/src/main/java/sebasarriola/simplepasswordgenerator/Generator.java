package sebasarriola.simplepasswordgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by gaming on 4/15/2016.
 */
public class Generator {

    private String[] letras = {"a", "b","c", "d", "e", "f", "g", "h","i","j","k","l","m","n","o",
            "p","q","r","s","t","u","v","w","x","y","z"};
    private String[] numeros = {"0","1","2","3","4","5","6","7","8","9"};
    private String[] simbolos = {"!","#","$","%","^","*","-","_"};


    public int longitudDeClave;

    public Generator(int longitud)
    {
        longitudDeClave = longitud;
    }

    public String GenerarClave(int longitud, boolean numerosIncluidos, boolean simbolosIncluidos)
    {
        longitudDeClave = longitud;
        String clave = "";
        String caracter;
        Random rand = new Random();
        List<String> caracteres = new ArrayList<String>(); // crear lista que contendra los caracteres especificados
        caracteres.addAll(Arrays.asList(letras)); // agregar letras a la lista

        if (numerosIncluidos == true && simbolosIncluidos == true) // ambas opciones, numeros y simbolos, selecccionadas
        {
            caracteres.addAll(Arrays.asList(numeros));
            caracteres.addAll(Arrays.asList(simbolos));
        }
        else if(simbolosIncluidos == true) // solo simbolos seleccionados
        {
            caracteres.addAll(Arrays.asList(simbolos));
        }
        else if(numerosIncluidos == true)
        {
            caracteres.addAll(Arrays.asList(numeros));
        }

        for(int i = 0; i < longitudDeClave; i++) // construir la clave
        {
            caracter = caracteres.get(rand.nextInt(caracteres.size() - 1));
            clave += caracter;
        }
        return clave;
    }

}

