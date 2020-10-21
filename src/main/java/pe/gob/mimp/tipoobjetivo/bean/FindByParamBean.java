/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipoobjetivo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Omar
 */
public class FindByParamBean implements Serializable{
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> parameters;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderBy;

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    
}
