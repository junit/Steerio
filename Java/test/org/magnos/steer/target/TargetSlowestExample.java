
package org.magnos.steer.target;

import java.awt.Color;
import java.awt.Graphics2D;

import org.magnos.steer.SteerMath;
import org.magnos.steer.SteerSet;
import org.magnos.steer.behavior.SteerBasicExample;
import org.magnos.steer.behavior.SteerTo;
import org.magnos.steer.behavior.SteerWander;
import org.magnos.steer.spatial.SpatialDatabase;
import org.magnos.steer.spatial.array.SpatialArray;
import org.magnos.steer.test.SteerSprite;

import com.gameprogblog.engine.Game;
import com.gameprogblog.engine.GameLoop;
import com.gameprogblog.engine.GameLoopVariable;
import com.gameprogblog.engine.GameScreen;
import com.gameprogblog.engine.GameState;
import com.gameprogblog.engine.Scene;


public class TargetSlowestExample extends SteerBasicExample
{
	
	public static void main( String[] args )
	{
		Game game = new TargetSlowestExample( DEFAULT_WIDTH, DEFAULT_HEIGHT );
		GameLoop loop = new GameLoopVariable( 0.1f );
		GameScreen screen = new GameScreen( DEFAULT_WIDTH, DEFAULT_HEIGHT, true, loop, game );
		screen.setBackground( Color.black );
		GameScreen.showWindow( screen, "TargetAverageExample" );
	}

	private TargetSlowest slowest;
	private SpatialDatabase database;

	public TargetSlowestExample( int w, int h )
	{
		super( w, h );
	}
	
	@Override
	public void start( Scene scene )
	{
		database = new SpatialArray( 32 );
		
		newSprite( Color.red, 15, 190, 500, new SteerSet(  
			new SteerTo( slowest = new TargetSlowest( database, 100, 200, false, 32, SpatialDatabase.ALL_GROUPS ) ),
			new SteerWander( 0, 100, 150, 80 )
		));

		for (int i = 0; i < 24; i++)
		{
			SteerSprite lamb = newSprite( Color.white, 10, SteerMath.randomFloat( 150, 250 ), 1000, new SteerWander( 0, 100, 150, 80 ) );
			lamb.position.set( SteerMath.randomFloat( width ), SteerMath.randomFloat( height ) );
			database.add( lamb );
		}
	}

	@Override
	public void draw( GameState state, Graphics2D gr, Scene scene )
	{
		super.draw( state, gr, scene );

		drawCircle( gr, Color.red, slowest.target, 5, false );
		drawCircle( gr, Color.orange, slowest.queryPosition, slowest.queryRadius, false );
	}
	
}
