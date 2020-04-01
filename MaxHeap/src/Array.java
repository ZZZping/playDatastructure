public class Array<E>{

    private E[] data;
    private int size;

    /**
     *���캯�����������������capacity����Array
     * @param capacity �����С
     */
    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }

    /**
     * �޲����Ĺ��캯����Ĭ�����������capacity=10
     */
    public Array(){
        this(10);
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * ��ȡ������Ԫ�صĸ���
     * @return ����������Ԫ�ظ���
     */
    public int getSize(){
        return size;
    }


    /**
     * ��ȡ�����С
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * ���������Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * ������Ԫ�غ����Ԫ��
     * @param e
     */
    public void addLast(E e){
//        if(size==data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full");
//        }
//        data[size]=e;
//        size++;
        //data[size++]=e
        add(size,e);

    }

    /**
     * ������Ԫ��֮ǰ���Ԫ��
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * ��index�����Ԫ��e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size.");
        }
        if(size==data.length){
            resize(2*data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * ��ȡindex����λ��Ԫ��
     * @param index
     * @return
     */
    E get(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * �޸�indexλ��Ԫ��Ϊe
     * @param index
     * @param e
     */
    void set(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index]=e;
    }

    /**
     * �����������Ƿ���Ԫ��e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * ����������Ԫ��e���ڵ����������������Ԫ��e������-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i]==e){
                return i;
            }
        }
        return -1;
    }

    /**
     * ɾ������index��Ԫ�أ����ر�ɾ����Ԫ��
     * @param index
     * @return
     */
    public E remove(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size.");
        }
        E ret =data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        //loitering objects != memory leak
        if(size == data.length/4 && data.length/2 != 0){
            //��̬��С
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * ɾ����һ����Ԫ��
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * ɾ�����һ��Ԫ��
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * ��������ɾ��Ԫ��e
     * @param e
     */
    public void removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
    }

    public void swap(int i, int j){
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array: size = %d,capacity = %d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newDtata=(E[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            newDtata[i]=data[i];
        }
        data=newDtata;
    }

}
