package com.example.gaope.cirleevaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by gaope on 2018/5/8.
 */

public class CrileEvaluator implements TypeEvaluator {

    private  PointF pointF;

    CrileEvaluator(PointF pointF){
        this.pointF = pointF;
    }

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        PointF start = (PointF)startValue;
        PointF end = (PointF)endValue;
        pointF.x = start.x + fraction * (end.x - pointF.x);
        pointF.y = start.y + fraction * (end.y - pointF.y);
        return pointF;
    }
}
