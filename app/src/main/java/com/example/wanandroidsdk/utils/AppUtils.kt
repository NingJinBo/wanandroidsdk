package com.example.wanandroidsdk.utils

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @auth: njb
 * @date: 2024/4/26 9:30
 * @desc: 描述
 */
class AppUtils {
    companion object{
        private val TAG = "APPUtils"
        fun openNotificationSettingsForApp(context: Context) {
            // Links to this app's notification settings.
            val intent = Intent()
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS")
            intent.putExtra("app_package", context.packageName)
            intent.putExtra("app_uid", context.applicationInfo.uid)
            // for Android 8 and above
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.packageName)
            context.startActivity(intent)
        }

        private fun startHome(context: Context) {
            val pm = context.packageManager
            val homeInfo = pm.resolveActivity(
                Intent(Intent.ACTION_MAIN)
                    .addCategory(Intent.CATEGORY_HOME), 0
            )
            val ai = homeInfo!!.activityInfo
            val startIntent = Intent(Intent.ACTION_MAIN)
            startIntent.addCategory(Intent.CATEGORY_LAUNCHER)
            startIntent.setComponent(ComponentName(ai.packageName, ai.name))
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                context.startActivity(startIntent)
            } catch (e: ActivityNotFoundException) {
                Log.i(TAG, "not found Activity error=" + e.message)
            } catch (e: SecurityException) {
                Log.i(TAG, "not found Activity error=" + e.message)
            }
        }
    }
}