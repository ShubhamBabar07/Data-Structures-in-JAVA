package DSA.Specific_DSA.Doubly_LinkedList;

class node
{
    public int data;
    public node next;
    public node prev;
    
    public node(int Value)
    {
        data = Value;
        next = null;
        prev = null;
    }
}

class DoublyLL
{
    public node First;
    
    public int iCount;

    public DoublyLL()
    {
        First = null;
        iCount = 0;
    }

    public void InsertFirst(int No)
    {
        node newn = null;

        newn = new node(No);

        if(First == null)
        {
            First = newn;
        }
        else
        {
            newn.next = First;
            First.prev = newn;
            First = newn;
        }

        iCount++;
    }

    public void InsertLast(int No)
    {
        node newn = null;

        newn = new node(No);

        if(First == null)
        {
            First = newn;

        }
        else
        {
            node temp = First;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
            newn.prev = temp;
        }

        iCount++;
    }

    public void Display()
    {
        System.out.println("Elements of LL are : ");
        
        node temp = First;

        System.out.print("NULL<=>");
        
        while(temp != null)
        {
            System.out.print("| "+temp.data+" |<=>");
            temp = temp.next;
        }

        System.out.println("NULL");
    }
    
    public int Count()
    {
        return iCount;
    }

    public void DeleteFirst()
    {
        if(First == null)
        {
            return;
        }
        else if(First.next == null)
        {
            First = null;

        }
        else
        {
            First = First.next;
            First.prev = null;
        }

        iCount--;
    }

    public void DeleteLast()
    {
        if(First == null)
        {
            return;
        }
        else if(First.next == null)
        {
            First = null;
        }
        else
        {
            node temp = First;
        
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }

        iCount--;
    }
    
    public void InsertAtPos(int No, int iPos)
    {
        if(iPos < 1 || iPos > iCount+1)
        {
            System.out.println("Invalid Position");
            return;
        }

        if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if(iPos == iCount + 1)
        {
            InsertLast(No);
        }
        else
        {
            node newn = new node(No);
            node temp = First;
            int i = 0;

            for(i = 1; i < iPos-1; i++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            temp.next.prev = newn;
            temp.next = newn;
            newn.prev = temp;

            iCount++;
        }
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos < 1 || iPos > iCount)
        {
            System.out.println("Invalid Position");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            node temp = First;
            int i = 0;

            for(i = 1; i < iPos-1; i++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;

            iCount--;
        } 
    }
}

public class Doubly_Linear 
{
    public static void main(String Arg[])
    {
        DoublyLL obj = new DoublyLL();
        int iRet = 0;

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);
        
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of elemenst are : "+iRet);

        obj.InsertAtPos(105,5);
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of elemenst are : "+iRet);

        obj.DeleteAtPos(5);
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of elemenst are : "+iRet);
    }
}
