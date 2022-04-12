package com.kobilov.homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankApp{
    public static void main(String[] args) {
        Account acc1 = new Account();
        acc1.setAmount(15);
        List<Account> accList = new ArrayList<>();
        accList.add(acc1);

        Client cl1 = new Client();
        cl1.setName("aziz");
        cl1.setAge(32);
        cl1.setAccounts(accList);

        Account acc2 = new Account();
        acc2.setAmount(65);
        accList.clear();
        accList.add(acc2);

        Client cl2 = new Client();
        cl2.setName("sasha");
        cl2.setAge(45);
        cl1.setAccounts(accList);

        Bank bank = new Bank();
        List<Client> clList = new ArrayList<>();
        clList.add(cl1);
        clList.add(cl2);
        bank.setClients(clList);

        System.out.println(bank.getAccounts(cl1));
        System.out.println(bank.findClient(acc2));
    }
}

class Bank {
    private List<Client> clients;

    List<Account> getAccounts(Client client){
        return client.getAccounts();
    }

    Client findClient(Account account){
        for (Client client: clients){
            for (Account acc: client.getAccounts()){
                if (acc.equals(account))
                    return client;
            }
        }
        return null;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

class Client{
    private String name;
    private Integer age;
    private List<Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(age, client.age) && Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, accounts);
    }
}

class Account{
    private Integer amount = 0;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}