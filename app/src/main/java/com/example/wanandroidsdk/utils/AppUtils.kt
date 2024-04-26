package com.example.wanandroidsdk.utils

import android.content.Context
import android.content.Intent

/**
 * @auth: njb
 * @date: 2024/4/26 9:30
 * @desc: 描述
 */
class AppUtils {
    companion object{
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
    }
}