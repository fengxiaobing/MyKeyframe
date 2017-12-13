package com.bing.mykeyframe;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button,btn_KeyFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        btn_KeyFrame = findViewById(R.id.btn_KeyFrame);
        btn_KeyFrame.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                /***
                 * 很多时候，你在同一个动画中会需要改变多个属性，例如在改变透明度的同时改变尺寸。
                 * 如果使用 ViewPropertyAnimator，你可以直接用连写的方式来在一个动画中同时改变多个属性：
                 * view.animate().scaleX(1).scaleY(1).alpha(1);
                 * 而对于 ObjectAnimator，是不能这么用的。不过你可以使用 PropertyValuesHolder 来同时在一个动画中改变多个属性。
                 *
                 */

                PropertyValuesHolder propertyValuesHolder1  = PropertyValuesHolder.ofFloat("scaleX",0,1);
                PropertyValuesHolder propertyValuesHolder2  = PropertyValuesHolder.ofFloat("scaleY",0,1);
                PropertyValuesHolder propertyValuesHolder3  = PropertyValuesHolder.ofFloat("alpha",0,1);

                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(button,propertyValuesHolder1,propertyValuesHolder2,propertyValuesHolder3);
                animator.setDuration(2000);
                animator.start();
                break;
                case R.id.btn_KeyFrame:
                    //从0处开始
                    Keyframe keyframe = Keyframe.ofFloat(0,0);
                    //时间经过50%的时候，动作执行到100%（从0到1）
                    Keyframe keyframe1 = Keyframe.ofFloat(0.5f,1f);
                    // 时间经过 100% 的时候，动画完成度倒退到 50%，即反弹 50%（由1到0.5）
                    Keyframe keyframe2 = Keyframe.ofFloat(1f,0.5f);
                    PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("scaleX",keyframe,keyframe1,keyframe2);
                    PropertyValuesHolder holder1 = PropertyValuesHolder.ofKeyframe("scaleY",keyframe,keyframe1,keyframe2);

                    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(btn_KeyFrame,holder,holder1);

//                    PropertyValuesHolder holder1 = PropertyValuesHolder.ofKeyframe("translationX",keyframe,keyframe1,keyframe2);
////
//                    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(btn_KeyFrame,holder1);
//                    objectAnimator.setRepeatCount(Animation.INFINITE);
                    objectAnimator.start();
                break;
        }

    }
}
