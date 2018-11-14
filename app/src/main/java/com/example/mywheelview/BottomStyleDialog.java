package com.example.mywheelview;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.mywheelview.wheelview.WheelView;

import java.util.List;

import static com.example.mywheelview.wheelview.WheelView.WHEEL_LEFT;

/**
 * Created by SHENGFEI499 on 2018/5/7.
 */

public class BottomStyleDialog {

    public static void dialogShow(Context context, List<String> list,boolean isShow,int showPosition, final ResultEditListener listener) {

        final Dialog dialog = new Dialog(context, R.style.remind_dialog);

        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_type_one, null);
        final WheelView wheelView = view.findViewById(R.id.wheelview);
        wheelView.setWheelGravity(WHEEL_LEFT);
        wheelView.setItems(list, showPosition);

        TextView tvTxt=view.findViewById(R.id.tv_txt);
        if (isShow){
            tvTxt.setVisibility(View.VISIBLE);
        }else {
            tvTxt.setVisibility(View.GONE);
        }

        TextView tvFinish = view.findViewById(R.id.tv_finish);
        tvFinish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.SureListener(wheelView.getSelectedItem());
                            dialog.dismiss();
                        }
                    }
                });

        dialog.setContentView(view);
        dialog.show();

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.ActionSheetDialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    public interface ResultEditListener {
        void SureListener(String s);
    }

}