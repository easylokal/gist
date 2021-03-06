object TextViewViewTransformer : AbstractViewTransformer<TextView>() {

    private const val ATTRIBUTE_TEXT = "text"
    private const val ATTRIBUTE_ANDROID_TEXT = "android:text"
    private const val ATTRIBUTE_HINT = "hint"
    private const val ATTRIBUTE_ANDROID_HINT = "android:hint"

    override val viewType = TextView::class.java

    override val supportedAttributes = setOf(
        ATTRIBUTE_TEXT, ATTRIBUTE_ANDROID_TEXT, ATTRIBUTE_HINT,
            ATTRIBUTE_ANDROID_HINT
    )

    override fun TextView.transform(attrs: Map<String, Int>) {
        attrs.forEach { entry ->
            when (entry.key) {
                ATTRIBUTE_ANDROID_TEXT, ATTRIBUTE_TEXT -> updateTexts(entry.value, this::setText)
                ATTRIBUTE_ANDROID_HINT, ATTRIBUTE_HINT -> updateTexts(entry.value, this::setHint)
            }
        }
    }
}
