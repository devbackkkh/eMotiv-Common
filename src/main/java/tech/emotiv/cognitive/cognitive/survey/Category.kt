package tech.emotiv.cognitive.cognitive.survey

/**
 * @fileName Category
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
enum class Category(private val description: String) {
    INATT("주의력"),
    HYPER("과잉행동/충동성"),
    PLAN("계획/조직"),
    MONITOR("모니터"),
    INITIATE("착수"),
    MEMORY("기억력"),
    SHIFT("전환"),
    EMOTION("감정조절"),
    INHIBIT("억제")
}