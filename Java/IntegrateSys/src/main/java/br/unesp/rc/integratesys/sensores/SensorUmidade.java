/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unesp.rc.integratesys.sensores;

import br.unesp.rc.integratesys.library.IntegrateSysLibraryLoader;

/**
 *
 * @author Helton
 */
public class SensorUmidade extends Sensor {
    
    public int getUmidade() {
        return IntegrateSysLibraryLoader.getLibrary().getUmidade();
    }    
    
}
