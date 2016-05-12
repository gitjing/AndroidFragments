package com.example.ljj.androidfragments.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ljj.androidfragments.R;

/**
 * 作者：ljj
 * 日期：2016/5/12 16:28
 * 说明：DialogFragment 类似Dialog展示
 */
public class ChangeDialogFragment extends DialogFragment implements View.OnClickListener {

    private EditText editText;
    private Button button;
    public static final String CHANGE_TITLE = "change_title";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.layout_dialog, container,false);
        editText = (EditText) view.findViewById(R.id.edit_change);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (getTargetFragment() == null)
            return;

        String changText = editText.getText().toString();
        if (!TextUtils.isEmpty(changText)) {
            Intent intent = new Intent();
            intent.putExtra(CHANGE_TITLE, changText);
            getTargetFragment().onActivityResult(ContentFragment.REQUEST_DIALOG, Activity.RESULT_OK, intent);//根据TargetFragment回传值
        } else {
            Toast.makeText(getActivity(), "请输入修改内容", Toast.LENGTH_SHORT).show();
        }
    }


//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return super.onCreateDialog(savedInstanceState);
//    }
}
