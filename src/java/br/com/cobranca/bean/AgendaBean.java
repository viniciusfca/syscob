/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cobranca.bean;

import br.com.cobranca.entity.Divida;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name="agendaMB")
@ViewScoped
public class AgendaBean {
     private List<Divida> dividas;
    private Divida divida;
    private Divida divida2;

    public AgendaBean() {
        this.divida = new Divida();
        this.divida2 = new Divida();
        this.dividas = new ArrayList<Divida>();

        listarDividas();
    }

    public void listarDividas() {

        divida.setDataCadstro(new Date());
        divida.setDataUltimaCobranca(new Date());
        divida.setDevedor("João Mané da Silva");
        divida.setStatus("A Negociar");
        divida.setValor(1500.00);
        divida.setId(1);
        divida.setProcedimento("Terceira Cobrança");
        divida.setBairro("Jardim Quebrada");
        divida.setCidade("Franca");
        divida.setCPF("444.444.444-44");
        divida.setEndereco("Rua Longe");
        divida.setTelefone("(16) 3701-0000");
        divida.setCelular("(16) 99999-9999");
        divida.setUf("SP");
        divida.setRg("44444123");
        

        dividas.add(divida);

        divida2.setDataCadstro(new Date());
        divida2.setDataUltimaCobranca(new Date());
        divida2.setDevedor("José Calote da Quebrada");
        divida2.setStatus("A Negociar");
        divida2.setValor(2500.00);
        divida2.setProcedimento("Segunda Cobrança");
        divida2.setId(2);
        divida2.setProcedimento("Terceira Cobrança");
        divida2.setBairro("Jardim Quebrada");
        divida2.setCidade("Franca");
        divida2.setCPF("444.444.444-44");
        divida2.setEndereco("Rua Longe");
        divida2.setTelefone("(16) 3701-0000");
        divida2.setCelular("(16) 99999-9999");
        divida2.setUf("SP");
        divida2.setRg("44444123");
        
        dividas.add(divida2);

    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }
    
    
}
