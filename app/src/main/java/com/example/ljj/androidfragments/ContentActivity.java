package com.example.ljj.androidfragments;

import android.support.v4.app.Fragment;

import com.example.ljj.androidfragments.fragment.ContentFragment;
import com.example.ljj.androidfragments.fragment.MainListFragment;

/**
 *
 */
public class ContentActivity extends SingleFragmentActivity {

    private String title;
    private ContentFragment contentFragment;

    @Override
    protected Fragment createFragment() {
        title = getIntent().getStringExtra(MainListFragment.TITLE);
        contentFragment = ContentFragment.newInstance(title);
        return contentFragment;
    }
}
