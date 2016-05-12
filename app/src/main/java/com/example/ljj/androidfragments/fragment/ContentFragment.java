package com.example.ljj.androidfragments.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ljj.androidfragments.R;

/**
 * 作者：ljj
 * 说明：详情页面的Fragment
 */
public class ContentFragment extends Fragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "title";
    private String mParam1;


    private TextView textView;
    public static final int REQUEST_DIALOG = 0X110;
    public static final String CHANG_DIALOG = "chang_dialog";


    public ContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String param1) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setOnClickListener(this);
        textView.setText(mParam1);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_content:
                ChangeDialogFragment dialog = new ChangeDialogFragment();
                dialog.setTargetFragment(ContentFragment.this,REQUEST_DIALOG);//表示DialogFragment由ContentFragment调用
                dialog.show(getFragmentManager(),CHANG_DIALOG);

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DIALOG){
            getActivity().setResult(Activity.RESULT_OK,data);//step two --> setResult Fragment本身没有setResult方法,需要借助activity的
            getActivity().finish();
        }
    }
}
