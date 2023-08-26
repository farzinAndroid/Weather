package com.farzin.weather.util

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocaleUtils {

    fun setLang(context: Context, lang: String) = updateResources(context, lang)

    private fun updateResources(context: Context, lang: String) {

        context.resources.apply {
            val locale = Locale(lang)
            val config = Configuration(configuration)

            context.createConfigurationContext(config)
            Locale.setDefault(locale)
            config.setLocale(locale)
            context.resources.updateConfiguration(config,displayMetrics)
        }

    }

}