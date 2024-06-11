package Modelos;

import Modelos.Bosque.*;
import Modelos.Acuatico.*;

public class AnimalFactory {
    public Animal crearAnimal(TipoAnimal tipo, String nombre) {
        if(tipo.getHabitat() == TipoHabitat.Acuatico) {
            if (tipo == TipoAnimal.Delfin) {
                return new Delfin(nombre);
            } else if (tipo == TipoAnimal.Tiburon) {
                return new Tiburon(nombre);
            } else if (tipo == TipoAnimal.LoboMarino) {
                return new LoboMarino(nombre);
            } else if (tipo == TipoAnimal.Foca) {
                return new Foca(nombre);
            } else if (tipo == TipoAnimal.Coipo) {
                return new Coipo(nombre);
            } else {
                return new Tortuga(nombre);
            }
        }
        else {
            if (tipo == TipoAnimal.Oso) {
                return new Oso(nombre);
            } else if (tipo == TipoAnimal.Zorro) {
                return new Zorro(nombre);
            } else if (tipo == TipoAnimal.Carpintero) {
                return new Carpintero(nombre);
            } else if (tipo == TipoAnimal.Puma) {
                return new Puma(nombre);
            } else if (tipo == TipoAnimal.Huemul) {
                return new Huemul(nombre);
            } else {
                return new Pudu(nombre);
            }
        }
    }
}
