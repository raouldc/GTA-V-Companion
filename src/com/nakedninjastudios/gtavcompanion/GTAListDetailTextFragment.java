package com.nakedninjastudios.gtavcompanion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class GTAListDetailTextFragment extends SherlockFragment {

	@Override
	public View onCreateView(final LayoutInflater inflater,
			final ViewGroup container, final Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.list_detail, container, false);
		final View tv = v.findViewById(R.id.listdetail_content);
		
		Bundle bundle = this.getArguments();
		
		String title = bundle.getString("title");
		getSherlockActivity().getSupportActionBar().setTitle(title);
		
		
		((TextView) tv).setText(bundle.getString("content"));
		return v;
	}

}
