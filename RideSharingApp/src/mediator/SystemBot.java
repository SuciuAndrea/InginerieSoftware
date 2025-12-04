package mediator;

public class SystemBot extends User {

    public SystemBot(ChatMediator mediator) {
        super(mediator, "System");
    }

    @Override
    public void send(String msg) {
        mediator.sendMessage("System: " + msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(msg);
    }
}
