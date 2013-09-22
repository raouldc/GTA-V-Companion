package com.nakedninjastudios.gtavcompanion;

import java.util.Locale;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.view.Menu;
import com.nakedninjastudios.gtavcompanion.tabsframework.AbstractTabStackNavigationActivity;

public class MainActivity extends AbstractTabStackNavigationActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	// SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	// ViewPager mViewPager;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	// public class SectionsPagerAdapter extends FragmentPagerAdapter {
	//
	// public SectionsPagerAdapter(FragmentManager fm) {
	// super(fm);
	// }
	//
	// @Override
	// public SherlockFragment getItem(int position) {
	// // getItem is called to instantiate the fragment for the given page.
	// // Return a DummySectionFragment (defined as a static inner class
	// // below) with the page number as its lone argument.
	// switch (position){
	// case 0:
	// return new GuidesFragment();
	// case 1:
	// return new GuidesFragment();
	// case 2:
	// return new GuidesFragment();
	// }
	// return null;
	// }
	//
	// @Override
	// public int getCount() {
	// // Show 3 total pages.
	// return 3;
	// }
	//
	// @Override
	// public CharSequence getPageTitle(int position) {
	// Locale l = Locale.getDefault();
	// switch (position) {
	// case 0:
	// return getString(R.string.title_section1).toUpperCase(l);
	// case 1:
	// return getString(R.string.title_section2).toUpperCase(l);
	// case 2:
	// return getString(R.string.title_section3).toUpperCase(l);
	// }
	// return null;
	// }
	// }

	// @Override
	// public void onTabSelected(Tab tab,
	// android.support.v4.app.FragmentTransaction ft) {
	// // When the given tab is selected, switch to the corresponding page in
	// // the ViewPager.
	// mViewPager.setCurrentItem(tab.getPosition());
	//
	// }
	//
	// @Override
	// public void onTabUnselected(Tab tab,
	// android.support.v4.app.FragmentTransaction ft) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onTabReselected(Tab tab,
	// android.support.v4.app.FragmentTransaction ft) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	protected void createTabs() {
		// TODO Auto-generated method stub
		// setContentView(R.layout.activity_main);
		// Set up the action bar.
		final ActionBar actionBar = getSupportActionBar();
		// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		// mSectionsPagerAdapter = new SectionsPagerAdapter(
		// getSupportFragmentManager());

		// // Set up the ViewPager with the sections adapter.
		// mViewPager = (ViewPager) findViewById(R.id.pager);
		// mViewPager.setAdapter(mSectionsPagerAdapter);
		//
		// // When swiping between different sections, select the corresponding
		// // tab. We can also use ActionBar.Tab#select() to do this if we have
		// // a reference to the Tab.
		// mViewPager
		// .setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
		// @Override
		// public void onPageSelected(int position) {
		// actionBar.setSelectedNavigationItem(position);
		// }
		// });

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < 3; i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.

			ActionBar.Tab tab = actionBar.newTab();
			tab.setText(getTitle(i));
			addTab(tab, getFragment(i));
			// actionBar.addTab(actionBar.newTab()
			// .setText(mSectionsPagerAdapter.getPageTitle(i))
			// .setTabListener(this));
		}

	}

	public CharSequence getTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return getString(R.string.title_section3).toUpperCase(l);
		}
		return null;
	}
	
	public Fragment getFragment(int position) {
		switch (position) {
		case 0:
			return new GuidesFragment();
		case 1:
			return new GuidesFragment();
		case 2:
			return new AchievementsListFragment();
		}
		return null;
	}
}
