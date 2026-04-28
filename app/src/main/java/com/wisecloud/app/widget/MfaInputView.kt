package com.wisecloud.app.widget

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import com.wisecloud.app.R

/**
 * MFA 6-digit input custom view.
 *
 * - 6 individual EditText fields, each accepting exactly 1 digit
 * - Auto-advances focus to the next field after input
 * - Backspace on an empty field moves focus to the previous field and clears it
 */
class MfaInputView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val digitFields = mutableListOf<EditText>()
    private var onCodeCompleteListener: ((String) -> Unit)? = null

    companion object {
        private const val DIGIT_COUNT = 6
    }

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        setupDigitFields()
    }

    private fun setupDigitFields() {
        val fieldSize = dpToPx(48)
        val fieldMargin = dpToPx(6)

        for (i in 0 until DIGIT_COUNT) {
            val editText = EditText(context).apply {
                id = View.generateViewId()
                inputType = InputType.TYPE_CLASS_NUMBER
                filters = arrayOf(InputFilter.LengthFilter(1))
                gravity = Gravity.CENTER
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                setBackgroundResource(R.drawable.mfa_digit_background)
                setPadding(0, 0, 0, 0)
                imeOptions = if (i < DIGIT_COUNT - 1) {
                    EditorInfo.IME_ACTION_NEXT
                } else {
                    EditorInfo.IME_ACTION_DONE
                }
                isCursorVisible = false
            }

            val params = LayoutParams(fieldSize, fieldSize).apply {
                if (i > 0) marginStart = fieldMargin
            }

            addView(editText, params)
            digitFields.add(editText)
        }

        // Wire up text watchers and key listeners
        for (i in 0 until DIGIT_COUNT) {
            digitFields[i].addTextChangedListener(DigitTextWatcher(i))
            digitFields[i].setOnKeyListener(DigitKeyListener(i))
        }
    }

    /**
     * Returns the full 6-digit code entered by the user.
     * May be shorter than 6 characters if not all fields are filled.
     */
    fun getCode(): String {
        return digitFields.joinToString("") { it.text.toString() }
    }

    /** Clears all digit fields. */
    fun clear() {
        digitFields.forEach { it.text.clear() }
        digitFields.firstOrNull()?.requestFocus()
    }

    /** Sets a listener invoked when all 6 digits have been entered. */
    fun setOnCodeCompleteListener(listener: (String) -> Unit) {
        onCodeCompleteListener = listener
    }

    private fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

    private inner class DigitTextWatcher(private val index: Int) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (!s.isNullOrEmpty()) {
                // Auto-advance to next field
                if (index < DIGIT_COUNT - 1) {
                    digitFields[index + 1].requestFocus()
                }
                // Check if all digits are filled
                val code = getCode()
                if (code.length == DIGIT_COUNT) {
                    onCodeCompleteListener?.invoke(code)
                }
            }
        }
    }

    private inner class DigitKeyListener(private val index: Int) : OnKeyListener {
        override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event?.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                val currentField = digitFields[index]
                if (currentField.text.isEmpty() && index > 0) {
                    // Move to previous field and clear it
                    val prevField = digitFields[index - 1]
                    prevField.text.clear()
                    prevField.requestFocus()
                    return true
                }
            }
            return false
        }
    }
}
