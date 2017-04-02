package trees;

class LinkedListStack
{
    private StackNode first;
    public LinkedListStack()
    {
        first = null;
    }
    public boolean isEmpty()
    {
        return (first==null);
    }
    public void insert(Wierzcholek key)
    {
        StackNode newLLNode = new StackNode(key);
        newLLNode.next = first;
        first = newLLNode;
    }
    public Wierzcholek delete()
    {
        StackNode temp = first;
        first = first.next;
        return temp.item;
    }
}
