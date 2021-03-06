/**
 *    Copyright 2012 Daniel Kreischer, Christopher Holm, Christopher Schwardt
 *
 *    This file is part of TeamMeet.
 *
 *    TeamMeet is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    TeamMeet is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with TeamMeet.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package de.teammeet;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class SettingsActivity extends Activity {

	public static final String	PREFS_NAME				= "de.teammeet";
	public static final String	SETTING_FULLSCREEN		= "fullscreen";
	public static final String	SETTING_FOLLOW_LOCATION	= "followLocation";

	private CheckBox			mFullscreenCheck		= null;
	private CheckBox			mFollowLocationCheck	= null;
	private SharedPreferences	mSettings				= null;
	private Editor				mEditor					= null;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		mSettings = getSharedPreferences(PREFS_NAME, 0);
		mEditor = mSettings.edit();

		mFollowLocationCheck = (CheckBox) findViewById(R.id.CheckBoxFollowPlayer);
		mFollowLocationCheck.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean isChecked = false;
				if (((CheckBox) v).isChecked()) {
					isChecked = true;
				}
				setFollowLocation(isChecked);
			}
		});

		mFullscreenCheck = (CheckBox) findViewById(R.id.CheckBoxFullscreen);
		mFullscreenCheck.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean isChecked = false;
				if (((CheckBox) v).isChecked()) {
					isChecked = true;
				}
				setFullscreen(isChecked);
			}
		});

		final boolean follow = mSettings.getBoolean(SETTING_FOLLOW_LOCATION, false);
		mFollowLocationCheck.setChecked(follow);

		final boolean fullscreen = mSettings.getBoolean(SETTING_FULLSCREEN, false);
		mFullscreenCheck.setChecked(fullscreen);
	}

	private void setFollowLocation(final boolean follow) {
		mEditor.putBoolean(SETTING_FOLLOW_LOCATION, follow);
		mEditor.commit();
	}

	private void setFullscreen(final boolean fullscreen) {
		mEditor.putBoolean(SETTING_FULLSCREEN, fullscreen);
		mEditor.commit();
	}

}
