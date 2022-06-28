package Tree;

import java.io.PrintWriter;

public class tree<T extends Comparable<T>>
{
    private element<T> root;

    public tree()
    {
        root = null;

    }

    public void insert(T value)
    {
        root = inserting(root, value);
    }

    private element<T> inserting(element<T> current, T value)
    {
        if(current == null)
            return new element<>(value);
        if(value.compareTo(current.getValue()) < 0)
            current.setLeftChild(inserting(current.getLeftChild(), value));
        else if(value.compareTo(current.getValue()) > 0)
            current.setRightChild(inserting(current.getRightChild(), value));
        else
            return current;
        return current;
    }

    public boolean search(T value)
    {
        return searching(root, value);
    }

    private boolean searching(element<T> current, T value)
    {
        if(current == null)
            return false;
        if(value.compareTo(current.getValue()) == 0)
            return true;
        else if(value.compareTo(current.getValue()) < 0)
            return searching(current.getLeftChild(), value);
        else
            return searching(current.getRightChild(), value);
    }

    public void delete(T value)
    {
        root = deleting(root, value);
    }

    private element<T> deleting(element<T> current, T value)
    {
        if(current == null)
            return null;
        if(value.compareTo(current.getValue()) == 0)
        {
            if(current.getLeftChild() == null & current.getRightChild() == null)
                return null;
            else if(current.getLeftChild() == null)
                return current.getRightChild();
            else if(current.getRightChild() == null)
                return current.getLeftChild();
            else
            {
                element<T> theLeastOfRightSubTree = current.getRightChild();
                while(theLeastOfRightSubTree.getLeftChild() != null)
                {
                    theLeastOfRightSubTree = theLeastOfRightSubTree.getLeftChild();
                }
                current.setValue(theLeastOfRightSubTree.getValue());
                current.setRightChild(deleting(current.getRightChild(), theLeastOfRightSubTree.getValue()));
            }
        }
        else if(value.compareTo(current.getValue()) < 0)
        {
            current.setLeftChild(deleting(current.getLeftChild(), value));
            return current;
        }
        current.setRightChild(deleting(current.getRightChild(), value));
        return current;
    }

    private void drawing(element<T> current, PrintWriter out)
    {
        if(current != null)
        {
            drawing(current.getLeftChild(), out);
            out.print(current.getValue() + " ");
            drawing(current.getRightChild(), out);
        }
    }

    public void drawInOrder(PrintWriter out)
    {
        drawing(root, out);
        out.println();
    }
}