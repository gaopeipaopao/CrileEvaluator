package com.example.gaope.cirleevaluator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Object类的估值器
 * Created by gaope on 2018/5/8.
 */

public class CrileView extends View {

    private PointF pointF;
    private Paint paint;
    private  PointF endPoint=new PointF(700,1000);


    public CrileView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (pointF == null){
            pointF = new PointF(70,70);
            canvas.drawCircle(pointF.x,pointF.y,70,paint);

            ValueAnimator valueAnimator = ValueAnimator.ofObject(new CrileEvaluator(pointF),pointF,endPoint);
            valueAnimator.setDuration(5000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    pointF = (PointF) animation.getAnimatedValue();
                    invalidate();
                }
            });
            valueAnimator.start();
        }
        else {
            canvas.drawCircle(pointF.x,pointF.y,70,paint);
        }

    }
}
