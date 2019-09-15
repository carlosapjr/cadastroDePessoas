/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Alberto
 */
@WebService(serviceName = "Source")
@Stateless()
public class Source {

    /**
     * This is a sample web service operation
     * @return the source code at github
     */
    @WebMethod(operationName = "getSource")
    public String getSource() {
        return "https://github.com/carlosapjr/cadastroDePessoas";
    }
}
