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
public class PartieScoreDialog extends DialogFragment {

    @ViewById(R.id.partie_name_dialog)
    TextInputLayout partieName;


    @FragmentArg
    OnConfirmPartieListener onConfirmPartieListener;


    @Click
    public void confirmButtonClicked() {
        EditText editTeam1 = partieName.getEditText();
        if (editTeam1 != null) {

            String name = editTeam1.getText().toString();

            onConfirmPartieListener.partie(name);

        }
        dismiss();

    }

    @AfterViews
    void afterViews() {

    }

    public interface OnConfirmPartieListener extends Serializable{

        void partie(String name);
    }
}
