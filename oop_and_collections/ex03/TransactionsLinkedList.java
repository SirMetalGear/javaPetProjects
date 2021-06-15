
public class TransactionsLinkedList implements TransactionsList{
    private Transaction head;
    private int size;
    public TransactionsLinkedList() {
        head = null;
        size = 0;
    }
    public void addTransaction(Transaction obj) {
        if (head == null)
            head = obj;
        else {
            Transaction tmp = head;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = obj;
            obj.prev = tmp;
        }
        size++;
    }
    public void delete(String uuid) {
        if (size == 0)
            return ;
        if (size == 1 && head.getId().equals(uuid)) {
            head = null;
            size--;
            return;
        }
        Transaction tmp = head;
        while (tmp != null)
        {
            if (tmp.getId().equals(uuid)) {
                if (tmp.next == null) {
                    tmp.prev.next = null;
                }
                else if (tmp == head) {
                    head = head.next;
                }
                else {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
                size--;
                return ;
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException();
    }
    public Transaction[] toArray() {
        if (size == 0)
            return null;
        Transaction[] arr = new Transaction[size];
        Transaction tmp = head;
        for (int i = 0; i < size; i++) {
            arr[i] = tmp;
            tmp = tmp.next;
        }
        return arr;
    }
    public int size() { return size; }
    public void printId()
    {
        Transaction tmp = head;
        while (tmp != null) {
            tmp.info();
            tmp = tmp.next;
        }
    }
    public Transaction findId(String id)
    {
        Transaction tmp = head;
        while (tmp != null)
        {
            if (tmp.getId().equals(id)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException();
    }
}
