
public class Client {
	public static void  main(String[] args){
		Ticket ticket01 = TicketFactory.getTicket("北京", "青島");
		ticket01.showTicketInfo("上鋪");
		Ticket ticket02  = TicketFactory.getTicket("北京", "青島");
		ticket02.showTicketInfo("下鋪");
		Ticket ticket03 = TicketFactory.getTicket("北京", "青島");
		ticket03.showTicketInfo("坐票");
	}
}
