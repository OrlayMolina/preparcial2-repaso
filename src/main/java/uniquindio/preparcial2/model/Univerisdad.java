package uniquindio.preparcial2.model;

import java.util.ResourceBundle;

public class Univerisdad {

    public String modalidadUnoProperties(){
        ResourceBundle resourceBundle;

        resourceBundle = ResourceBundle.getBundle("Universidad");
        String modalidad1 = resourceBundle.getString("modalidad.uno");
        return modalidad1;

    }

    public String modalidadDosProperties(){
        ResourceBundle resourceBundle;

        resourceBundle = ResourceBundle.getBundle("Universidad");
        String modalidad2 = resourceBundle.getString("modalidad.dos");
        return modalidad2;

    }
}
