package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = new User("Von", true);
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rsl = users[i];
                System.out.println("Пользователь стаким именем существует: " + rsl.getUsername());
                break;
            } else {
                throw new UserNotFoundException("Ошибка. Пользователь с таким именем не найден!");
            }
        }
        return rsl;
    }

    public static boolean validater(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() >= 3) {
            System.out.println("Пользователь " + user.getUsername() + " прошёл валидацию.");
            return true;
        } else {
            throw new UserInvalidException("Пользователь " + user.getUsername() + " найден, но не прошёл валидацию!");
        }
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", false)};
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validater(user)) {
                System.out.println("This user has in access");
            }
        } catch (UserNotFoundException i) {
            i.printStackTrace();
        } catch (UserInvalidException i) {
            i.printStackTrace();
        }
    }

}
