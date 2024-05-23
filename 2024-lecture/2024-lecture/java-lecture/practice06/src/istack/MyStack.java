package istack;

import java.util.Vector;

public class MyStack<T> implements IStack<T>{
    Vector<T> vector = null;

    public MyStack() {
        vector = new Vector<>();
    }

    @Override
    public T pop() {
        return vector.remove(0); // 삭제된 데이터의 값이 나온다
    }

    @Override
    public boolean push(T ob) {
        vector.add(0,ob);
        return false;
    }
}
