package tech.emotiv.cognitive.calc

import java.text.DecimalFormat

/**
 * @fileName Calculator
 * @author kimkihyeon
 * @since 2023/09/01
 * @version 1.0
 *
 * @Modification Information
 * @
 * @    DATE           AUTHOR          NOTE
 * @ -----------     ----------    -------------------
 * @ 2023/09/01     kimkihyeon       최초 작성
 */
open class Calculator {

    open fun decimalFormat(value: Double, format: String): Double {
        val decimal = DecimalFormat(format)
        return decimal.format(value).toDouble()
    }

}