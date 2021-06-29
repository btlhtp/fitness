package com.example.fitnessui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fitnessui.fragment.PopupFragment;

public class PopupActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.popup_activity);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.popup_activity_framelayout);

        if (fragment == null) {
            fragment = PopupFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.popup_activity_framelayout,fragment).commit();

        }

    }


    public static Intent newIntent(Context context, FitnessMove fitnessMove) {
        Intent intent = new Intent(context,PopupActivity.class);
        intent.putExtra("INFO",fitnessMove);
        return intent;
    }
}

