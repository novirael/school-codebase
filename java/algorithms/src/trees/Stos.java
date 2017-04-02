package trees;

class Stos
{
    private LinkedListStack listObj;
    public Stos()
    {
        listObj = new LinkedListStack();
    }
    public void push(Wierzcholek num)
    {
        listObj.insert(num);
    }
    public Wierzcholek pop()
    {
        return listObj.delete();
    }
    public boolean isEmpty()
    {
        return listObj.isEmpty();
    }
}