package com.uiresource.cookit.utilidades;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by luisl on 1/9/2018.
 */

public class Util {
    //URL del Sitio Web primario de los WS para la aplicacion
    //http://siremo.cristiantimbi.info/miSiremo/faces/Plantilla_Principal/login.xhtml
   // public static final String URL_SRV = "http://192.168.43.78:8080/miSiremo/srv/";
   // public static final String URL_IMG = "http://192.168.43.78:8080/miSiremo/faces/Plantilla_Principal/";
    public static final String URL_SRV = "http://siremo.cristiantimbi.info/miSiremo/srv/";
    public static final String URL_IMG = "http://siremo.cristiantimbi.info/miSiremo/faces/Plantilla_Principal/";
    /**
     * Permite mostrar un mensaje Toast en pantalla,
     * @param id    ID de recurso String.xml
     */
    public static void showMensaje(Context context, int id){
        String mensaje = context.getResources().getString(id);
        Toast toast = Toast.makeText(context, mensaje, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Permite mostrar un mensaje Toast en pantalla,
     * @param mensaje    Texto del mensaje a mostrar
     */
    public static void showMensaje(Context context, String mensaje){
        Toast toast = Toast.makeText(context, mensaje, Toast.LENGTH_LONG);
        toast.show();
    }
}
