package Modelos.Utils;

import Modelos.Bosque.*;
import Modelos.Sabana.*;
import Modelos.Selva.*;
import Modelos.Acuario.*;
import Modelos.Desierto.*;
import Modelos.Artico.*;
import Modelos.Enumeration.*;

/** Una fábrica de animales para crear y retornar instancias de animales específicos
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class AnimalFactory {

    /** Método para obtener una instancia de un animal utilizando un tipo animal y un nombre
     * @param tipo El tipo de animal que se quiere fabricar
     * @param nombre El nombre de la instancia de animal a fabricar
     * @return La instancia de una subclase de Animal perteneciente al tipo animal */
    public Animal crearAnimal(TipoAnimal tipo, String nombre) {
        if(tipo.getHabitat() == TipoHabitat.Bosque) {
            if (tipo == TipoAnimal.Carpintero) {
                return new Carpintero(nombre);
            } else if (tipo == TipoAnimal.Huemul) {
                return new Huemul(nombre);
            } else if (tipo == TipoAnimal.Oso) {
                return new Oso(nombre);
            } else if (tipo == TipoAnimal.Pudu) {
                return new Pudu(nombre);
            } else if (tipo == TipoAnimal.Puma) {
                return new Puma(nombre);
            } else {
                return new Zorro(nombre);
            }
        } else if(tipo.getHabitat() == TipoHabitat.Sabana) {
            if (tipo == TipoAnimal.Cebra) {
                return new Cebra(nombre);
            } else if (tipo == TipoAnimal.Elefante) {
                return new Elefante(nombre);
            } else if (tipo == TipoAnimal.Hiena) {
                return new Hiena(nombre);
            } else if (tipo == TipoAnimal.Hipopotamo) {
                return new Hipopotamo(nombre);
            } else if (tipo == TipoAnimal.Jirafa) {
                return new Jirafa(nombre);
            } else {
                return new Leon(nombre);
            }
        } else if(tipo.getHabitat() == TipoHabitat.Selva) {
            if (tipo == TipoAnimal.Pantera) {
                return new Pantera(nombre);
            } else if (tipo == TipoAnimal.Cocodrilo) {
                return new Cocodrilo(nombre);
            } else if (tipo == TipoAnimal.Loro) {
                return new Loro(nombre);
            } else if (tipo == TipoAnimal.Mono) {
                return new Mono(nombre);
            } else if (tipo == TipoAnimal.OsoHormiguero) {
                return new OsoHormiguero(nombre);
            } else {
                return new Serpiente(nombre);
            }
        } else if(tipo.getHabitat() == TipoHabitat.Acuario) {
            if (tipo == TipoAnimal.Ajolote) {
                return new Ajolote(nombre);
            } else if (tipo == TipoAnimal.Delfin) {
                return new Delfin(nombre);
            } else if (tipo == TipoAnimal.Orca) {
                return new Orca(nombre);
            } else if (tipo == TipoAnimal.LoboMarino) {
                return new LoboMarino(nombre);
            } else if (tipo == TipoAnimal.Tiburon) {
                return new Tiburon(nombre);
            } else {
                return new Tortuga(nombre);
            }
        } else if(tipo.getHabitat() == TipoHabitat.Desierto) {
            if (tipo == TipoAnimal.Avestruz) {
                return new Avestruz(nombre);
            } else if (tipo == TipoAnimal.Camello) {
                return new Camello(nombre);
            } else if (tipo == TipoAnimal.Canguro) {
                return new Canguro(nombre);
            } else if (tipo == TipoAnimal.Coyote) {
                return new Coyote(nombre);
            } else if (tipo == TipoAnimal.Lagarto) {
                return new Lagarto(nombre);
            } else {
                return new Suricata(nombre);
            }
        } else {
            if (tipo == TipoAnimal.Alce) {
                return new Alce(nombre);
            } else if (tipo == TipoAnimal.BuhoNival) {
                return new BuhoNival(nombre);
            } else if (tipo == TipoAnimal.Morsa) {
                return new Morsa(nombre);
            } else if (tipo == TipoAnimal.OsoPolar) {
                return new OsoPolar(nombre);
            } else if (tipo == TipoAnimal.Pinguino) {
                return new Pinguino(nombre);
            } else {
                return new ZorroArtico(nombre);
            }
        }
    }
}
