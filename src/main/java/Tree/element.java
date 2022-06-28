package Tree;

public class element <T extends Comparable<T>>
{
    private element<T> leftChild;
    private element<T> rightChild;
    private T value;

    public element(T value)
    {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public T getValue()
    {
        return value;
    }

    public element<T> getLeftChild()
    {
        return leftChild;
    }

    public element<T> getRightChild()
    {
        return rightChild;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setRightChild(element<T> rightChild)
    {
        this.rightChild = rightChild;
    }

    public void setLeftChild(element<T> leftChild)
    {
        this.leftChild = leftChild;
    }
}