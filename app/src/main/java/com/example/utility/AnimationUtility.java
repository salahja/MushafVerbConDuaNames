package com.example.utility;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mushafconsolidated.R;

public class AnimationUtility {
    /**
     * handles all subclasses of View : TextView, Button, ImageView etc..
     * given the component's id in their layout file
     */
    public static void AnimateArrow(float active, ImageView myImageView) {
        float todegrees = 90.0f;
        //     ImageView myImageView = (ImageView) findViewById(R.id.dropDownIconView);
        AnimationSet animSet = new AnimationSet(true);
        animSet.setInterpolator(new DecelerateInterpolator());
        animSet.setFillAfter(true);
        animSet.setFillEnabled(true);
        final RotateAnimation animRotate = new RotateAnimation(0.0f, active,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotate.setDuration(500);
        animRotate.setFillAfter(true);
        animSet.addAnimation(animRotate);
        myImageView.startAnimation(animSet);
    }

    public static void runAlphaAnimation(AppCompatActivity act, int viewId) {
        // load animation XML resource under res/anim
        Animation animation = AnimationUtils.loadAnimation(act, R.anim.fade);
        if (animation == null) {
            return; // here, we don't care
        }
        // reset initialization state
        animation.reset();
        // find View by its id attribute in the XML
        View v = act.findViewById(viewId);
        // cancel any pending animation and start this one
        if (v != null) {
            v.clearAnimation();
            v.startAnimation(animation);
        }
    }

    public static void slide_down(Context ctx, View v) {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if (a != null) {
            a.reset();
            if (v != null) {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
}