package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        for (Map.Entry<User, List<Account>> i : users.entrySet()) {
            if (i.getKey().getPassport().equals(passport) && !i.getValue().contains(account)) {
                i.getValue().add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> i : users.entrySet()) {
            if (i.getKey().getPassport().equals(passport)) {
                return i.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Map.Entry<User, List<Account>> i : users.entrySet()) {
                for (Account j : i.getValue()) {
                    if (j.getRequisite().equals(requisite)) {
                        return j;
                    }
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String descPassport, String descRequisite, double amount) {
        boolean rsl = false;
        if (findByPassport(srcPassport) != null && findByPassport(descPassport) != null && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            double src = findByRequisite(srcPassport, srcRequisite).getBalance() - amount;
            findByRequisite(srcPassport, srcRequisite).setBalance(src);
            double desc = findByRequisite(descPassport, descRequisite).getBalance() + amount;
            findByRequisite(descPassport, descRequisite).setBalance(desc);
            rsl = true;
        }
        return rsl;
    }

}
