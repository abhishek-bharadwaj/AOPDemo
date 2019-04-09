package com.abhishek.aopdemo

import android.util.Log
import android.widget.EditText
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect

@Aspect
class PrefillAspect {

    @After("execution(* com.abhishek.aopdemo.LoginActivity.onCreate(*))")
    fun prefillLoginForm(joinPoint: JoinPoint) {
        try {
            val activity = joinPoint.target as LoginActivity
            activity.findViewById<EditText>(R.id.et_email).setText("test@example.com")
            activity.findViewById<EditText>(R.id.et_password).setText("MySecretPassword")
        } catch (e: Throwable) {
            Log.e("PrefillAspect", "prefillLoginForm: failed")
        }
    }

}