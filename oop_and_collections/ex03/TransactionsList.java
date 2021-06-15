
interface TransactionsList {
    void addTransaction(Transaction obj);
    void delete(String uuid);
    Transaction[] toArray();
}
