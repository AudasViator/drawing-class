package ru.yandex.yamblz.ui.android_views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import ru.yandex.yamblz.R;

public class CanvasView extends AbsCanvasView {
    private final RectF RECT_F1 = new RectF(1, 1, 6, 6);
    private final RectF RECT_F2 = new RectF(2, 2, 3, 3);
    private final RectF RECT_F3 = new RectF(4, 2, 5, 3);
    private final RectF RECT_F4 = new RectF(2, 3, 5, 5);
    private final RectF RECT_F5 = new RectF(5.75f, 4.75f, 12f, 6.5f);

    private float leftLeg = 6.0f;
    private float rightLeg = 6.5f;
    private float mBottomGlass = 0.0f;

    private final RectF mRectForGlass = new RectF(1f, mBottomGlass - 4.2f, 6f, mBottomGlass);

    private final Bitmap glass = BitmapFactory.decodeResource(getResources(), R.drawable.deal);
    private final Paint mPaint = new Paint();

    private boolean firstPass = false;

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(0xFFCC00CC);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(0.2f);

        // Секретный алгоритм с обфускацией
        canvas.drawOval(RECT_F1, mPaint);
        canvas.drawLine(1, 3, 1, 1, mPaint);
        canvas.drawLine(1, 1, 2, 1.5f, mPaint);
        canvas.drawLine(5, 1.5f, 6, 1, mPaint);
        canvas.drawLine(6, 1, 6, 3, mPaint);

        canvas.drawOval(RECT_F2, mPaint);
        canvas.drawOval(RECT_F3, mPaint);
        canvas.drawPoint(2.5f, 2.5f, mPaint);
        canvas.drawPoint(4.5f, 2.5f, mPaint);

        mPaint.setStrokeWidth(0.1f);
        canvas.drawLine(0.0f, 4.0f, 2.0f, 4.0f, mPaint);
        canvas.drawLine(0.0f, 4.5f, 2.0f, 4.0f, mPaint);
        canvas.drawLine(0.0f, 5.0f, 2.0f, 4.0f, mPaint);

        canvas.drawLine(5.5f, 3.5f, 8.0f, 2.5f, mPaint);
        canvas.drawLine(5.5f, 3.5f, 8.0f, 3.0f, mPaint);
        canvas.drawLine(5.5f, 3.5f, 8.0f, 3.5f, mPaint);
        mPaint.setStrokeWidth(0.2f);

        canvas.drawArc(RECT_F4, -20, 150, false, mPaint);

        canvas.drawLine(5.25f, 5.25f, 5.85f, 5.5f, mPaint);
        canvas.drawLine(4.8f, 5.55f, 6f, 6.0f, mPaint);
        canvas.drawOval(RECT_F5, mPaint);

        canvas.drawLine(7.0f, 6.25f, rightLeg, 9.0f, mPaint);
        canvas.drawLine(7.0f, 6.25f, leftLeg, 9.0f, mPaint);

        if (firstPass) {
            rightLeg -= 0.05f;
            leftLeg += 0.05f;
            if (rightLeg < 5.0f) {
                firstPass = false;
            }
        } else {
            rightLeg += 0.05f;
            leftLeg -= 0.05f;
            if (rightLeg > 8.0f) {
                firstPass = true;
            }
        }

        if (mBottomGlass < 4.7f) {
            mBottomGlass += 0.04f;
        }

        mRectForGlass.top = mBottomGlass - 4.2f;
        mRectForGlass.bottom = mBottomGlass;

        canvas.drawBitmap(glass, null, mRectForGlass, null);
        postInvalidateDelayed(50);
    }
}
