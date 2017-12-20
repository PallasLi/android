package cn.pallasli.pmqchat.layout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/12/20.
 */

public class NoScrollViewPager  extends ViewPager {
    private boolean noScroll = false;

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (noScroll)
//            return false;
//        else
//            return super.onInterceptTouchEvent(arg0);
        int startX=0,startY=0;
        switch (ev.getAction())
                  {
                          case MotionEvent.ACTION_DOWN:
                                  startX= (int) ev.getX();
                                  startY= (int) ev.getY();
                                  break;
                          case MotionEvent.ACTION_MOVE:

                                  int dX= (int) (ev.getX()-startX);
                                  int dY= (int) (ev.getY()-startX);
                                  if(Math.abs(dX)<Math.abs(dY)){//上下滑动
                                          return false;
                                      }else {
                                      return true;
                                  }
                              case MotionEvent.ACTION_UP:
                                  break;
                      }
                  return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }
}