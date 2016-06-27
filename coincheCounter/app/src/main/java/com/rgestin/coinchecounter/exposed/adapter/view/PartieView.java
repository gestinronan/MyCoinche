package com.rgestin.coinchecounter.exposed.adapter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.connector.model.Partie;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
@EViewGroup(R.layout.view_partie)
public class PartieView extends LinearLayout{

    @ViewById(R.id.partie_name)
    TextView mPartieName;


    public PartieView(final Context context) {
        super(context);
    }

    public void bind(@NonNull final Partie partie) {
        mPartieName.setText(partie.getTitle());
    }
}
