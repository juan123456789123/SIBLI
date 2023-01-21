/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.modelo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Usuario
 */
class MyStream extends ObjectOutputStream{
    

    public MyStream(OutputStream oos) throws IOException {
        super(oos);
    }
    @Override
    protected void writeStreamHeader()throws IOException{
    
    }
    
}
