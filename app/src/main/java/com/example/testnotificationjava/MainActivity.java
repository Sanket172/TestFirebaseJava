package com.example.testnotificationjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

@Metadata(
        mv = {1, 1, 18},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"},
        d2 = {"Lcom/fhd/testfirebasenotification/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)

public final class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private HashMap _$_findViewCache;
    public String st = "";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        FirebaseInstanceId var10000 = FirebaseInstanceId.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(var10000, "FirebaseInstanceId.getInstance()");
        var10000.getInstanceId().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((InstanceIdResult)var1);
            }

            public final void onSuccess(InstanceIdResult it) {
                TextView var10000 = findViewById(R.id.textfield);
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                var10000.append((CharSequence)it.getToken());
                st = it.getToken();

                Log.d("tokenid", String.valueOf(it.getToken()));
            }
        }));

        FirebaseMessaging.getInstance().subscribeToTopic("testnotificationjava123").addOnCompleteListener((OnCompleteListener)(new OnCompleteListener() {
            public final void onComplete(@NotNull Task task) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                if (task.isSuccessful()) {
                    Log.d(MainActivity.this.TAG, "Global topic subscription successful");
                } else {
                    String var10000 = MainActivity.this.TAG;
                    StringBuilder var10001 = (new StringBuilder()).append("Global topic subscription failed. Error: ");
                    Exception var10002 = task.getException();
                    Log.e(var10000, var10001.append(var10002 != null ? var10002.getLocalizedMessage() : null).toString());
                }

            }
        }));


    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}

