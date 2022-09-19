package Fabrica;

import Controladores.ControllerNaves;
import Interfaces.InterfaceNaves;

public class Fabrica {
    private static ControllerNaves controlador_naves;
    public static InterfaceNaves getINaves() {
        if (controlador_naves == null)
            controlador_naves = new ControllerNaves();
        return controlador_naves;
    }
}
