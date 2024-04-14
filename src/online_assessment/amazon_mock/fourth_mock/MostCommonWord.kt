package online_assessment.amazon_mock.fourth_mock


fun main() {

}

private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val map = mutableMapOf<String, Int>()
    val word = StringBuilder()
    for (c in paragraph) {
        if (c.isLetter()) {
            word.append(c.lowercase())
        } else {
            if (word.isNotBlank()) {
                map[word.toString()] = (map[word.toString()] ?: 0) + 1
            }
            word.clear()
        }
    }
    var count = 0
    var result = ""
    val banSet = banned.toSet()
    for ((key, value) in map) {
        if (count < value && key !in banSet) {
            count = value
            result = key
        }
    }
    return result
}