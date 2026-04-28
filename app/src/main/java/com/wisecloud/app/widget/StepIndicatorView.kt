package com.wisecloud.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.wisecloud.app.R

/**
 * Custom 3-step progress indicator view for wizard flows.
 *
 * - Current step is highlighted with primary color
 * - Completed steps show a green checkmark
 * - Future steps are shown in grey
 */
class StepIndicatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var stepLabels = listOf("Step 1", "Step 2", "Step 3")
    private var currentStep = 0 // 0-indexed

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = dpToPx(2f)
    }
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = spToPx(12f)
        textAlign = Paint.Align.CENTER
    }
    private val checkPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFFFFFFFF.toInt()
        strokeWidth = dpToPx(2f)
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }
    private val numberPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = spToPx(14f)
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
    }

    private val circleRadius = dpToPx(16f)
    private val primaryColor = context.getColor(R.color.primary)
    private val completedColor = context.getColor(R.color.status_completed)
    private val inactiveColor = context.getColor(R.color.offline)
    private val whiteColor = 0xFFFFFFFF.toInt()
    private val textColor = 0xFF333333.toInt()
    private val subtextColor = 0xFF999999.toInt()

    fun setSteps(labels: List<String>) {
        stepLabels = labels
        invalidate()
    }

    fun setCurrentStep(step: Int) {
        currentStep = step.coerceIn(0, stepLabels.size - 1)
        invalidate()
    }

    fun getCurrentStep(): Int = currentStep

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredHeight = (circleRadius * 2 + dpToPx(28f)).toInt()
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = resolveSize(desiredHeight, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (stepLabels.isEmpty()) return

        val stepCount = stepLabels.size
        val usableWidth = width - paddingLeft - paddingRight - circleRadius * 2
        val stepSpacing = if (stepCount > 1) usableWidth / (stepCount - 1) else 0f
        val startX = paddingLeft + circleRadius
        val centerY = circleRadius + dpToPx(4f)

        for (i in 0 until stepCount) {
            val cx = startX + stepSpacing * i
            val isCompleted = i < currentStep
            val isCurrent = i == currentStep

            // Draw connecting line to next step
            if (i < stepCount - 1) {
                val nextCx = startX + stepSpacing * (i + 1)
                linePaint.color = if (i < currentStep) completedColor else inactiveColor
                canvas.drawLine(
                    cx + circleRadius, centerY,
                    nextCx - circleRadius, centerY,
                    linePaint
                )
            }

            // Draw circle
            circlePaint.style = Paint.Style.FILL
            circlePaint.color = when {
                isCompleted -> completedColor
                isCurrent -> primaryColor
                else -> inactiveColor
            }
            canvas.drawCircle(cx, centerY, circleRadius, circlePaint)

            // Draw content inside circle
            if (isCompleted) {
                // Draw checkmark
                val checkSize = circleRadius * 0.5f
                canvas.drawLine(
                    cx - checkSize * 0.6f, centerY,
                    cx - checkSize * 0.1f, centerY + checkSize * 0.5f,
                    checkPaint
                )
                canvas.drawLine(
                    cx - checkSize * 0.1f, centerY + checkSize * 0.5f,
                    cx + checkSize * 0.6f, centerY - checkSize * 0.4f,
                    checkPaint
                )
            } else {
                // Draw step number
                numberPaint.color = if (isCurrent) whiteColor else whiteColor
                val textY = centerY - (numberPaint.descent() + numberPaint.ascent()) / 2
                canvas.drawText("${i + 1}", cx, textY, numberPaint)
            }

            // Draw label below circle
            textPaint.color = if (isCurrent || isCompleted) textColor else subtextColor
            textPaint.typeface = if (isCurrent) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
            val labelY = centerY + circleRadius + dpToPx(16f)
            canvas.drawText(stepLabels[i], cx, labelY, textPaint)
        }
    }

    private fun dpToPx(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics
        )
    }

    private fun spToPx(sp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics
        )
    }
}
