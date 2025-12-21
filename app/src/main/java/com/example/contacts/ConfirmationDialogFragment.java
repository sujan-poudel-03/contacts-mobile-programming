package com.example.contacts;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ConfirmationDialogFragment extends DialogFragment {

    // 1. Define the listener interface
    public interface ConfirmationDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    private ConfirmationDialogListener listener;

    // 2. Override onAttach to instantiate the listener
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Verify that the host fragment implements the callback interface
        try {
            // We need to get the parent fragment which is hosting this dialog
            listener = (ConfirmationDialogListener) getParentFragment();
        } catch (ClassCastException e) {
            // The fragment doesn't implement the interface, throw exception
            throw new ClassCastException(getParentFragment().toString()
                    + " must implement ConfirmationDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirmation")
                .setMessage("Are you sure you want to save?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 3. Send the positive button event back to the host fragment
                        listener.onDialogPositiveClick(ConfirmationDialogFragment.this);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dismiss();
                    }
                });
        return builder.create();
    }
}
