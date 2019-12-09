/*
 *     MSRepository - MilSpecSG
 *     Copyright (C) 2019 Cableguy20
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

package rocks.milspecsg.msrepository.api.repository;

import io.jsondb.JsonDBOperations;
import rocks.milspecsg.msrepository.api.cache.RepositoryCacheService;
import rocks.milspecsg.msrepository.datastore.json.JsonConfig;
import rocks.milspecsg.msrepository.model.data.dbo.ObjectWithId;

import java.util.UUID;

public interface JsonRepository<
    T extends ObjectWithId<UUID>,
    C extends RepositoryCacheService<UUID, T, JsonDBOperations, JsonConfig>>
    extends Repository<UUID, T, C, JsonDBOperations, JsonConfig> {

    String asQuery(UUID id);
}
