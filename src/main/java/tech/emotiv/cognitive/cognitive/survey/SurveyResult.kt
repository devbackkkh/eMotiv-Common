package tech.emotiv.cognitive.cognitive.survey

/**
 * @fileName SurveyResult
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
data class SurveyResult(
    var total: Double = 0.0,
    var average: Double = -1.0,
    var inatt: Double = -1.0,
    var hyper: Double = -1.0,
    var plan: Double = -1.0,
    var shift: Double = -1.0,
    var monitor: Int = -1,
    var initiate: Int = -1,
    var memory: Int = -1,
    var emotion: Int = -1,
    var inhibit: Int = -1,
)
