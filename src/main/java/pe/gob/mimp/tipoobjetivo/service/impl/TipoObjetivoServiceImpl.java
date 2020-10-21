/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.TipoObjetivo;
import pe.gob.mimp.siscap.repository.tipoobjetivo.TipoObjetivoRepository;
import pe.gob.mimp.tipoobjetivo.bean.FindByParamBean;
import pe.gob.mimp.tipoobjetivo.bean.TipoObjetivoBean;
import pe.gob.mimp.tipoobjetivo.converter.TipoObjetivoCast;
import pe.gob.mimp.tipoobjetivo.util.Util;
import pe.gob.mimp.tipoobjetivo.service.TipoObjetivoService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoObjetivoServiceImpl implements TipoObjetivoService {

    @Autowired
    private TipoObjetivoRepository tipoObjetivoRepository;

    @Override
    public void crearTipoObjetivo(TipoObjetivoBean tipoObjetivoBean) throws Exception {

        TipoObjetivo tipoObjetivo = new TipoObjetivo();
        tipoObjetivo.setTxtTipoObjetivo(tipoObjetivoBean.getTxtTipoObjetivo());
        tipoObjetivo.setNidUsuario(tipoObjetivoBean.getNidUsuario());
        tipoObjetivo.setTxtPc(tipoObjetivoBean.getTxtPc());
        tipoObjetivo.setTxtIp(tipoObjetivoBean.getTxtIp());
        tipoObjetivo.setFecEdicion(tipoObjetivoBean.getFecEdicion());
        tipoObjetivo.setFlgActivo(tipoObjetivoBean.getFlgActivo());

        tipoObjetivoRepository.save(tipoObjetivo);

    }

    @Override
    public void editarTipoObjetivo(TipoObjetivoBean tipoObjetivoBean) {

        TipoObjetivo tipoObjetivo = new TipoObjetivo();

        tipoObjetivo.setNidTipoObjetivo(tipoObjetivoBean.getNidTipoObjetivo());
        tipoObjetivo.setTxtTipoObjetivo(tipoObjetivoBean.getTxtTipoObjetivo());
        tipoObjetivo.setNidUsuario(tipoObjetivoBean.getNidUsuario());
        tipoObjetivo.setTxtPc(tipoObjetivoBean.getTxtPc());
        tipoObjetivo.setTxtIp(tipoObjetivoBean.getTxtIp());
        tipoObjetivo.setFecEdicion(tipoObjetivoBean.getFecEdicion());
        tipoObjetivo.setFlgActivo(tipoObjetivoBean.getFlgActivo());

        tipoObjetivoRepository.saveAndFlush(tipoObjetivo);

    }

    @Override
    public String obtenerTipoObjetivoPorId(BigDecimal nidTipoObjetivo) throws Exception {

        Optional<TipoObjetivo> tipoObjetivo = tipoObjetivoRepository.findById(nidTipoObjetivo);

        if (tipoObjetivo.isPresent()) {
            return tipoObjetivo.get().getTxtTipoObjetivo();
        }

        return "";
    }

    @Override
    public List<TipoObjetivoBean> loadTipoObjetivoList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<TipoObjetivo> tipoObjetivoList = tipoObjetivoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(tipoObjetivoList)) {

            return tipoObjetivoList.stream().map(tipoObjetivo -> {
                TipoObjetivoBean tipoObjetivoBean = new TipoObjetivoBean();
                tipoObjetivoBean.setNidTipoObjetivo(tipoObjetivo.getNidTipoObjetivo());
                tipoObjetivoBean.setTxtTipoObjetivo(tipoObjetivo.getTxtTipoObjetivo());
                tipoObjetivoBean.setNidUsuario(tipoObjetivo.getNidUsuario());
                tipoObjetivoBean.setTxtPc(tipoObjetivo.getTxtPc());
                tipoObjetivoBean.setTxtIp(tipoObjetivo.getTxtIp());
                tipoObjetivoBean.setFecEdicion(tipoObjetivo.getFecEdicion());
                tipoObjetivoBean.setFlgActivo(tipoObjetivo.getFlgActivo());
                return tipoObjetivoBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = tipoObjetivoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public TipoObjetivoBean find(BigDecimal id) {

        Optional<TipoObjetivo> tipoObjetivo = tipoObjetivoRepository.findById(id);

        if (!tipoObjetivo.isPresent()) {
            return null;
        }

        return TipoObjetivoCast.castTipoObjetivoToTipoObjetivoBean(tipoObjetivo.get());

    }

}
