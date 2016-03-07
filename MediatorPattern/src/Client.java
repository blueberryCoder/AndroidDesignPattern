
public class Client {
	public static void main(String[] args){
		//构造主板对象
		MainBoard mediator = new MainBoard();
		CDDevice cd = new CDDevice(mediator);
		CPU cpu = new CPU(mediator);
		GraphicsCard graphicsCard = new GraphicsCard(mediator);
		SoundCard sc = new SoundCard(mediator);
		
		//将各个部件安装到主板
		mediator.setCdDevice(cd);
		mediator.setCpu(cpu);
		mediator.setGraphicsCard(graphicsCard);
		mediator.setSoundCard(sc);
		
		//完成之后就可以执行
		cd.load();
	}
}
