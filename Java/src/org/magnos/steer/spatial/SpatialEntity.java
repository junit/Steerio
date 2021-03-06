
package org.magnos.steer.spatial;

import org.magnos.steer.Vector;


public interface SpatialEntity
{

	public Vector getPosition();

	public float getRadius();

	public long getSpatialGroups();
	
	public long getSpatialCollisionGroups();

	public boolean isStatic();

	public boolean isInert();

}
