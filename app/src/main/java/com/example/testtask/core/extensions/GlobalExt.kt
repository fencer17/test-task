package com.example.testtask.core.extensions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import timber.log.Timber

fun Long?.orZero(): Long = this ?: 0L

fun String.openLink(context: Context){
    try{
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this))
        context.startActivity(browserIntent)
    } catch (e: ActivityNotFoundException){
        Timber.e(e)
    }
}