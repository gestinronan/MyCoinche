package com.rgestin.coinchecounter.exposed.dialog;

import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import com.rgestin.coinchecounter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.io.Serializable;

/**
 * Created by ronan GESTIN on 25/06/2016.
 */
@EFragment(R.layout.dialog_add_partie)
public class CreatePartieDialog extends DialogFragment {

    @ViewById(R.id.partie_name_dialog)
    TextInputLayout partieName;


    @ViewById(R.id.team1_name_dialog)
    TextInputLayout team1Name;


    @ViewById(R.id.team2_name_dialog)
    TextInputLayout team2Name;

    @FragmentArg
    OnConfirmPartieListener onConfirmPartieListener;


    @Click
    public void confirmButtonClicked() {
        EditText editPartieName = partieName.getEditText();
        EditText editTeam1Name = team1Name.getEditText();
        EditText editTeam2Name = team2Name.getEditText();


        if (editPartieName != null && editTeam1Name != null && editTeam2Name != null ) {

            String name = editPartieName.getText().toString();
            String team1name = editTeam1Name.getText().toString();
            String team2name = editTeam2Name.getText().toString();

            onConfirmPartieListener.partie(name, team1name, team2name);

        }
        dismiss();

    }

    @AfterViews
    void afterViews() {

    }

    public interface OnConfirmPartieListener extends Serializable{

        void partie(String name, String team1Name, String team2Name);
    }
}
