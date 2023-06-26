package it.aretesoftware.couscous;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.OrderedMap;

/**
 * Identical to the {@link OrderedMap}; the only difference is that
 * the values are {@link Array<V>}s of objects.
 * @author AreteS0ftware */
public class ArrayOrderedMap<K, V> extends OrderedMap<K, Array<V>> {

    public Array<V> add(K key, V value) {
        Array<V> array = getArray(key);
        array.add(value);
        return super.put(key, array);
    }

    public Array<V> addAll(K key, Array<V> value) {
        Array<V> array = getArray(key);
        array.addAll(value);
        return super.put(key, array);
    }

    @SafeVarargs
    public final Array<V> addAll(K key, V... value) {
        Array<V> array = getArray(key);
        array.addAll(value);
        return super.put(key, array);
    }

    private Array<V> getArray(K key) {
        Array<V> array = super.get(key);
        if (array == null) array = new Array<>();
        return array;
    }

}
