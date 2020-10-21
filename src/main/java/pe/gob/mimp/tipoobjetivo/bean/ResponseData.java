/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Omar
 */
public class ResponseData<T> implements Serializable{

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("cod")
    private int cod;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("msg")
    private String msg;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("errors")
    private List<ResponseDataError> errors;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("resultado")
    private T resultado;

    public ResponseData() {

    }

    public ResponseData(String mensaje, int cod) {
        this.msg = mensaje;
        this.cod = cod;
        resultado = null;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResponseDataError> getErrors() {
        return errors;
    }

    public void setErrors(List<ResponseDataError> errors) {
        this.errors = errors;
    }

    public T getResultado() {
        return resultado;
    }

    public void setResultado(T resultado) {
        this.resultado = resultado;
    }

}
