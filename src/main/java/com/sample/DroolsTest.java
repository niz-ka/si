package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.JDialog;
import java.awt.*;
import java.awt.event.*;

public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	// Create global frame
        	JDialog frame = new JDialog();
        	frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        	
        	// Close application after frame close
        	frame.addWindowListener(new WindowAdapter() { 
        		@Override public void windowClosing(WindowEvent e) { 
        			System.exit(0);
        		}
        	});
        	
        	kSession.setGlobal("frame", frame);
        	
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    

}
