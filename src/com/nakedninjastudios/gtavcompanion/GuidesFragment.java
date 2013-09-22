package com.nakedninjastudios.gtavcompanion;

import java.io.IOException;
import java.io.InputStream;

import com.actionbarsherlock.app.SherlockFragment;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GuidesFragment extends SherlockFragment implements TabListener {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_guides,
				container, false);
		
		//set Header image
		ImageView imgView = (ImageView) rootView
				.findViewById(R.id.guides_header);
		
		try {
			imgView.setImageBitmap(getBitmapFromAsset("images/guides_header.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rootView;
	}
	
	private Bitmap getBitmapFromAsset(String strName) throws IOException
	{
	    AssetManager assetManager = getActivity().getAssets();
	    InputStream istr = assetManager.open(strName);
	    Bitmap bitmap = BitmapFactory.decodeStream(istr);
	    return bitmap;
	 }


	@Override
	public void onTabSelected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
