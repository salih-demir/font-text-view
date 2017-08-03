package com.cascade.fonttextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Salih Demir on 3.04.2017.
 */

public class FontTextView extends AppCompatTextView {
    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initializeTypeface(context, attrs);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initializeTypeface(context, attrs);
    }

    private void initializeTypeface(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);

        if (typedArray != null) {
            String fontPathInAssets = typedArray.getString(R.styleable.FontTextView_fontPathInAssets);

            if (fontPathInAssets != null) {
                Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontPathInAssets);
                setTypeface(typeface);
            }
            typedArray.recycle();
        }
    }
}