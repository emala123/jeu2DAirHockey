package air_hockey.commun.messages;

import air_hockey.commun.modeles.ModeleLeaderboard;
import ca.ntro.app.messages.MessageNtro;

public class MsgRetirerJoueur extends MessageNtro{
	
	private String idPosition;

	public String getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(String idPosition) {
		this.idPosition = idPosition;
	}

	public void retirerDe(ModeleLeaderboard leaderboard) {
		leaderboard.retirerPosition(idPosition);
	}
}
