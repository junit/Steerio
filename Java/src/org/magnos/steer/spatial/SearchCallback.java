
package org.magnos.steer.spatial;

import org.magnos.steer.Vector;

/**
 * A callback which is notified when an entity was found in a search query.
 */
public interface SearchCallback
{

	/**
	 * Invoked when an entity was found in a search. If the found entity is a
	 * valid find then true should be returned, otherwise if false is returned
	 * the entity won't count as a find.
	 * 
	 * @param entity
	 *        The entity that was found.
	 * @param overlap
	 *        The approximate amount of overlap between the entities.
	 * @param index
	 *        The number of entities found before this one.
	 * @return True if the entity was a valid find.
	 */
	public boolean onFound( SpatialEntity entity, float overlap, int index, Vector queryOffset, float queryRadius, int queryMax, long queryGroups );
}
