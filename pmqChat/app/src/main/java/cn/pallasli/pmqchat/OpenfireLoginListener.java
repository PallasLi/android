package cn.pallasli.pmqchat;

import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;

public class OpenfireLoginListener implements ConnectionListener {

	@Override
	public void reconnectionSuccessful() {

	}

	@Override
	public void reconnectionFailed(Exception e) {

	}

	@Override
	public void reconnectingIn(int seconds) {

	}

	@Override
	public void connectionClosedOnError(Exception e) {

	}

	@Override
	public void connectionClosed() {

	}

	@Override
	public void connected(XMPPConnection connection) {

	}

	@Override
	public void authenticated(XMPPConnection c, boolean resumed) {
		System.out.println("----");
		System.out.println("login");
		System.out.println("----" + c.isAuthenticated());
		c.isAuthenticated();

		Presence presence = new Presence(Presence.Type.available);
		try {
			c.sendStanza(presence);
			c.sendStanza(new Stanza("login") {

				@Override
				public CharSequence toXML() {
					// TODO Auto-generated method stub
					return "";
				}
			});
		} catch (NotConnectedException e) {
			e.printStackTrace();
		}
		System.out.println(c.getUser());

		// Roster roster = Roster.getInstanceFor(c);
		//

		// System.out.println(roster.getGroupCount());
		// new FriendshipManager().listFriends(c.getUser());
		// Route.toController("main.fxml");
	}
}
