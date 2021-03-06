/*
 *   Anvil - AnvilPowered
 *   Copyright (C) 2020 Cableguy20
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anvilpowered.anvil.base.component;

import jetbrains.exodus.entitystore.EntityId;
import jetbrains.exodus.entitystore.PersistentEntityId;
import jetbrains.exodus.entitystore.PersistentEntityStore;
import org.anvilpowered.anvil.api.component.Component;

import java.util.Optional;

public interface BaseXodusComponent extends Component<EntityId, PersistentEntityStore> {

    @Override
    default EntityId parseUnsafe(Object object) {
        if (object instanceof EntityId) {
            return (EntityId) object;
        } else if (object instanceof Optional<?>) {
            Optional<?> optional = (Optional<?>) object;
            if (optional.isPresent()) return parseUnsafe(optional.get());
            throw new IllegalArgumentException("Error while parsing " + object + ". Optional not present");
        }
        String string = object.toString();
        String[] stringParts = string.split("-");
        if (stringParts.length != 2) {
            throw new IllegalArgumentException("Not a valid EntityId. Must follow format (int)-(long)");
        }
        return new PersistentEntityId(Integer.parseInt(stringParts[0]), Long.parseLong(stringParts[1]));
    }
}
