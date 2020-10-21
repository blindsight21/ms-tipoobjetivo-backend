/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.util;

import java.util.List;

/**
 *
 * @author Omar
 */
public class Util {

    public static boolean esListaVacia(List<?> lista) {
        return lista == null || lista.isEmpty();
    }

}
