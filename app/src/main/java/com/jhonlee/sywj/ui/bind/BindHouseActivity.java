package com.jhonlee.sywj.ui.bind;


import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.lib.dialog.AlertDialog;
import com.jhonlee.lib.ioc.Bind;
import com.jhonlee.lib.ioc.Click;
import com.jhonlee.lib.network.LogUtil;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.mvp.ISuccessCityView;
import com.jhonlee.sywj.mvp.ISuccessView;
import com.jhonlee.sywj.pojo.City;
import com.jhonlee.sywj.pojo.Result;
import com.jhonlee.sywj.ui.ToolBar;

import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class BindHouseActivity extends BaseActivity implements ISuccessCityView {

    @Bind(R.id.tv_city)
    private TextView mTvCity;
    @Bind(R.id.tv_xq)
    private TextView mTvXQ;
    @Bind(R.id.tv_ld)
    private TextView mTvLD;
    @Bind(R.id.tv_dy)
    private TextView mTvDY;
    @Bind(R.id.tv_houes)
    private TextView mTvHoues;
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_bind_house);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initTitle() {
        new ToolBar.Builder(this).setTitle("房屋绑定").builder();
    }

    RadioButton[] button = new RadioButton[1];

    @Click({R.id.linear_city, R.id.linear_dy, R.id.linear_ld, R.id.linear_xq, R.id.linear_house})
    public void Click(View view) {
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setContentView(R.layout.choose_dialog)
                .create();
        RadioGroup radioGroup = dialog.getView(R.id.radio_group);

        switch (view.getId()) {
            case R.id.linear_city:
                createCity(radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        LogUtil.d("radiogroup", i + "");
                        button[0] = (RadioButton) radioGroup.findViewById(i);
                    }
                });
                dialog.setOnclickListener(R.id.tv_sure, new View.OnClickListener() {
                    public void onClick(View view) {
                        mTvCity.setText(button[0].getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.linear_dy:

                createDY(radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        LogUtil.d("radiogroup", i + "");
                        button[0] = (RadioButton) radioGroup.findViewById(i);
                    }
                });
                dialog.setOnclickListener(R.id.tv_sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTvDY.setText(button[0].getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.linear_ld:
                createLD(radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        LogUtil.d("radiogroup", i + "");
                        button[0] = (RadioButton) radioGroup.findViewById(i);
                    }
                });
                dialog.setOnclickListener(R.id.tv_sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTvLD.setText(button[0].getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.linear_xq:

                createXiaoqu(radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        LogUtil.d("radiogroup", i + "");
                        button[0] = (RadioButton) radioGroup.findViewById(i);
                    }
                });
                dialog.setOnclickListener(R.id.tv_sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTvXQ.setText(button[0].getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.linear_house:
                createHouse(radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        LogUtil.d("radiogroup", i + "");
                        button[0] = (RadioButton) radioGroup.findViewById(i);
                    }
                });
                dialog.setOnclickListener(R.id.tv_sure, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTvHoues.setText(button[0].getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
    @Click(R.id.bt_next)
    public void next(){
        startActivity(BindNextActivity.class);
    }

    private List<City> cities;
    private void createHouse(RadioGroup radioGroup) {
        radioGroup.removeAllViews();
        for (int i = 1; i <=10; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(i+"-"+i+"00"+i);
            button.setTextSize(22f);
            button.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
            button.setPadding(10, 10, 10, 10);
            radioGroup.addView(button);
        }
    }
    private void createDY(RadioGroup radioGroup) {
        radioGroup.removeAllViews();
        for (int i = 1; i <=5; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(i+"单元");
            button.setTextSize(22f);
            button.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
            button.setPadding(10, 10, 10, 10);
            radioGroup.addView(button);
        }
    }
    private void createLD(RadioGroup radioGroup) {
        radioGroup.removeAllViews();
        for (int i = 1; i <=10 ; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(i+"栋");
            button.setTextSize(22f);
            button.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
            button.setPadding(10, 10, 10, 10);
            radioGroup.addView(button);
        }
    }
    private void createCity(RadioGroup radioGroup) {
        radioGroup.removeAllViews();
        RadioButton button = new RadioButton(this);
        button.setText("成都市");
        button.setTextSize(22f);
        button.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button.setPadding(10, 10, 10, 10);
        radioGroup.addView(button);

        RadioButton button1 = new RadioButton(this);
        button1.setText("绵阳市");
        button1.setTextSize(22f);
        button1.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button1.setPadding(10, 10, 10, 10);
        radioGroup.addView(button1);

        RadioButton button2 = new RadioButton(this);
        button2.setText("都江堰");
        button2.setTextSize(22f);
        button2.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button2.setPadding(10, 10, 10, 10);
        radioGroup.addView(button2);

        RadioButton button3 = new RadioButton(this);
        button3.setText("广元市");
        button3.setTextSize(22f);
        button3.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button3.setPadding(10, 10, 10, 10);
        radioGroup.addView(button3);

        RadioButton button4 = new RadioButton(this);
        button4.setText("乐山市");
        button4.setTextSize(22f);
        button4.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button4.setPadding(10, 10, 10, 10);
        radioGroup.addView(button4);
    }

    private void createXiaoqu(RadioGroup radioGroup) {
        radioGroup.removeAllViews();
        RadioButton button = new RadioButton(this);
        button.setText("常乐小区");
        button.setTextSize(22f);
        button.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button.setPadding(10, 10, 10, 10);
        radioGroup.addView(button);

        RadioButton button1 = new RadioButton(this);
        button1.setText("蒂凡尼");
        button1.setTextSize(22f);
        button1.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button1.setPadding(10, 10, 10, 10);
        radioGroup.addView(button1);

        RadioButton button2 = new RadioButton(this);
        button2.setText("泛悦国际");
        button2.setTextSize(22f);
        button2.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button2.setPadding(10, 10, 10, 10);
        radioGroup.addView(button2);

        RadioButton button3 = new RadioButton(this);
        button3.setText("红英小区");
        button3.setTextSize(22f);
        button3.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button3.setPadding(10, 10, 10, 10);
        radioGroup.addView(button3);

        RadioButton button4 = new RadioButton(this);
        button4.setText("江源大厦");
        button4.setTextSize(22f);
        button4.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button4.setPadding(10, 10, 10, 10);
        radioGroup.addView(button4);

        RadioButton button5 = new RadioButton(this);
        button5.setText("美立方");
        button5.setTextSize(22f);
        button5.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        button5.setPadding(10, 10, 10, 10);
        radioGroup.addView(button5);
    }

    @Override
    public void onSuccess(List<City> results) {
        cities.clear();
        cities.addAll(results);
    }
}
