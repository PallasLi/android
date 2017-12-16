package com.pallasli.officeautomation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragmentTabHost extends FragmentTabHost {
    private String mCurrentTag;
    private String mNoTabChangedTag;

    public MyFragmentTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onTabChanged(String tabId) {
        if(tabId.equals(mNoTabChangedTag)){
            setCurrentTabByTag(mCurrentTag);
        }else{
            super.onTabChanged(tabId);
            mCurrentTag = tabId;
        }
    }

    public void setNoTabChangedTag(String tag) {
        this.mNoTabChangedTag = tag;
    }

}
