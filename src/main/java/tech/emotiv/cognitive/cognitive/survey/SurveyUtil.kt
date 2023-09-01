package tech.emotiv.cognitive.cognitive.survey

import tech.emotiv.cognitive.calc.Calculator

/**
 * @fileName SurveyUtil
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
open class SurveyUtil {

    open fun getSurveyResult(answerList: MutableList<Answer>): SurveyResult {
        val result = SurveyResult()

        answerList.forEach { answer ->
            when(answer.category) {
                Category.INATT -> result.inatt += answer.answer
                Category.HYPER -> result.hyper += answer.answer
                Category.PLAN -> result.plan += answer.answer
                Category.MONITOR -> result.monitor += answer.answer
                Category.INITIATE -> result.initiate += answer.answer
                Category.MEMORY -> result.memory += answer.answer
                Category.SHIFT -> result.shift += answer.answer
                Category.EMOTION -> result.emotion += answer.answer
                Category.INHIBIT -> result.inhibit += answer.answer
            }
            result.total += answer.answer
        }
        result.inatt = Calculator().decimalFormat(result.inatt / answerList.count { it.category == Category.INATT },"#00.000")
        result.hyper = Calculator().decimalFormat(result.hyper / answerList.count { it.category == Category.HYPER },"#00.000")
        result.plan = Calculator().decimalFormat(result.plan / answerList.count { it.category == Category.PLAN },"#00.000")
        result.shift = Calculator().decimalFormat(result.shift / answerList.count { it.category == Category.SHIFT },"#00.000")
        result.average = Calculator().decimalFormat(result.total / answerList.size,"#00.000")

        return result
    }

}