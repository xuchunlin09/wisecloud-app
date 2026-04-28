package com.wisecloud.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.wisecloud.app.R;

/**
 * Custom 3-step progress indicator view for wizard flows.
 *
 * - Current step is highlighted with primary color
 * - Completed steps show a green checkmark
 * - Future steps are shown in grey
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0007J\u0014\u0010\'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/wisecloud/app/widget/StepIndicatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checkPaint", "Landroid/graphics/Paint;", "circlePaint", "circleRadius", "", "completedColor", "currentStep", "inactiveColor", "linePaint", "numberPaint", "primaryColor", "stepLabels", "", "", "subtextColor", "textColor", "textPaint", "whiteColor", "dpToPx", "dp", "getCurrentStep", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCurrentStep", "step", "setSteps", "labels", "spToPx", "sp", "app_debug"})
public final class StepIndicatorView extends android.view.View {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> stepLabels;
    private int currentStep = 0;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint circlePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint linePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint textPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint checkPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint numberPaint = null;
    private final float circleRadius = 0.0F;
    private final int primaryColor = 0;
    private final int completedColor = 0;
    private final int inactiveColor = 0;
    private final int whiteColor = -1;
    private final int textColor = -13421773;
    private final int subtextColor = -6710887;
    
    @kotlin.jvm.JvmOverloads()
    public StepIndicatorView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> labels) {
    }
    
    public final void setCurrentStep(int step) {
    }
    
    public final int getCurrentStep() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    private final float dpToPx(float dp) {
        return 0.0F;
    }
    
    private final float spToPx(float sp) {
        return 0.0F;
    }
    
    @kotlin.jvm.JvmOverloads()
    public StepIndicatorView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public StepIndicatorView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
}