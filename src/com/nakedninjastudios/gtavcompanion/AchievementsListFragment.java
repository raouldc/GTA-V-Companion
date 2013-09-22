package com.nakedninjastudios.gtavcompanion;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.nakedninjastudios.gtavcompanion.pinnedheaderlistview.PinnedHeaderListView;
import com.nakedninjastudios.gtavcompanion.pinnedheaderlistview.SectionedBaseAdapter;

public class AchievementsListFragment extends SherlockListFragment {
	private ArrayList<GTAListItem> achievementsList;
	private AchievementsListAdapter adapter;
	private int[] sectionIndexes =  {0,39};
	private String[] sectionHeaders = {"Default","Hidden"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getSherlockActivity().setContentView(R.layout.fragment_achievements);
		achievementsList = new ArrayList<GTAListItem>();

		adapter = new AchievementsListAdapter();
		LayoutInflater inflator = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout layout = (LinearLayout) inflator.inflate(
				R.layout.fragment_achievements, null);
		PinnedHeaderListView listview = (PinnedHeaderListView) layout
				.findViewById(R.id.pinnedListView);

		try {
			achievementsList = new XMLParser(getActivity().getAssets().open("XML/achievements.xml"), "achievements").parseXML();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setListAdapter(adapter);
		listview.setAdapter(adapter);
	}
	
	public class AchievementsListAdapter extends SectionedBaseAdapter {

		@Override
		public Object getItem(int section, int position) {
			return null;
		}

		@Override
		public long getItemId(int section, int position) {
			return 0;
		}

		@Override
		public int getSectionCount() {
			return 2;
		}

		@Override
		public int getCountForSection(int section) {
			if (section == 0) {
				return 39;
			} else {
				return 11;
			}
		}

		@Override
		public View getItemView(int section, int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			RelativeLayout layout = null;
			if (convertView == null) {
				LayoutInflater inflator = (LayoutInflater) parent.getContext()
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				layout = (RelativeLayout) inflator.inflate(R.layout.achievements_list_item,
						null);
			} else {
				layout = (RelativeLayout) convertView;
			}
			// set item
			GTAListItem item = achievementsList.get(sectionIndexes[section] + position);
			((TextView) layout.findViewById(R.id.achievementTitle)).setText(achievementsList.get(sectionIndexes[section] + position).getTitle());
			((TextView) layout.findViewById(R.id.achievementSubtitle)).setText(achievementsList.get(sectionIndexes[section] + position).getContent());
			((TextView) layout.findViewById(R.id.xboxPoints)).setText(achievementsList.get(sectionIndexes[section] + position).getPoints());
//			if (staff.get_photo() != null) {
//				Bitmap img = BitmapFactory.decodeByteArray(staff.get_photo(),
//						0, staff.get_photo().length);
//				((ImageView) layout.findViewById(R.id.staffpic))
//						.setImageBitmap(img);
//			}
			return layout;
		}

		@Override
		public View getSectionHeaderView(int section, View convertView,
				ViewGroup parent) {
			LinearLayout layout = null;
			if (convertView == null) {
				LayoutInflater inflator = (LayoutInflater) parent.getContext()
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				layout = (LinearLayout) inflator.inflate(R.layout.header_item,
						null);
			} else {
				layout = (LinearLayout) convertView;
			}
			// set item
			((TextView) layout.findViewById(R.id.headertextItem))
					.setText(sectionHeaders[section]);
			return layout;
		}
	}
	
}
