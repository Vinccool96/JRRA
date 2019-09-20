package com.jrra

import java.util.regex.Pattern

object StringUtil {

    fun indexFirstLetter(line: String): Int {
        val p = Pattern.compile("\\p{L}")
        val m = p.matcher(line)
        return if (m.find()) m.start() else 0
    }

    @Throws(IndexOutOfBoundsException::class)
    fun replaceAll(string: String, before: Iterable<String>, after: Iterable<String>): String {
        var result = string
        if (before.reversed().lastIndex == after.reversed().lastIndex) {
            val beforeIterator = before.iterator()
            val afterIterator = after.iterator()
            while (beforeIterator.hasNext() && afterIterator.hasNext())
                result = result.replace(beforeIterator.next(), afterIterator.next())

        } else throw IndexOutOfBoundsException("the iterables don't have the same size")
        return result
    }

    fun replaceAll(string: String, before: Iterable<String>, after: String): String {
        var result = string
        val beforeIterator = before.iterator()
        while (beforeIterator.hasNext()) result = result.replace(beforeIterator.next(), after)
        return result
    }

}