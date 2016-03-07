
public class CPU extends Colleague{

	private String dataVideo,dataSound;
	
	public CPU(Mediator mediator) {
		super(mediator);
	}

	public String getDataSound() {
		
		return dataSound;
	}

	public String getDataVideo() {
		return dataVideo;
	}

	public void decodeData(String data) {
		String[] tmp = data.split(",");
		dataVideo = tmp[0];
		dataSound = tmp[1];
		mediator.changed(this);
	}

}
