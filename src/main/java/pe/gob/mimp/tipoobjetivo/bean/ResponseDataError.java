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

/**
 *
 * @author Omar
 */
public class ResponseDataError implements Serializable{

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("cod")
    private String cod;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("msg")
    private String msg;

    public ResponseDataError() {

    }

    public ResponseDataError(String cod, String msg) {
        this.cod = cod;
        this.msg = msg;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
