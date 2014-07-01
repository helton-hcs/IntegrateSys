/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unesp.rc.integratesys.ambiente;

import br.unesp.rc.integratesys.atuadores.Atuadores;
import br.unesp.rc.integratesys.atuadores.Nivel;
import br.unesp.rc.integratesys.library.IntegrateSysLibraryLoader;
import br.unesp.rc.integratesys.sensores.Sensores;
import br.unesp.rc.integratesys.utils.AgendadorTarefas;
import br.unesp.rc.integratesys.utils.SimuladorCondicoesMeteorologicas;
import br.unesp.rc.integratesys.utils.Varredor;

/**
 *
 * @author Helton
 */
public class Ambiente {
    
    private final Atuadores atuadores;
    private final Sensores sensores;
    private final AgendadorTarefas agendadorTarefas;
    private final Parametros parametros;
    private final SimuladorCondicoesMeteorologicas simulador;
    
    public Ambiente() {
        parametros = new Parametros();
        agendadorTarefas = new AgendadorTarefas();        
        sensores = new Sensores();
        atuadores = new Atuadores(sensores, agendadorTarefas);
        simulador = new SimuladorCondicoesMeteorologicas(agendadorTarefas);
        configuraCondicoesIniciais();
    }
    
    private void configuraCondicoesIniciais() {
        //apenas os valores iniciais dos sensores são disponibilizados
        IntegrateSysLibraryLoader.getLibrary().setLuminosidade(parametros.getLuminosidadeInicial());
        IntegrateSysLibraryLoader.getLibrary().setTemperatura(parametros.getTemperaturaInicial());        
        IntegrateSysLibraryLoader.getLibrary().setUmidade(parametros.getUmidadeInicial());                
        //todos os atuadores ficam desligados por padrão
        IntegrateSysLibraryLoader.getLibrary().setNivelAquecedor(Nivel.DESLIGADO.getValor());
        IntegrateSysLibraryLoader.getLibrary().setNivelLampada(Nivel.DESLIGADO.getValor());
        IntegrateSysLibraryLoader.getLibrary().setNivelUmidificador(Nivel.DESLIGADO.getValor());
        IntegrateSysLibraryLoader.getLibrary().setNivelVentilador(Nivel.DESLIGADO.getValor());        
    }

    /**
     * @return the atuadores
     */
    public Atuadores getAtuadores() {
        return atuadores;
    }

    /**
     * @return the sensores
     */
    public Sensores getSensores() {
        return sensores;
    }

    /**
     * @return the parametros
     */
    public Parametros getParametros() {
        return parametros;
    }

    /**
     * @return the agendadorTarefas
     */
    public AgendadorTarefas getAgendadorTarefas() {
        return agendadorTarefas;
    }

    /**
     * @return the simulador
     */
    public SimuladorCondicoesMeteorologicas getSimulador() {
        return simulador;
    }
   
}