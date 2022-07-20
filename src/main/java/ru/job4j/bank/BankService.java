package ru.job4j.bank;

import javax.tools.OptionChecker;
import java.util.*;

/**
 * Класс для работы с аккаунтами клиентов
 * @author VasilyGromov
 */
public class BankService {

    /**
     * Данные располагаются в HashMap с параметрами: пользователь, связанные с пользователем аккаунту в ArrayList
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя.
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Создаёт новый аккаунт  привязвает его к пользователю по номеру паспорта
     * @param passport омер паспорта лоя привязки аккаунта к клиенту
     * @param account новый аккаунт
     */
    public void addAccount(String passport, Account account) {
        for (Map.Entry<User, List<Account>> i : users.entrySet()) {
            if (i.getKey().getPassport().equals(passport) && !i.getValue().contains(account)) {
                i.getValue().add(account);
            }
        }
    }

    /**
     * Поиск ползователя по номеру паспорта.
     * @param passport номер пасопрта
     * @return пользователь с указанным номером паспорта, если такой уже создан.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск аккаунта по номеру паспорта и реквизитам.
     * @param passport паспорт
     * @param requisite реквизиты
     * @return возвращает существующий аккаунт пользователя с указанным паспортом по указанным реквизитам
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> i = findByPassport(passport);
            return  i.flatMap(f -> users.get(f)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst());
    }

    /**
     * Перевод средств с одного баланса на другой
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты отправителя
     * @param descPassport номер паспорта получателя
     * @param descRequisite реквизиты счёты получателя
     * @param amount сумма перевода
     * @return Если оба пользователя существуют и сумма на счету отправителя достаточно,
     * осуществляет перевод по указанным реквизитам и возвращает true.
     * При ошибки в реквизитах и или недостатке средств, возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String descPassport, String descRequisite, double amount) {
        boolean rsl = false;
        if (findByPassport(srcPassport).isPresent() && findByPassport(descPassport).isPresent() && findByRequisite(srcPassport, srcRequisite).get().getBalance() >= amount) {
            double src = findByRequisite(srcPassport, srcRequisite).get().getBalance() - amount;
            findByRequisite(srcPassport, srcRequisite).get().setBalance(src);
            double desc = findByRequisite(descPassport, descRequisite).get().getBalance() + amount;
            findByRequisite(descPassport, descRequisite).get().setBalance(desc);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> user = bank.findByPassport("321");
        System.out.println(user.get().getUsername());
    }

}
