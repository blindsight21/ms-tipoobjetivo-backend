/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.tipoobjetivo.bean.FindByParamBean;
import pe.gob.mimp.tipoobjetivo.bean.TipoObjetivoBean;

/**
 *
 * @author Omar
 */
public interface TipoObjetivoService {

    void crearTipoObjetivo(TipoObjetivoBean tipoObjetivoBean) throws Exception;

    void editarTipoObjetivo(TipoObjetivoBean tipoObjetivoBean) throws Exception;

//    void anularTipoObjetivo(TipoObjetivoBean tipoObjetivoBean) throws Exception;
    String obtenerTipoObjetivoPorId(BigDecimal nidTipoObjetivo) throws Exception;

    List<TipoObjetivoBean> loadTipoObjetivoList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    TipoObjetivoBean find(BigDecimal id);
}
