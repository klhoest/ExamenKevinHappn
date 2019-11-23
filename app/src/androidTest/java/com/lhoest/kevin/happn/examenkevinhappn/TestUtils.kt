package com.lhoest.kevin.happn.examenkevinhappn

import androidx.annotation.LayoutRes

object TestUtils {

    //todo I need to copy the real code that we use at Europcar
    /**
    * at Europcar we implemented a retry wrapper in order to decrease false failed test
    * see https://developer.android.com/training/testing/espresso/idling-resource
    */
    fun waitForWithToBeDisplayed(@LayoutRes res: Int) {
        Thread.sleep(300L)
    }
}