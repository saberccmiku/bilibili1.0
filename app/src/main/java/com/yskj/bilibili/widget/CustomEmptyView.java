package com.yskj.bilibili.widget;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.yskj.bilibili.R;

public class CustomEmptyView extends FrameLayout {

    private ImageView mEmptyImg;
    private TextView mEmptyText;

    public CustomEmptyView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomEmptyView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CustomEmptyView(@NonNull Context context) {
        super(context, null);
    }

    public void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty, this);
        mEmptyImg = (ImageView) view.findViewById(R.id.empty_img);
        mEmptyText = (TextView) view.findViewById(R.id.empty_text);
    }

    public void setEmptyImage(int imgRes) {
        mEmptyImg.setImageResource(imgRes);
    }

    public void setEmptyText(String text) {
        mEmptyText.setText(text);
    }
}

