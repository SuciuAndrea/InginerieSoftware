package mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

    private List<User> users = new ArrayList<>();
    private List<String> offlineMessages = new ArrayList<>();

    @Override
    public void sendMessage(String message, User sender) {
        boolean delivered = false;

        for (User user : users) {
            if (user != sender) {
                user.receive(message);
                delivered = true;
            }
        }

        if (!delivered) {
            offlineMessages.add(message);
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);

        for (String msg : offlineMessages) {
            user.receive("Offline message: " + msg);
        }
        offlineMessages.clear();
    }
}
