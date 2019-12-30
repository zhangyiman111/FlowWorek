package com.bawei.myapplication.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myapplication.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeacondActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.btn_qr_scan)
    Button btnQrScan;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seacond);
        ButterKnife.bind(this);
        CodeUtils.init(this);
        //长按点击识别二维码图片
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(iv, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SeacondActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SeacondActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }


    @OnClick({R.id.tv, R.id.btn_qr_scan, R.id.btn_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                //根据文字生成二维码
                String s = tv.getText().toString().trim();
                if (!TextUtils.isEmpty(s)) {
                    Bitmap image = CodeUtils.createImage(s, 400, 400, null);
                    iv.setImageBitmap(image);
                }
                break;
            case R.id.btn_qr_scan:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.btn_1:
                CodeUtils.analyzeByPhotos(this);
                break;
        }
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        EventBus.getDefault().post("11111111");
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onGetString(String string){
        Toast.makeText(this, "接收成功"+string, Toast.LENGTH_SHORT).show();
    }
}
