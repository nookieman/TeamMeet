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

package de.teammeet.interfaces;

import java.util.List;
import java.util.Map;

import org.jivesoftware.smack.XMPPException;

import com.google.android.maps.GeoPoint;

import de.teammeet.Mate;

public interface IXMPPService {

	void registerMatesUpdates(IMatesUpdateRecipient object);

	void unregisterMatesUpdates(IMatesUpdateRecipient object);

	void connect(String userID, String server, String password) throws XMPPException;

	boolean isAuthenticated();

	void disconnect();

	Map<String, List<String>> getContacts() throws XMPPException;

	void addContact(String userID, String identifier) throws XMPPException;

	void createRoom(String groupName, String conferenceServer) throws XMPPException;

	void joinRoom(String roomName, String userID, String password, String conferenceServer)
			throws XMPPException;

	void leaveRoom(String roomName);

	void invite(String contact, String roomName);

	void sendLocation(GeoPoint location, float accuracy) throws XMPPException;

	void sendIndicator(GeoPoint location) throws XMPPException;

	void updateMate(Mate mate);
}
