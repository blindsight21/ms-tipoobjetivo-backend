/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.tipoobjetivo.bean.FindByParamBean;

import pe.gob.mimp.tipoobjetivo.bean.ResponseData;
import pe.gob.mimp.tipoobjetivo.bean.TipoObjetivoBean;
import pe.gob.mimp.tipoobjetivo.service.TipoObjetivoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class TipoObjetivoController {

    @Autowired
    private TipoObjetivoService tipoObjetivoService;

    @PostMapping(value = "/crearTipoObjetivo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTipoObjetivo(@RequestBody TipoObjetivoBean tipoObjetivoBean) throws Exception {

        tipoObjetivoService.crearTipoObjetivo(tipoObjetivoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTipoObjetivo", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTipoObjetivo(@RequestBody TipoObjetivoBean tipoObjetivoBean) throws Exception {

        tipoObjetivoService.editarTipoObjetivo(tipoObjetivoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerTipoObjetivoPorId/{nidTipoObjetivo}")
    public ResponseEntity<ResponseData<?>> obtenerTipoObjetivoPorId(@PathVariable("nidTipoObjetivo") BigDecimal nidTipoObjetivo) throws Exception {

        String txtTipoObjetivo = tipoObjetivoService.obtenerTipoObjetivoPorId(nidTipoObjetivo);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtTipoObjetivo);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadTipoObjetivoList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadTipoObjetivoList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<TipoObjetivoBean> tipoObjetivoList = tipoObjetivoService.loadTipoObjetivoList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoObjetivoList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = tipoObjetivoService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TipoObjetivoBean tipoObjetivoBean = tipoObjetivoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoObjetivoBean);

        return ResponseEntity.ok(response);

    }

}
