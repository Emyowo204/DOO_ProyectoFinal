package Modelos.Utils;

import Modelos.Bosque.*;
import Modelos.Acuatico.*;
import Modelos.Enumeration.*;
import Modelos.Sabana.*;

public class AnimalFactory {
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
            } else if (tipo == TipoAnimal.Hienas) {
                return new Hienas(nombre);
            } else if (tipo == TipoAnimal.Hipopotamo) {
                return new Hipopotamo(nombre);
            } else if (tipo == TipoAnimal.Jirafa) {
                return new Jirafa(nombre);
            } else {
                return new Leon(nombre);
            }
        } else {
            if (tipo == TipoAnimal.Coipo) {
                return new Coipo(nombre);
            } else if (tipo == TipoAnimal.Delfin) {
                return new Delfin(nombre);
            } else if (tipo == TipoAnimal.Foca) {
                return new Foca(nombre);
            } else if (tipo == TipoAnimal.LoboMarino) {
                return new LoboMarino(nombre);
            } else if (tipo == TipoAnimal.Tiburon) {
                return new Tiburon(nombre);
            } else {
                return new Tortuga(nombre);
            }
        }
    }
}
