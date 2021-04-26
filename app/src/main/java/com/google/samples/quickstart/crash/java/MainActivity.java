/*
 * Copyright Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.quickstart.crash.java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.samples.quickstart.crash.databinding.ActivityMainBinding;

import java.util.EmptyStackException;

/**
 * This Activity shows the different ways of reporting application crashes.
 * - Report non-fatal exceptions that are caught by your app.
 * - Automatically Report uncaught crashes.
 *
 * It also shows how to add log messages to crash reports using log().
 *
 * Check https://console.firebase.google.com to view and analyze your crash reports.
 *
 * Check https://firebase.google.com/docs/crashlytics for more information on Firebase Crashlytics.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FirebaseCrashlytics mCrashlytics;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mCrashlytics = FirebaseCrashlytics.getInstance();

        // Log the onCreate event, this will also be printed in logcat
        mCrashlytics.log("onCreate");

        // Add some custom values and identifiers to be included in crash reports
        /*mCrashlytics.setCustomKey("MeaningOfLife", 42);
        mCrashlytics.setCustomKey("LastUIAction", "iiiiiiiiiiiiii");
        mCrashlytics.setCustomKey("chonky-key", "iiiiiiiiiiiiii");
        mCrashlytics.setCustomKey("mmmmmmmmmmmmmm", "mmmmmmmmmmmmmm");
        mCrashlytics.setCustomKey("mmmmmmmmmmmmmmm", "mmmmmmmmmmmmmmm");
                mCrashlytics.setCustomKey("super11", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibuSed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi temp");
                mCrashlytics.setCustomKey("super3", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempSed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi temp");
                mCrashlytics.setCustomKey("super4", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or.But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or.");
                mCrashlytics.setCustomKey("super14", "Li Europan lingues eds membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu sLi Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu s8");
                mCrashlytics.setCustomKey("super12", "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu sLi Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu s9");*/
        mCrashlytics.setUserId("123456789");

        // Report a non-fatal exception, for demonstration purposes
        mCrashlytics.recordException(new Exception("Non-fatal exception: something went wrong!"));


        // Button that causes NullPointerException to be thrown.
        binding.crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log that crash button was clicked.
                mCrashlytics.log("Crash button clicked.");

                mCrashlytics.setCustomKey("has_admin", "read");
                mCrashlytics.setCustomKey("is_spender", true);
                mCrashlytics.setCustomKey("language", "english");

                // If catchCrashCheckBox is checked catch the exception and report it using
                // logException(), Otherwise throw the exception and let Crashlytics automatically
                // report the crash.
                if (binding.catchCrashCheckBox.isChecked()) {
                    try {

                        mCrashlytics.setCustomKey("try", "there is no");
                        throw new NullPointerException();

                    } catch (NullPointerException ex) {
                        // [START crashlytics_log_and_report]
                        mCrashlytics.setCustomKey("catch", "do or do not");
                        mCrashlytics.log("NPE caught!");
                        mCrashlytics.recordException(ex);
                        // [END crashlytics_log_and_report]
                    }
                } else {
                    crashDifferent();
                }
            }
        });

        // Button that causes NullPointerException to be thrown.
        binding.crashButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Log that crash button was clicked.
                mCrashlytics.log("Crash button clicked.");

                mCrashlytics.setCustomKey("has_admin", "reading");
                mCrashlytics.setCustomKey("is_spender", false);
                mCrashlytics.setCustomKey("language", "日本語");
                mCrashlytics.setCustomKey("has_my_vote", true);

                // If catchCrashCheckBox is checked catch the exception and report it using
                // logException(), Otherwise throw the exception and let Crashlytics automatically
                // report the crash.
                if (binding.catchCrashCheckBox.isChecked()) {
                    try {

                        mCrashlytics.setCustomKey("try", "there is no");
                        throw new NullPointerException();

                    } catch (NullPointerException ex) {
                        // [START crashlytics_log_and_report]
                        mCrashlytics.setCustomKey("catch", "do or do not");
                        mCrashlytics.log("NPE caught!");
                        mCrashlytics.recordException(ex);
                        // [END crashlytics_log_and_report]
                    }
                } else {
                    throw new NullPointerException();

                }
                return false;
            }
        });

        // Log that the Activity was created.
        // [START crashlytics_log_event]
        mCrashlytics.log("Activity created");
        // [END crashlytics_log_event]
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCrashlytics.setCustomKey("has_admin", true);
        mCrashlytics.setCustomKey("is_spender", true);
        mCrashlytics.setCustomKey("language", "engineer");
        mCrashlytics.setCustomKey("has_my_vote", false);
        mCrashlytics.setCustomKey("is_eating_vegetables", true);
        //mCrashlytics.recordException(new Exception("Diff non fatal!"));
        throw new EmptyStackException();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCrashlytics.setCustomKey("has_admin", "readingalot");
        mCrashlytics.setCustomKey("language", "foose ball");
        mCrashlytics.setCustomKey("dark_mode_enabled", false);
        mCrashlytics.setCustomKey("key of victory", false);
        mCrashlytics.recordException(new Exception("Whoa!"));
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCrashlytics.setCustomKey("has_returned_from_background", true);
        mCrashlytics.setCustomKey("lan", true);
        mCrashlytics.setCustomKey("dark_mode_enabled", false);
        mCrashlytics.setCustomKey("is_elite", true);
        mCrashlytics.recordException(new Exception("Diff non fatal!"));
        mCrashlytics.recordException(new Exception("Diff non fatal!"));
    }

    public void crashDifferent() {
        mCrashlytics.setCustomKey("has_admin", "");
        mCrashlytics.setCustomKey("is_spender", "pietime");
        mCrashlytics.setCustomKey("has_my_vote", "where is the pie");
        mCrashlytics.setCustomKey("lan_party", "with friends");
        //mCrashlytics.recordException(new Exception("Diff non fatal!"));
        throw new EmptyStackException();
    }
}
