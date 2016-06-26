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
public class NotFoundDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Hiç soru bulunamadı!")
                .setNeutralButton("Kapa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
