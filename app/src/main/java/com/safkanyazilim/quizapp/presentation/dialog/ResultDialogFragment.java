package com.safkanyazilim.quizapp.presentation.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.safkanyazilim.quizapp.presentation.MainActivity;

/**
 * Created by elif on 25.06.2016.
 */
public class ResultDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Doğru!")
                .setPositiveButton("Sonraki Soru", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Go back to activity
                    }
                })
                .setNegativeButton("Bitir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Activity currentActivity = getActivity();
                        Intent intent = new Intent(currentActivity, MainActivity.class);
                        currentActivity.finish();
                        startActivity(intent);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
