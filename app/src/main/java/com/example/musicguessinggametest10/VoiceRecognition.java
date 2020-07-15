package com.example.musicguessinggametest10;

import android.content.ComponentCallbacks2;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;

public interface VoiceRecognition extends LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback,
        View.OnCreateContextMenuListener, ComponentCallbacks2, LifecycleOwner, KeyEventDispatcher.Component,
        ViewModelStoreOwner, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityCompat.OnRequestPermissionsResultCallback,
        ActivityCompat.RequestPermissionsRequestCodeValidator, AppCompatCallback, TaskStackBuilder.SupportParentable,
        ActionBarDrawerToggle.DelegateProvider {
}


