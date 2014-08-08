/*
 * Copyright (c) 2012 Wireless Designs, LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.example.NavigationSampleDemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * PagerActivity: A Sample Activity for PagerContainer
 */
public class PagerActivity extends Activity {

  PagerContainer mContainer;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    mContainer = (PagerContainer) findViewById(R.id.pager_container);

    ViewPager pager = mContainer.getViewPager();
    PagerAdapter adapter = new MyPagerAdapter();
    pager.setAdapter(adapter);
    //Necessary or the pager will only have one extra page to show
    // make this at least however many pages you can see
    pager.setOffscreenPageLimit(adapter.getCount());
    //A little space between pages
    pager.setPageMargin(15);

    //If hardware acceleration is enabled, you should also remove
    // clipping on the pager for its children.
    pager.setClipChildren(false);
  }

  //Nothing special about this adapter, just throwing up colored views for demo
  private class MyPagerAdapter extends PagerAdapter {

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      TextView view = new TextView(PagerActivity.this);
      view.setText("Item " + position);
      view.setGravity(Gravity.CENTER);
      view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));

      container.addView(view);
      return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView((View) object);
    }

    @Override
    public int getCount() {
      return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return (view == object);
    }
  }
}
