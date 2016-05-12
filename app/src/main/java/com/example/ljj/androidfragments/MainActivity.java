package com.example.ljj.androidfragments;

import android.support.v4.app.Fragment;

import com.example.ljj.androidfragments.fragment.MainListFragment;

/**
 * @author ljj
 */
public class MainActivity extends SingleFragmentActivity {

    private MainListFragment mainListFragment;

    @Override
    protected Fragment createFragment() {
        mainListFragment = new MainListFragment();
        return mainListFragment;
    }
}
