package com.jrra.base.util.date

import java.util.*
import kotlin.collections.ArrayList

object DateUtil {
    /**
     * Ajoute le nombre de jours donné à la date
     *
     * @param date la date à laquelle on ajoute des jours
     * @param nbr le nombre de jours à ajouter sous forme de int. S'il est négatif, le nombre de
     * jours sera soustrait
     *
     * @return la date avec le certain nombre de jours en plus
     */
    fun addDaysOfMonth(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.DAY_OF_MONTH, nbr)
        return calendar.time
    }

    fun addDaysOfYear(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.DAY_OF_YEAR, nbr)
        return calendar.time
    }

    /**
     * Ajoute le nombre d'heures donné à la date
     *
     * @param date la date à laquelle on ajoute des heures
     * @param nbr le nombre de jours à ajouter sous forme de int. S'il est négatif, le nombre
     * d'heures sera soustrait
     *
     * @return la date avec le certain nombre d'heures en plus
     */
    fun addHoursOfDay(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.HOUR_OF_DAY, nbr)
        return calendar.time
    }

    /**
     * Ajoute le nombre de millisecondes donné à la date
     *
     * @param date la date à laquelle on ajoute des millisecondes
     * @param nbr le nombre de jours à ajouter sous forme de int. S'il est négatif, le nombre de
     * millisecondes sera soustrait
     *
     * @return la date avec le certain nombre de millisecondes en plus
     */
    fun addMilliseconds(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.MILLISECOND, nbr)
        return calendar.time
    }

    /**
     * Ajoute le nombre de minutes donné à la date
     *
     * @param date la date à laquelle on ajoute des minutes
     * @param nbr le nombre de jours à ajouter sous forme de int. S'il est négatif, le nombre de
     * minutes sera soustrait
     *
     * @return la date avec le certain nombre de minutes en plus
     */
    fun addMinutes(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.MINUTE, nbr)
        return calendar.time
    }

    /**
     * Ajoute le nombre de mois donné à la date
     *
     * @param date la date à laquelle on ajoute des mois
     * @param nbr le nombre de mois à ajouter sous forme de [Int]. S'il est négatif, le nombre de
     * mois sera soustrait
     *
     * @return la date avec le certain nombre de mois en plus
     */
    fun addMonths(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.MONTH, nbr)
        return calendar.time
    }

    /**
     * Ajoute le nombre de secondes donné à la date
     *
     * @param date la date à laquelle on ajoute des secondes
     * @param nbr le nombre de jours à ajouter sous forme de int. S'il est négatif, le nombre de
     * secondes sera soustrait
     *
     * @return la date avec le certain nombre de secondes en plus
     */
    fun addSeconds(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.SECOND, nbr)
        return calendar.time
    }

    /**
     * Ajoute le nombre d'années donné à la date
     *
     * @param date la date à laquelle on ajoute des années
     * @param nbr le nombre de jours à ajouter sous forme de int. S'il est négatif, le nombre
     * d'années sera soustrait
     *
     * @return la date avec le certain nombre d'années en plus
     */
    fun addYears(date: Date, nbr: Int): Date {
        val calendar = calendar(date)
        calendar.add(Calendar.YEAR, nbr)
        return calendar.time
    }

    /**
     * Prends deux objets [Date], soit [date1] et [date2] afin de retourner une date dont qui est à
     * la journée de [date1] et à l'heure de [date2].
     *
     * @param date1 la date dont l'année, le mois et le jour du mois sont utilisés
     * @param date2 la date dont l'heure, les minutes, les secondes et le millisecondes sont
     * utilisées
     * @return la combinaison de [date1] et de [date2]
     */
    fun atSameDate(date1: Date, date2: Date): Date {
        val calendar1 = calendar(date1)
        val calendar2 = calendar(date2)
        val fieldsToChange = intArrayOf(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)
        for (field in fieldsToChange) {
            calendar2.set(field, calendar1.get(field))
        }
        return calendar2.time
    }

    /**
     * Retourne une date qui possède les même caractéristiques que [date2], mais le jour du mois de
     * [date1]. Si le jours du mois est plus grand que la valeur maximale possible pour [date2], la
     * le jour du mois sera le maximum possible. Par exemple, si [date1] est un 31 janvier et
     * [date2] est pendant le mois de juin, alors la date retournée sera le 30 juin, puisque
     * juin compte 30 jours.
     *
     * @param date1 la date dont on garde le jour du mois
     * @param date2 la date dont on garde tout sauf le jour du mois
     * @return une date
     */
    fun atSameDayOfMonth(date1: Date, date2: Date): Date {
        val calendar1 = calendar(date1)
        val calendar2 = calendar(date2)
        val month = calendar2.get(Calendar.MONTH)
        calendar2.set(Calendar.DAY_OF_MONTH, calendar1.get(Calendar.DAY_OF_MONTH))
        if (month != calendar2.get(Calendar.MONTH)) {
            calendar2.set(Calendar.DAY_OF_MONTH, 1)
            calendar2.add(Calendar.DAY_OF_MONTH, -1)
        }
        return calendar2.time
    }

    /**
     * Retourne un objet [Calendar] sur lequel on a fait `setTime([date])`
     *
     * @param date la date dont provient le calendrier
     * @return un [Calendar]
     */
    fun calendar(date: Date): Calendar {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar
    }

    /**
     * Permet de mettre une date en objet [java.util.Calendar] où les millisecondes,
     * secondes, minutes et heures du jour sont à 0
     *
     * @param date la date à convertir
     *
     * @return un objet [java.util.Calendar] depuis le paramètre `date`
     */
    fun calendarDay(date: Date): Calendar {
        val calendar = calendar(date)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        return calendar
    }

    /**
     * Mets une date à la date d'aujourd'hui en conservant son heure et ses minutes, et en mettant
     * ses secondes et ses millisecondes à 0
     *
     * @param date la date dont on conserve l'heure et les minutes
     *
     * @return la date courante à la bonne heure
     */
    fun currentDate(date: Date): Date {
        val resultCalendar = Calendar.getInstance()
        val dateCalendar = calendar(date)
        resultCalendar.set(Calendar.HOUR_OF_DAY, dateCalendar.get(Calendar.HOUR_OF_DAY))
        resultCalendar.set(Calendar.MINUTE, dateCalendar.get(Calendar.MINUTE))
        resultCalendar.set(Calendar.SECOND, 0)
        resultCalendar.set(Calendar.MILLISECOND, 0)
        return resultCalendar.time
    }

    /**
     * Retourne la date présente sur laquelle on a appliqué [toDayOfMonth]
     *
     * @return la date courante
     */
    fun currentDateNoTime(): Date {
        return toDayOfMonth(Date())
    }

    /**
     * Permet d'avoir le jour de la semaine présent
     *
     * @return le int du jour de la semaine, où SUNDAY == 1 et SATURDAY == 7
     */
    fun currentWeekday(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    /**
     * Change une date à l'heure UTC en une date en heure locale
     *
     * @param date un objet [Date] à l'heure UTC
     *
     * @return un objet [Date] à l'heure locale
     */
    fun dateFromUTC(date: Date): Date {
        return Date(date.time + Calendar.getInstance().timeZone.getOffset(date.time))
    }

    /**
     * Change une date à l'heure locale en une date en heure UTC
     *
     * @param date un objet [Date] à l'heure locale
     *
     * @return un objet [Date] à l'heure UTC
     */
    fun dateToUTC(date: Date): Date {
        return Date(date.time - Calendar.getInstance().timeZone.getOffset(date.time))
    }

    /**
     * Permet d'avoir le nombre de jours à ajouter pour avoir la bonne date
     *
     * @param expectedWeekday le int du jour de la semaine attendu
     * @param currentWeekday le int du jour de la semaine présent
     *
     * @return le nombre de jours entre les deux
     */
    fun daysToAdd(expectedWeekday: Int, currentWeekday: Int): Int {
        return if (expectedWeekday < currentWeekday)
            daysToAdd(expectedWeekday + 7, currentWeekday)
        else
            expectedWeekday - currentWeekday
    }

    /**
     * Retourne le jour du mois de la date
     *
     * @param date la date dont on veut connaître le jour du mois
     *
     * @return le jour du mois
     */
    fun dayOfMonth(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.DAY_OF_MONTH)
    }

    /**
     * Retourne l'heure du jour  de la date
     *
     * @param date la date dont on veut connaître l'heure du jour
     *
     * @return l'heure du jour sur 24 heures
     */
    fun hourOfDay(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.HOUR_OF_DAY)
    }

    fun isToday(date: Date): Boolean {
        return DateCompareUtil.dateCompare(date, Date()) == 0
    }

    /**
     * Retourne le mois  de la date
     *
     * @param date la date dont on veut connaître le mois
     *
     * @return le mois, où janvier est 0
     */
    fun month(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.MONTH)
    }

    /**
     * Retourne les millisecondes  de la date
     *
     * @param date la date dont on veut connaître les millisecondes
     *
     * @return les millisecondes
     */
    fun milliseconds(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.MILLISECOND)
    }

    /**
     * Retourne les minutes  de la date
     *
     * @param date la date dont on veut connaître les minutes
     *
     * @return les minutes
     */
    fun minutes(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.MINUTE)
    }

    /**
     * Retourne les secondes  de la date
     *
     * @param date la date dont on veut connaître les secondes
     *
     * @return les secondes
     */
    fun seconds(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.SECOND)
    }

    /**
     * Retourne le nombre de secondes écoulés entre le début de la journée représentée par [date] et
     * le moment de la journée représenté par [date].
     *
     * C'est l'équivalent de si on calculais le nombre de secondes entre [date] et
     * [toDayOfMonth]\([date]\)
     *
     * @param date la date à vérifier
     * @return le nombre de secondes
     */
    fun secondsSinceDayStart(date: Date): Int {
        val hours = hourOfDay(date)
        val minutes = hours * 60 + minutes(date)
        return minutes * 60 + seconds(date)
    }

    /**
     * Mets les heures, les minutes, les secondes et les millisecondes de la date à 0
     *
     * @param date un objet [Date]
     *
     * @return un objet [Date] où les secondes et les millisecondes sont à 0
     */
    fun toDayOfMonth(date: Date): Date {
        val calendar = calendar(toHourOfDay(date))
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        return calendar.time
    }

    /**
     * Mets les minutes, les secondes et les millisecondes de la date à 0
     *
     * @param date un objet [Date]
     *
     * @return un objet [Date] où les secondes et les millisecondes sont à 0
     */
    fun toHourOfDay(date: Date): Date {
        val calendar = calendar(toMinutes(date))
        calendar.set(Calendar.MINUTE, 0)
        return calendar.time
    }

    /**
     * Mets les secondes et les millisecondes de la date à 0
     *
     * @param date un objet [Date]
     *
     * @return un objet [Date] où les secondes et les millisecondes sont à 0
     */
    fun toMinutes(date: Date): Date {
        val calendar = calendar(toSeconds(date))
        calendar.set(Calendar.SECOND, 0)
        return calendar.time
    }

    /**
     * Mets les heures, les minutes, les secondes et les millisecondes de la date à 0 et le jour du
     * mois à 1
     *
     * @param date un objet [Date]
     *
     * @return un objet [Date] où les secondes et les millisecondes sont à 0 et le jour du mois à 1
     */
    fun toMonth(date: Date): Date {
        val calendar = calendar(toDayOfMonth(date))
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        return calendar.time
    }

    /**
     * Mets les secondes et les millisecondes de la date à 0
     *
     * @param date un objet [Date]
     *
     * @return un objet [Date] où les secondes et les millisecondes sont à 0
     */
    fun toSeconds(date: Date): Date {
        val calendar = calendar(date)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    /**
     * Retourne l'année de la date
     *
     * @param date la date dont on veut connaître l'année
     *
     * @return l'année
     */
    fun year(date: Date): Int {
        val cal = calendar(date)
        return cal.get(Calendar.YEAR)
    }

    /**
     * Mets les heures, les minutes, les secondes et les millisecondes de la date à 0, le jour du
     * mois à 1 et le mois à [Calendar.JANUARY]
     *
     * @param date un objet [Date]
     *
     * @return un objet [Date] où les secondes et les millisecondes sont à 0, le jour du mois à 1 et
     * le mois à [Calendar.JANUARY]
     */
    fun toYear(date: Date): Date {
        val calendar = calendar(toMonth(date))
        calendar.set(Calendar.MONTH, Calendar.JANUARY)
        return calendar.time
    }

    /**
     * Permet d'avoir le jour de la semaine de la date
     *
     * @param date un objet [Date] dont on souhaite connaître le jour de la semaine
     * @return le int du jour de la semaine, où SUNDAY == 1 et SATURDAY == 7
     */
    fun weekday(date: Date): Int {
        val calendar = calendar(date)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    /**
     * Retourne un [ArrayList] de [String]. Cet array contient le string des années depuis 2018
     *
     * @return l'[ArrayList] des années de 2018 à aujourd'hui
     */
    fun yearsArray(): ArrayList<String> {
        val years = ArrayList<String>()
        val calNow = Calendar.getInstance()
        val calStart = Calendar.getInstance()
        calStart.set(Calendar.YEAR, 2018)
        while (calStart.get(Calendar.YEAR) <= calNow.get(Calendar.YEAR)) {
            years.add(calStart.get(Calendar.YEAR).toString())
            calStart.add(Calendar.YEAR, 1)
        }
        return years
    }
}