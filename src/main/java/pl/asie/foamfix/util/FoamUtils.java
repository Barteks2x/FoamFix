/**
 * This file is part of FoamFix.
 *
 * FoamFix is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FoamFix is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with FoamFix.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Additional permission under GNU GPL version 3 section 7
 *
 * If you modify this Program, or any covered work, by linking or
 * combining it with the Minecraft game engine, the Mojang Launchwrapper,
 * the Mojang AuthLib and the Minecraft Realms library (and/or modified
 * versions of said software), containing parts covered by the terms of
 * their respective licenses, the licensors of this Program grant you
 * additional permission to convey the resulting work.
 */
package pl.asie.foamfix.util;

import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import pl.asie.foamfix.FoamFix;

import java.lang.reflect.Field;
import java.util.Map;

public final class FoamUtils {
	private FoamUtils() {

	}

	public static void wipeModelLoaderRegistryCache() {
	    Field resourceCacheField = ReflectionHelper.findField(ModelLoaderRegistry.class, "cache");
	    try {
	        Map oldResourceCache = (Map) resourceCacheField.get(null);
		    FoamFix.logger.info("Clearing ModelLoaderRegistry cache (" + oldResourceCache.size() + " items)...");
	        oldResourceCache.clear();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    }
	}
}
