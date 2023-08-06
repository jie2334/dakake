package testDynamicArray;

import java.util.Arrays;

/**
 * @description: 动态数组
 * @author: 22783
 * @date: 2023/7/27
 **/
public class DynamicArray {


    private Object[] objects = {};
    private int size = 0;



    public DynamicArray() {
        /*this.objects = new Object[DEFAULT_LENGTH];*/
        this(10);
    }

    /**
     * 初始化容量
     * @param initialCapacity
     */
    public DynamicArray(int initialCapacity) {
        this.objects = new Object[initialCapacity];
    }
    /**
     * 添加元素
     * @param obj
     */
    public void addElement(Object obj){

        for (int index = 0; index < getSize(); index++) {
            if (getIndex(index).hashCode()==obj.hashCode()){
                throw new RuntimeException("有重复元素!");
            }
        }
        if (getSize()== objects.length){
            System.out.println("开始扩容");
            Object[] copyObject = new Object[getSize() * 2];
            System.arraycopy(objects,0,copyObject,0,getSize());
            objects=copyObject;

        }
        objects[size++] = obj;
    }

    public Object remove(int index){
        /*
        * 先计算删除元素的下一个到最后一个的总距离
        *
        * 将目标元素后面的元素整体往前移
        *
        * 将移动之后的空白元素给赋值null
        * */

        int numMove = getSize()-index-1;

        System.arraycopy(objects,index+1,objects,index,numMove);
        objects[--size] = null;

        return objects[index];
    }


    /**
     * 删除链表中的最后一个元素,并返回
     *
     * @return
     */

    /**
     *
     * @return
     */
    public int getSize(){
        return this.size;
    }

    public Object getIndex(int index){
        if (index >= size) {
            throw new IndexOutOfBoundsException("非法下标，数组越界！");
        }
        return objects[index];
    }


    @Override
    public String toString() {
        return "DynamicArray{" +
                "objects=" + Arrays.toString(objects) +
                ", size=" + size +
                '}';
    }
}
