/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.data.manipulator.mutable.common;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.util.CollectionUtils;

import java.util.Map;

/**
 * A common implementation for {@link ListData}s provided by the API.
 *
 * @param <K> The type of key in the map
 * @param <V> The type of value in the map
 * @param <M> The type of {@link DataManipulator}
 * @param <I> The type of {@link ImmutableDataManipulator}
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMappedData<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>>
        extends AbstractSingleData<Map<K, V>, M, I> implements MappedData<K, V, M, I> {

    protected AbstractMappedData(Key<MapValue<K, V>> usedKey, Map<K, V> value) {
        super(usedKey, CollectionUtils.copyMap(value));
    }

    @Override
    protected MapValue.Mutable<K, V> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createMapValue(this.usedKey, getValue());
    }

    @Override
    protected Map<K, V> getValue() {
        return CollectionUtils.copyMap(super.getValue());
    }

    @Override
    protected M setValue(Map<K, V> value) {
        return super.setValue(CollectionUtils.copyMap(value));
    }

    @Override
    public MapValue.Mutable<K, V> getMapValue() {
        return getValueGetter();
    }

    @Override
    public Map<K, V> asMap() {
        return getValue();
    }
}
