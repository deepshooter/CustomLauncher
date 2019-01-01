package deepshooter.com.customlauncher.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import deepshooter.com.customlauncher.R;


/**
 * Created by Jinesh on 11-04-2016.
 */
public class TextView extends android.widget.TextView {
    Context mContext;
    String str;
    //fonts
    public static Typeface Font_name;

    public TextView(Context context) throws FontNotFoundException {
        super(context);
        mContext=context;


        initialiseFont(null);
    }



    public TextView(Context context, AttributeSet attrs) throws FontNotFoundException {
        super(context, attrs);
        mContext=context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextView, 0, 0);
        try {
            str = ta.getString(R.styleable.TextView_font_family);

        } finally {
            ta.recycle();
        }
        initialiseFont(str);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) throws FontNotFoundException {
        super(context, attrs, defStyleAttr);
        mContext=context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextView, 0, 0);
        try {
            str = ta.getString(R.styleable.TextView_font_family);

        } finally {
            ta.recycle();
        }
        initialiseFont(str);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) throws FontNotFoundException {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext=context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextView, 0, 0);
        try {
            str = ta.getString(R.styleable.TextView_font_family);

        } finally {
            ta.recycle();
        }
        initialiseFont(str);
    }
    private void initialiseFont(String font) throws FontNotFoundException {
        if(font==null || font.equals("")){
          throw new FontNotFoundException("File not found on assests folder");
        }
        else {
            Font_name = Typeface.createFromAsset(mContext.getAssets(), font);
            setTypeface(Font_name);
        }

    }
    class FontNotFoundException extends Exception{
        public FontNotFoundException(String detailMessage) {
            super(detailMessage);
        }
    }
}
