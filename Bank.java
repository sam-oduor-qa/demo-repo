import java.util.HashMap;

// Make sure Account is imported if it's in another package
// import your.package.Account;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
