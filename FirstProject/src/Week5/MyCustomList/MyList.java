package Week5.MyCustomList;

public class MyList<T> {
    T[] array;
    int defaultCapacity = 10;

    public MyList()
    {
        array = (T[]) new Object[defaultCapacity];
    }

    public MyList(int capacity)
    {
        array = (T[]) new Object[capacity];
    }

    public int size(){
        int notNullCount = 0;
        for(T data : array)
        {
            if(data != null) notNullCount++;
        }

        return notNullCount;
    }

    public int getCapacity()
    {
        return array.length;
    }

    public void add(T data)
    {
        if(size() == getCapacity())
        {
            T[] newArr = (T[]) new Object[getCapacity() * 2];

            if (getCapacity() >= 0) System.arraycopy(array, 0, newArr, 0, getCapacity());

            array = newArr;
        }

        for(int i = 0; i < getCapacity(); i++)
        {
            if(array[i] == null) {
                array[i] = data;
                break;
            }
        }
    }

    public T get(int index)
    {
        if(index < 0 || index >= size()) return null;

        return array[index];
    }

    public T remove(int index)
    {
        if(index < 0 || index >= size()) return null;

        T deletedData = array[index];
        array[index] = null;

        for(int i = index; i < getCapacity() - index; i++)
        {
            array[i] = array[i + 1];
        }
        array[getCapacity() - 1] = null;

        return deletedData;
    }

    public void set(int index, T data)
    {
        if(index < 0 || index >= size()) return;

        array[index] = data;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();

        result.append("[");
        for(int i = 0; i < size(); i++)
        {
            result.append(array[i].toString()).append(", ");
        }
        if(size() > 0) result.delete(result.length() - 2,result.length());
        result.append("]");

        return result.toString();
    }

    public int indexOf(T data)
    {
        int index = -1;
        for(int i = 0; i < size(); i++)
        {
            if(array[i] == data){
                index = i;
                break;}

        }

        return index;
    }

    public int lastIndexOf(T data)
    {
        int index = -1;
        for(int i = 0; i < size(); i++)
        {
            if(array[i] == data) index = i ;
        }

        return index;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public T[] toArray()
    {
        return array.clone();
    }

    public void clear()
    {
        for(T d : array)
        {
            d = null;
        }

        array = (T[]) new Object[defaultCapacity];
    }

    public MyList<T> subList(int start, int end)
    {
        if(start < 0 || end >= size() || end < start) return null;

        MyList<T> sublist = new MyList<>();
        for(int i = start; i <= end; i++){
            sublist.add(array[i]);
        }

        return sublist;
    }

    public boolean contains(T data)
    {
        for(T d : array)
        {
            if(d == data) return true;
        }

        return false;
    }
}
