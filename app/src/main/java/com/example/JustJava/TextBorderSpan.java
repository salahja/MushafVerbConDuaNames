package com.example.JustJava;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.LineBackgroundSpan;

public class TextBorderSpan implements LineBackgroundSpan {
    private Path mPath;
    private int mWidth;

    private int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        //return text with relative to the Paint
        mWidth = (int) paint.measureText(text, start, end);
        return mWidth;
    }

    @Override
    public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline, int bottom, CharSequence charSequence, int start, int end, int lnum) {
        if (mPath == null) {
            mPath = new Path();
            mPath.setLastPoint(left, top);
            mPath.lineTo(right, top);
            mPath.lineTo(right, bottom);
            mPath.lineTo(left, bottom);
            mPath.lineTo(left, top);
        }
        Paint.Style oldStyle = paint.getStyle();
        float oldStroke = paint.getStrokeWidth();
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(mPath, paint);
        paint.setStrokeWidth(oldStroke);
        paint.setStyle(oldStyle);
    }
}