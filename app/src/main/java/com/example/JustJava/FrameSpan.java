package com.example.JustJava;

import static android.graphics.Color.WHITE;
import static com.example.Constant.RECKT;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/**
 *
 */
public class FrameSpan extends ReplacementSpan {
    private final Paint mPaint;
    private final String shape;
    private final int color;
    private int mWidth;

    public FrameSpan(int color, float v, String shape) {
        this.color = color;
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        //   mPaint.setColor(Color.BLUE);
        mPaint.setColor(color);
        mPaint.setStrokeWidth(v);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        this.shape = shape;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        //return text with relative to the Paint
        mWidth = (int) paint.measureText(text, start, end);
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        //draw the frame with custom Paint
        //  paint.setStyle(Paint.Style.STROKE);
        canvas.setDensity(10);
        //   paint.setLinearText(true);
        paint.setColor(WHITE);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0);
        if (shape.equals(RECKT)) {
            canvas.drawRect(x, top, x + mWidth, bottom, mPaint);
            canvas.drawText(String.valueOf(text), start, end, x, y, paint);
        } else if (shape.equals("oval")) {
            // Path path = new Path();
            //  path.moveTo(74, 268);
            //  path.cubicTo(start, end, x, top, 99, bottom);
            //    Paint mPaint = new Paint();
            //    mPaint.setColor(KASHMIRIGREEN);
            canvas.drawOval(x, top, x + mWidth, bottom, mPaint);
            //    mPaint.setColor(Color.BLUE);
            //   mPaint.setStrokeWidth(0);
            //     mPaint.setStyle(Paint.Style.FILL);
            //    mPaint.setTextSize(20);
            canvas.drawText(text, start, end, x, y, mPaint);

        } else {
            RectF rectf = new RectF(x, top, x + mWidth, bottom);
            canvas.drawArc(rectf, 0f, -180f, true, paint);
            canvas.drawText(String.valueOf(text), start, end, x, y, paint);

        }
        // paint.setColor(Color.WHITE);
        //paint.setStyle(Paint.Style.FILL);
        //  canvas.drawPaint(paint);
        // paint.setColor(Color.BLACK);
        //  TextPaint textPaint = new TextPaint();
        // textPaint.setAntiAlias(true);
        //  textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);
        // textPaint.setColor(0xFF000000);
        // int width = (int) textPaint.measureText(String.valueOf(text));
        // StaticLayout staticLayout = new StaticLayout(text, textPaint, (int) width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        // canvas.save();
        //  staticLayout.draw(canvas);
        //  canvas.drawText(String.valueOf(text), start, end, x, y, paint);
    }
}
