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
@EFragment(R.layout.dialog_add_score)
public class PartieScoreDialog extends DialogFragment {

    @ViewById(R.id.scoreTeam1)
    TextInputLayout scoreTeam1;

    @ViewById(R.id.scoreTeam2)
    TextInputLayout scoreTeam2;

    @FragmentArg
    OnConfirmScoreListener mOnConfirmScoreListener;


    @Click
    public void confirmButtonClicked() {
        EditText editTeam1 = scoreTeam1.getEditText();
        EditText editTeam2 = scoreTeam2.getEditText();
        if (editTeam2 != null && editTeam1 != null) {
            int score2 = Integer.parseInt(editTeam2.getText().toString());
            int score1 = Integer.parseInt(editTeam1.getText().toString());

            mOnConfirmScoreListener.socre(score1, score2);

        }
        dismiss();

    }

    @AfterViews
    void afterViews() {

    }

    public interface OnConfirmScoreListener extends Serializable{

        void socre(int team1, int team2);
    }
}
