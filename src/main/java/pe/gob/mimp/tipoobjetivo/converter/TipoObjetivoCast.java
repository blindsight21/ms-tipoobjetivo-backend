/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.converter;

import pe.gob.mimp.siscap.model.TipoObjetivo;
import pe.gob.mimp.tipoobjetivo.bean.TipoObjetivoBean;

/**
 *
 * @author Omar
 */
public class TipoObjetivoCast {

    public static TipoObjetivoBean castTipoObjetivoToTipoObjetivoBean(TipoObjetivo tipoObjetivo) {

        if (tipoObjetivo == null) {
            return null;
        }

        TipoObjetivoBean tipoObjetivoBean = new TipoObjetivoBean();

        tipoObjetivoBean.setNidTipoObjetivo(tipoObjetivo.getNidTipoObjetivo());
        tipoObjetivoBean.setTxtTipoObjetivo(tipoObjetivo.getTxtTipoObjetivo());
        tipoObjetivoBean.setFlgActivo(tipoObjetivo.getFlgActivo());
        tipoObjetivoBean.setNidUsuario(tipoObjetivo.getNidUsuario());
        tipoObjetivoBean.setTxtPc(tipoObjetivo.getTxtPc());
        tipoObjetivoBean.setTxtIp(tipoObjetivo.getTxtIp());
        tipoObjetivoBean.setFecEdicion(tipoObjetivo.getFecEdicion());

        return tipoObjetivoBean;
    }

    public static TipoObjetivo castTipoObjetivoBeanToTipoObjetivo(TipoObjetivoBean tipoObjetivoBean) {

        if (tipoObjetivoBean == null) {
            return null;
        }

        TipoObjetivo tipoObjetivo = new TipoObjetivo();

        tipoObjetivo.setNidTipoObjetivo(tipoObjetivoBean.getNidTipoObjetivo());
        tipoObjetivo.setTxtTipoObjetivo(tipoObjetivoBean.getTxtTipoObjetivo());
        tipoObjetivo.setFlgActivo(tipoObjetivoBean.getFlgActivo());
        tipoObjetivo.setNidUsuario(tipoObjetivoBean.getNidUsuario());
        tipoObjetivo.setTxtPc(tipoObjetivoBean.getTxtPc());
        tipoObjetivo.setTxtIp(tipoObjetivoBean.getTxtIp());
        tipoObjetivo.setFecEdicion(tipoObjetivoBean.getFecEdicion());

        return tipoObjetivo;
    }
}
