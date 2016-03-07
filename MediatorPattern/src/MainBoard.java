
public class MainBoard extends Mediator{
	
	private CDDevice cdDevice;//光驱设备
	private CPU cpu;//CPU
	private SoundCard soundCard;//声卡
	private GraphicsCard graphicsCard;//显卡
	
	@Override
	public void changed(Colleague c) {
		//如果光驱读取了数据
		if(c==cdDevice){
			handleCD((CDDevice)c);
		}
		//如果CPU处理完数据
		else if(c==cpu){
			handleCPU((CPU)c);
		}
	}

	/**
	 * 处理CPU读取数据口与其他设备的交互
	 * @param c
	 */
	private void handleCPU(CPU c) {
		soundCard.soundPlay(cpu.getDataSound());
		graphicsCard.videoPlay(cpu.getDataVideo());
	}

	private void handleCD(CDDevice c) {
		cpu.decodeData(c.read());
	}

	public void setCdDevice(CDDevice cdDevice) {
		this.cdDevice = cdDevice;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public void setSoundCard(SoundCard soundCard) {
		this.soundCard = soundCard;
	}

	public void setGraphicsCard(GraphicsCard graphicsCard) {
		this.graphicsCard = graphicsCard;
	}	

	
}
