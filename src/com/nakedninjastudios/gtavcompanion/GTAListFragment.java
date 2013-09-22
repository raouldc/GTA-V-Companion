package com.nakedninjastudios.gtavcompanion;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.nakedninjastudios.gtavcompanion.tabsframework.AbstractTabStackNavigationActivity;
import com.nakedninjastudios.gtavcompanion.tabsframework.TabInfo;

public class GTAListFragment extends SherlockListFragment {

	private ArrayList<GTAListItem> aList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		aList = null;
		try {
			XMLParser xp = new XMLParser(getActivity().getAssets().open("XML/walkthrough.xml"),"walkthrough");
			aList = xp.parseXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayAdapter<GTAListItem> adapter = new ArrayAdapter<GTAListItem>(
				inflater.getContext(), android.R.layout.simple_list_item_1,
				aList);
		setListAdapter(adapter);
		getSherlockActivity().getSupportActionBar().setTitle("Walkthrough");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// first, you need to get the reference to the currently shown tab in
		// order to add the fragment onto this tab
		final TabInfo tab = getTabStack().getCurrentTabInfo();

		GTAListDetailTextFragment fragment = new GTAListDetailTextFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",aList.get(position).getTitle());
		bundle.putString("content",aList.get(position).getContent());
		fragment.setArguments(bundle);

		// second, you push the fragment. It becomes visible and the up button
		// is shown
		getTabStack().pushFragment(tab, fragment);

	}

	public AbstractTabStackNavigationActivity getTabStack() {
		return (AbstractTabStackNavigationActivity) getActivity();
	}

}
