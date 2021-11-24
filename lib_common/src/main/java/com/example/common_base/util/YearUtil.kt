package com.example.common_base.util

import android.content.Context
import java.util.*

/**
 *  author : zhang.wenqiang
 *  date : 2021/11/19
 *  description :
 */
object YearUtil {
    // Year definitions
    const val CLASS_UNKNOWN = -1
    const val CLASS_2008 = 2008
    const val CLASS_2009 = 2009
    const val CLASS_2010 = 2010
    const val CLASS_2011 = 2011
    const val CLASS_2012 = 2012
    const val CLASS_2013 = 2013
    const val CLASS_2014 = 2014
    const val CLASS_2015 = 2015
    const val CLASS_2016 = 2016
    private const val MB = (1024 * 1024).toLong()
    private const val MHZ_IN_KHZ = 1000

    @Volatile
    private var mYearCategory: Int? = null

    /**
     * Entry Point of YearClass. Extracts YearClass variable with memoizing.
     * Example usage:
     *
     *
     * <pre>
     * int yearClass = YearClass.get(context);
    </pre> *
     */
    operator fun get(c: Context): Int {
        if (mYearCategory == null) {
            synchronized(YearUtil::class.java) {
                if (mYearCategory == null) {
                    mYearCategory = categorizeByYear2016Method(c)
                }
            }
        }
        return mYearCategory!!
    }

    private fun conditionallyAdd(list: ArrayList<Int>, value: Int) {
        if (value != CLASS_UNKNOWN) {
            list.add(value)
        }
    }

    /**
     * This formulation of year class smooths out the distribution of devices in the field
     * in early 2016 so that the buckets are a bit more even in size and performance metrics
     * (specifically app startup time, scrolling perf, animations) are more uniform within
     * the buckets than with the 2014 calculations.
     */
    private fun categorizeByYear2016Method(c: Context): Int {
        val totalRam: Long = DeviceInfo.getTotalMemory(c)
        if (totalRam == DeviceInfo.DEVICEINFO_UNKNOWN.toLong()) {
            return categorizeByYear2014Method(c)
        }
        if (totalRam <= 768 * MB) {
            return if (DeviceInfo.getNumberOfCPUCores() <= 1) CLASS_2009 else CLASS_2010
        }
        if (totalRam <= 1024 * MB) {
            return if (DeviceInfo.getCPUMaxFreqKHz() < 1300 * MHZ_IN_KHZ) CLASS_2011 else CLASS_2012
        }
        if (totalRam <= 1536 * MB) {
            return if (DeviceInfo.getCPUMaxFreqKHz() < 1800 * MHZ_IN_KHZ) CLASS_2012 else CLASS_2013
        }
        if (totalRam <= 2048 * MB) {
            return CLASS_2013
        }
        if (totalRam <= 3 * 1024 * MB) {
            return CLASS_2014
        }
        return if (totalRam <= 5 * 1024 * MB) CLASS_2015 else CLASS_2016
    }

    /**
     * Calculates the "best-in-class year" of the device. This represents the top-end or flagship
     * devices of that year, not the actual release year of the phone. For example, the Galaxy Duos
     * S was released in 2012, but its specs are very similar to the Galaxy S that was released in
     * 2010 as a then top-of-the-line phone, so it is a 2010 device.
     *
     * @return The year when this device would have been considered top-of-the-line.
     */
    private fun categorizeByYear2014Method(c: Context): Int {
        val componentYears = ArrayList<Int>()
        conditionallyAdd(componentYears, numCoresYear)
        conditionallyAdd(componentYears, clockSpeedYear)
        conditionallyAdd(componentYears, getRamYear(c))
        if (componentYears.isEmpty()) return CLASS_UNKNOWN
        Collections.sort(componentYears)
        return if (componentYears.size and 0x01 == 1) {  // Odd number; pluck the median.
            componentYears[componentYears.size / 2]
        } else { // Even number. Average the two "center" values.
            val baseIndex = componentYears.size / 2 - 1
            // There's an implicit rounding down in here; 2011.5 becomes 2011.
            componentYears[baseIndex] +
                    (componentYears[baseIndex + 1] - componentYears[baseIndex]) / 2
        }
    }

    /**
     * Calculates the year class by the number of processor cores the phone has.
     * Evaluations are based off the table below:
     * <table border="1">
     * <thead>
     * <tr><th width="50%">Amount</th><th>Year</th></tr>
    </thead> * <thead>
    </thead> * <tbody>
     * <tr><td>>4 or More</td><td>2012</td></tr>
     * <tr><td>2 or 3</td><td>2011</td></tr>
     * <tr><td>1</td><td>2008</td></tr>
    </tbody> *
    </table> *
     *
     * @return the year in which top-of-the-line phones had the same number of processors as this phone.
     */
    private val numCoresYear: Int
        private get() {
            val cores: Int = DeviceInfo.getNumberOfCPUCores()
            if (cores < 1) return CLASS_UNKNOWN
            if (cores == 1) return CLASS_2008
            return if (cores <= 3) CLASS_2011 else CLASS_2012
        }// These cut-offs include 20MHz of "slop" because my "1.5GHz" Galaxy S3 reports
    // its clock speed as 1512000. So we add a little slop to keep things nominally correct.
    /**
     * Calculates the year class by the clock speed of the cores in the phone.
     * Evaluations are based off the table below:
     * <table border="1">
     * <thead>
     * <tr><th width="50%">Amount</th><th>Year</th></tr>
    </thead> * <thead>
    </thead> * <tbody>
     * <tr><td>>2GHz</td><td>2014</td></tr>
     * <tr><td><=2GHz</td><td>2013</td></tr>
     * <tr><td><=1.5GHz</td><td>2012</td></tr>
     * <tr><td><=1.2GHz</td><td>2011</td></tr>
     * <tr><td><=1GHz</td><td>2010</td></tr>
     * <tr><td><=600MHz</td><td>2009</td></tr>
     * <tr><td><=528MHz</td><td>2008</td></tr>
    </tbody> *
    </table> *
     *
     * @return the year in which top-of-the-line phones had the same clock speed.
     */
    private val clockSpeedYear: Int
        private get() {
            val clockSpeedKHz: Int = DeviceInfo.getCPUMaxFreqKHz()
            if (clockSpeedKHz == DeviceInfo.DEVICEINFO_UNKNOWN) return CLASS_UNKNOWN
            // These cut-offs include 20MHz of "slop" because my "1.5GHz" Galaxy S3 reports
            // its clock speed as 1512000. So we add a little slop to keep things nominally correct.
            if (clockSpeedKHz <= 528 * MHZ_IN_KHZ) return CLASS_2008
            if (clockSpeedKHz <= 620 * MHZ_IN_KHZ) return CLASS_2009
            if (clockSpeedKHz <= 1020 * MHZ_IN_KHZ) return CLASS_2010
            if (clockSpeedKHz <= 1220 * MHZ_IN_KHZ) return CLASS_2011
            if (clockSpeedKHz <= 1520 * MHZ_IN_KHZ) return CLASS_2012
            return if (clockSpeedKHz <= 2020 * MHZ_IN_KHZ) CLASS_2013 else CLASS_2014
        }

    /**
     * Calculates the year class by the amount of RAM the phone has.
     * Evaluations are based off the table below:
     * <table border="1">
     * <thead>
     * <tr><th width="50%">Amount</th><th>Year</th></tr>
    </thead> * <thead>
    </thead> * <tbody>
     * <tr><td>>2GB</td><td>2014</td></tr>
     * <tr><td><=2GB</td><td>2013</td></tr>
     * <tr><td><=1.5GB</td><td>2012</td></tr>
     * <tr><td><=1GB</td><td>2011</td></tr>
     * <tr><td><=512MB</td><td>2010</td></tr>
     * <tr><td><=256MB</td><td>2009</td></tr>
     * <tr><td><=128MB</td><td>2008</td></tr>
    </tbody> *
    </table> *
     *
     * @return the year in which top-of-the-line phones had the same amount of RAM as this phone.
     */
    private fun getRamYear(c: Context): Int {
        val totalRam: Long = DeviceInfo.getTotalMemory(c)
        if (totalRam <= 0) return CLASS_UNKNOWN
        if (totalRam <= 192 * MB) return CLASS_2008
        if (totalRam <= 290 * MB) return CLASS_2009
        if (totalRam <= 512 * MB) return CLASS_2010
        if (totalRam <= 1024 * MB) return CLASS_2011
        if (totalRam <= 1536 * MB) return CLASS_2012
        return if (totalRam <= 2048 * MB) CLASS_2013 else CLASS_2014
    }
}