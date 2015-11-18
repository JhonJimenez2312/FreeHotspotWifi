package FHW;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Enumeration;
import javax.swing.UIManager;

/**
 *
 * @author Jota31337
 */
public class FHWMethods {

    static Thread hilo;
    static Thread hilo2;

    public static void look() {
        try {

            UIManager.setLookAndFeel(new HiFiLookAndFeel());

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }

    }

    public static void comandos(String nombreRed, String clave, JTextArea txtAreaSalida) {

        Runtime cmd = Runtime.getRuntime();

        try {
            if (nombreRed.equalsIgnoreCase("")) {
                nombreRed = "Default";
            }
            if (clave.equalsIgnoreCase("")) {
                clave = "clave1234";
            }
            validarEstadoAdaptador(txtAreaSalida, nombreRed, clave);
            Process proceso = cmd.exec("netsh wlan set hostednetwork mode=allow " + "ssid=" + nombreRed + " key=" + clave);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Algo ha fallado " + ex.getMessage());
        }

    }

    public static void activarRed(JTextArea txtAreaSalida) {

        try {
            Runtime cmd = Runtime.getRuntime();
            Process p = cmd.exec("netsh wlan start hostednetwork");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Algo ha fallado activando la red " + ex.getMessage());
        }

    }

    public static void iniciarRed(String nombreRed, String clave, JTextArea txtAreaSalida) {
        hilo2 = new Thread(new Runnable() {

            @Override
            public void run() {
                comandos(nombreRed, clave, txtAreaSalida);
                activarRed(txtAreaSalida);

                try {
                    //se llama 2 veces a este metodo con el fin de que se inicie satisfactoriamente el nombre de la red
                    hilo2.sleep(2000);
                    comandos(nombreRed, clave, txtAreaSalida);
                    activarRed(txtAreaSalida);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN INICIAR RED \n" + e.getMessage());
                }
            }
        });
        hilo2.start();

    }

    public static boolean estaActivoElMicrosoftHostedNetworkVirtualAdapter(JTextArea txtAreaSalida) {

        boolean r = false;

        try {
            // obtener las interfaces de red
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();

            while (interfaceList.hasMoreElements()) {

                NetworkInterface iface = interfaceList.nextElement();

                if (iface.isUp()) {

                    if (iface.getDisplayName().equalsIgnoreCase("Microsoft Hosted Network Virtual Adapter")
                            || iface.getDisplayName().equalsIgnoreCase("Microsoft Virtual WiFi Miniport Adapter")) {
                        r = true;
                    }

                } /*else {
                 // ver los adaptadores de red inactivos 
                 //  System.out.println("INACTIVO " + iface.getName() + " - " + iface.getDisplayName() + " Pos: " + iface.getIndex());

                 }*/

            }
        } catch (SocketException ex) {
            System.out.println(" ocurrio un error es el metodo estaActivoElMicrosoftHostedNetworkVirtualAdapter()");
        }
        return r;

    }

    public static void validarEstadoAdaptador(JTextArea txtAreaSalida, String nombreRed, String clave) {
        hilo = new Thread(new Runnable() {

            @Override
            public void run() {

                while (estaActivoElMicrosoftHostedNetworkVirtualAdapter(txtAreaSalida) == false) {

                    try {
                        String s = "ERROR: El adaptador no esta Habilitado¡...\n" + "Para Habilitarlo siga los pasos de Habilitacion del adaptador virtual y configuracion del uso compartido:\n".toUpperCase()
                                + "\n"
                                + "*)HABILITACION DEL ADAPTADOR VIRTUAL: \n\n"
                                + "  1) Presione el boton Habilitar adaptador, espere a que inicie el administrador de dispositivos.\n"
                                + "  2) Dirigirse a la pestaña ver y seleccionar mostrar dispositivos ocultos.\n"
                                + "  3) Luego en adaptadores de red hacer click derecho sobre Microsoft Hosted Network Virtual Adapter o Microsoft Virtual WiFi Miniport Adapter.\n"
                                + "  4) Click en Habilitar luego cierre la ventana del administrador de dispositivos.\n"
                                + "  5) En esta aplicacion haga click en Iniciar Red Virtual (para esto no es necesario llenar los campos de nombre de red o contraseña).\n"
                                + "\n*)CONFIGURACION DEL USO COMPARTIDO: \n\n"
                                + "  1) En esta aplicacion Haga click en el boton Administrar Adaptadores de Red.\n"
                                + "  2) Click derecho sobre su adaptador del que obtiene internet via Wi-Fi.\n"
                                + "  3) Seleccione propiedades y dirijase a la pestaña uso compartido.\n"
                                + "  4) Marque la primera casilla y seleccione en la opcion conexion de red domestica la opcion conexion de area local.\n"
                                + "  5) Haga click en aceptar y cierre la ventana.\n"
                                + "  6) En esta aplicacion llene los campos Nombre de la red y Clave de la red deseados (No es Obligatorio).\n"
                                + "  7) Luego haga click en Iniciar Red Virtual.\n";

                        if (txtAreaSalida.getText().equalsIgnoreCase(s) == true) {

                        } else {
                            txtAreaSalida.setText("");
                            txtAreaSalida.append(s);
                        }

                    } catch (Exception e) {
                        System.out.println("error en validar estado adaptador");
                    }
                }
                txtAreaSalida.setText("");
                // en este punto el adaptador debe estar activado
                txtAreaSalida.append("Se Habilito satisfactoriamente el adaptador virtual \n");
                txtAreaSalida.append("Nombre red: " + nombreRed + "\nClave: " + clave + "\n");
                txtAreaSalida.append("\nNOTA:\nSi su adaptador esta habilitado pero no esta configurado para compartir internet siga estos pasos:\n \n".toUpperCase());
                txtAreaSalida.append("*)CONFIGURACION DEL USO COMPARTIDO: \n"
                        + "  1) En esta aplicacion Haga click en el boton Administrar Adaptadores de Red.\n"
                        + "  2) Click derecho sobre su adaptador del que obtiene internet via Wi-Fi.\n"
                        + "  3) Seleccione propiedades y dirijase a la pestaña uso compartido.\n"
                        + "  4) Marque la primera casilla y seleccione en la opcion conexion de red domestica la opcion conexion de area local.\n"
                        + "  5) Haga click en aceptar y cierre la ventana.\n"
                        + "  6) En esta aplicacion llene los campos Nombre de la red y Clave de la red deseados (No es Obligatorio).\n"
                        + "  7) Luego haga click en Iniciar Red Virtual.\n");
            }
        });
        hilo.start();
    }

    public static void habilitarAdaptador(JTextArea txtAreaSalida) {
        if (estaActivoElMicrosoftHostedNetworkVirtualAdapter(txtAreaSalida) == false) {
            txtAreaSalida.setText("");
            txtAreaSalida.append("Para Habilitarlo siga estos pasos:\n"
                    + "\n"
                    + "1)Presione el boton Habilitar adaptador.\n"
                    + "2)Dirigirse a la pestaña ver y seleccionar mostrar dispositivos ocultos.\n"
                    + "3)Luego en adaptadores de red hacer click derecho sobre Microsoft Hosted Network Virtual Adapter.\n"
                    + "4)Click en Habilitar luego cierre la ventana del administrador de dispositivos.\n"
                    + "5)En esta aplicacion Haga click en el boton Administrar Adaptadores de Red.\n"
                    + "6)Click derecho sobre su adaptador del que obtiene internet via Wi-Fi.\n"
                    + "7)seleccione propiedades y dirijase a la pestaña uso compartido.\n"
                    + "8)Marque la primera casilla y seleccione en la opcion conexion de red domestica la opcion conexion de area local.\n"
                    + "9)Click en aceptar y cierre la ventana.\n"
                    + "10)Haga click en esta aplicacion en el boton Iniciar Red Virtual.\n");

            String cmd = "cmd /c DEVMGMT.MSC";
            try {

                Runtime.getRuntime().exec(cmd);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR: Algo ha fallado habilitando el adaptador " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El adaptador se encuentra habilitado");

        }
    }


    public static void compartir() {

        String cmd = "cmd /c Ncpa.cpl";
        try {

            Runtime.getRuntime().exec(cmd);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Lo sentimos Algo ha fallado  " + ex.getMessage());
        }

    }

    public static boolean validarSistemaOperativo(JTextArea TA) {
        boolean continuar = false;
        String OS = System.getProperty("os.name");
        try {
            if (OS.substring(0, 5).equalsIgnoreCase("Windo") == true) {
                //esta en windows
                continuar = true;
            } else {
                TA.setText("");
                TA.append("Lo sentimos esta aplicacion solo es valida para Windows y usted esta usando " + OS);
                JOptionPane.showMessageDialog(null, "Lo sentimos esta aplicacion solo es valida para Windows y usted esta usando " + OS, "Failure", JOptionPane.ERROR_MESSAGE);
                continuar = false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos esta aplicacion solo es valida para Windows y usted esta usando " + OS, "Failure", JOptionPane.ERROR_MESSAGE);
            continuar = false;
        }

        return continuar;
    }

}
