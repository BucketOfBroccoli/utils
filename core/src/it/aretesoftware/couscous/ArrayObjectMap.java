package it.aretesoftware.couscous;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Identical to the {@link ObjectMap}; the only difference is that
 * the values are {@link Array<V>}s of objects.
 * @author 4r3t-3 */
public class ArrayObjectMap<K, V> extends ObjectMap<K, Array<V>> {

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

    private Array<V> getArray(K key) {
        Array<V> array = super.get(key);
        if (array == null) array = new Array<>();
        return array;
    }

}
