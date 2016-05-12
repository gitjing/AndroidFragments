package com.example.ljj.androidfragments.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ljj.androidfragments.ContentActivity;
import com.example.ljj.androidfragments.R;

import java.util.Arrays;
import java.util.List;

/**
 * 作者：ljj
 * 说明：首页加载的Fragment
 */
public class MainListFragment extends Fragment implements AdapterView.OnItemClickListener{
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private int mPosition;//纪录点击的position
    private ArrayAdapter<String> adapter;

    public static String TITLE = "title";
    private static  final int postRequest = 1;//requestCode
    private ListView listView;
    private List<String> mList = Arrays.asList("等夏天等秋天","等下个季节","要等到月亮变全","你才会回到我身边","要不要见面","没办法还是想念"
    ,"突然想看你的脸","熟悉的感觉","不，牵手也可以漫步风霜雨雪","不，能相见也能朝思暮念");

    public MainListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param param1 Parameter 1.
     * @return A new instance of fragment MainListFragment.
     */
    public static MainListFragment newInstance(String param1) {
        MainListFragment fragment = new MainListFragment();
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
        View view = inflater.inflate(R.layout.fragment_main_list, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        initView();
        return view;
    }

    private void initView() {
        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,mList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //跳转到ContentActivity-->在ContentFragment中修改完数据-->回传回来
        mPosition = position;
        Intent intent = new Intent(getActivity(),ContentActivity.class);
        intent.putExtra(TITLE,mList.get(position));
        startActivityForResult(intent,postRequest);//step one  -->startActivityForResult
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {//step three --> onActivityResult
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case postRequest:
                    String changTitle = data.getStringExtra(ChangeDialogFragment.CHANGE_TITLE);
                    mList.set(mPosition,changTitle);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
