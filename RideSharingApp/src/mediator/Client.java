package mediator;

public class Client extends User {

    public Client(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        mediator.sendMessage(name + ": " + msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(name + " received -> " + msg);
    }
}
