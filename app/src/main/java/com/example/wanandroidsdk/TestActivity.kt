package com.example.wanandroidsdk

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wanandroidsdk.constant.Constants
import com.example.wanandroidsdk.utils.AppUtils

/**
 * @auth: njb
 * @date: 2024/4/26 9:28
 * @desc: 描述
 */
class TestActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun requestNotificationPermission(activity: Activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ActivityCompat.checkSelfPermission(activity, Constants.POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED
            ) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, Constants.POST_NOTIFICATIONS)
                ) {
                    AppUtils.openNotificationSettingsForApp(this)
                } else {
                    ActivityCompat.requestPermissions(activity, arrayOf(Constants.POST_NOTIFICATIONS), 100)
                }
            }
        } else {
            val enabled = NotificationManagerCompat.from(activity).areNotificationsEnabled()
            if (!enabled) {
                AppUtils.openNotificationSettingsForApp(this)
            }
        }
    }
}