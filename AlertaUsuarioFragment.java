package es.pixelpro.david.eltiempo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by pixelpro on 24/9/17.
 */

public class AlertaUsuarioFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //El contexto de nuestro fragment, será el activity en el que se ejecuta
        Context contexto = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);

        builder.setTitle("Esto no va")
                .setMessage("Hay un error, reintentar?")
                .setPositiveButton("Vale", null);

        AlertDialog dialog = builder.create();
        return dialog;
    }
}
