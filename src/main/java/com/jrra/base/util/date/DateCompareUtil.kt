package com.jrra.base.util.date

import java.util.*

object DateCompareUtil {

    /**
     * Permet de savoir si la date est dans l'intervale de temps entre deux dates
     *
     * @param date la date à vérifier
     * @param min la borne inférieure incluse
     * @param max la borne supérieure incluse
     * @return un [Boolean], qui est `true` si [date] est dans l'interval, sinon `false`
     */
    fun isDateInRange(date: Date, min: Date, max: Date): Boolean {
        return !date.before(min) && !date.after(max)
    }

    /**
     * Fait un [Date.compareTo] entre [date1] et [date2] après avoir mis [date2] à la même date (la
     * même année, le même mois, le même jour du mois) avec [DateUtil.atSameDate], afin que seul
     * l'heure du jour, les minutes, les secondes et les millisecondes soient prises en compte
     *
     * @param date1 la première date à comparer
     * @param date2 la deuxième date à comparer
     * @return le résultat de [Date.compareTo]
     */
    fun timeCompare(date1: Date, date2: Date): Int {
        return date1.compareTo(DateUtil.atSameDate(date1, date2))
    }

    /**
     * Fait un [Date.compareTo] entre [date1] et [date2] après avoir mis [date1] et [date2] au début
     * de leur journée (l'heure du jour, les minutes, les secondes et les millisecondes sont à zéro)
     * avec [DateUtil.toDayOfMonth], afin que seul l'année, le mois et le jours du mois soient pris
     * en compte
     *
     * @param date1 la première date à comparer
     * @param date2 la deuxième date à comparer
     * @return le résultat de [Date.compareTo]
     */
    fun dateCompare(date1: Date, date2: Date): Int {
        return DateUtil.toDayOfMonth(date1).compareTo(DateUtil.toDayOfMonth(date2))
    }

    /**
     * Détermine si, lorsqu'on met [date1] et [date2] dans un même mois comportant 31 jours, [date1]
     * survient une journée précédant [date2]
     *
     * @param date1
     * @param date2
     * @return
     */
    fun isDayOfMonthBefore(date1: Date, date2: Date): Boolean {
        val cal1 = DateUtil.calendar(date1)
        val cal2 = DateUtil.calendar(date2)
        return cal1.get(Calendar.DAY_OF_MONTH) < cal2.get(Calendar.DAY_OF_MONTH)
    }

    /**
     * Permet de savoir si [date] va survenir dans les 24 heures grâce à
     * [DateCompareUtil.isDateInRange]
     *
     * @param now le moment présent
     * @param date la date à vérifier
     * @return la valeur de `[isDateInRange](date, now, addDaysOfMonth(now, 1))`
     */
    fun isInTwentyFourHours(now: Date, date: Date): Boolean {
        return isDateInRange(date, now, DateUtil.addDaysOfMonth(now, 1))
    }

    /**
     * Retourne le nombre total de mois entre [date1] et [date2] où [date1] >= [date2]
     *
     * @param date1 un objet de type [Date]
     * @param date2 un objet de type [Date]
     *
     * @return un [Integer] qui est le nombre de mois entre [date1] et [date2]
     */
    fun totalMonthDifference(date1: Date, date2: Date): Int {
        val diffMonth = DateUtil.month(date1) - DateUtil.month(date2)
        val diffYears = DateUtil.year(date1) - DateUtil.year(date2)
        var tempResult = diffYears * 12 + diffMonth
        if (isDayOfMonthBefore(date1, date2))
            tempResult -= 1
        return tempResult
    }

    fun secondsBetween(date1: Date, date2: Date): Long {
        val deltaMilli = date1.time - date2.time
        return deltaMilli / 1000L
    }

    fun isAtSameDate(date1: Date, date2: Date): Boolean {
        return DateUtil.year(date1) == DateUtil.year(date2) &&
                DateUtil.month(date1) == DateUtil.month(date2) &&
                DateUtil.dayOfMonth(date1) == DateUtil.dayOfMonth(date2)
    }
}