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
package org.spongepowered.api.world.volume.archetype.tileentity.worker;

import org.spongepowered.api.block.tileentity.TileEntityArchetype;
import org.spongepowered.api.world.volume.archetype.tileentity.MutableTileEntityArchetypeVolume;
import org.spongepowered.api.world.volume.archetype.tileentity.UnmodifiableTileEntityArchetypeVolume;
import org.spongepowered.api.world.volume.block.worker.BlockVolumeStream;
import org.spongepowered.api.world.volume.worker.MutableVolumeStream;
import org.spongepowered.api.world.volume.worker.VolumeResult;

import java.util.function.Predicate;

/**
 * Similar to {@link BlockVolumeStream} but adds support for mutating the
 * backing volume.
 */
public interface MutableTileEntityArchetypeStream<M extends MutableTileEntityArchetypeVolume<M>>
    extends TileEntityArchetypeStream<M, M>, MutableVolumeStream<M, UnmodifiableTileEntityArchetypeVolume<?>, TileEntityArchetype> {

    @Override
    MutableTileEntityArchetypeStream<M> filter(Predicate<VolumeResult<M, ? super TileEntityArchetype>> predicate);
}
