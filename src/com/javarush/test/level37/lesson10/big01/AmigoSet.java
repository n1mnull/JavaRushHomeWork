package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Alenka on 09.06.2016.
 */
public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16,collection.size()/.75f);
        map = new HashMap<>(capacity);
        for (E e :collection) {
            this.add(e);
        }
    }

    @Override
    public boolean add(Object e){
        try {
            map.put((E)e,AmigoSet.PRESENT);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AmigoSet<E> amigoSet = new AmigoSet<>();
        try {
            amigoSet.addAll(this);
            amigoSet.map.putAll(this.map);
        }catch (Exception ex){
            throw new InternalError();
        }
        return amigoSet;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        out.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));
        out.writeObject(new HashSet<Integer>((Collection<Integer>) map.keySet()));
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        addAll((Collection)in.readObject());
    }


}
