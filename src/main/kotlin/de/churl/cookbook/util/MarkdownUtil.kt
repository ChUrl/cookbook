package de.churl.cookbook.util

import org.commonmark.ext.autolink.AutolinkExtension
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension
import org.commonmark.ext.ins.InsExtension
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

fun renderMarkdown(markdown: String): String {
    val extensions = listOf(
        AutolinkExtension.create(),
        StrikethroughExtension.create(),
        InsExtension.create()
    )
    val parser = Parser.builder().extensions(extensions).build()
    val node = parser.parse(markdown)
    val render = HtmlRenderer.builder().extensions(extensions).build()

    return render.render(node)
}
