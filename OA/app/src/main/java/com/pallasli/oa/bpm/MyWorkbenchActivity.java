package com.pallasli.oa.bpm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.pallasli.oa.LoginActivity;
import com.pallasli.oa.R;

/**
 * Created by lyt1987 on 16/10/1.
 */
public class MyWorkbenchActivity extends FragmentActivity implements MyWorkbenchFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_workbench);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
