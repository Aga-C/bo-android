package org.blitzortung.android.map;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;

import com.google.android.maps.MapView;

public class StrokesMapView extends MapView {

	public interface ZoomListener {
		public void onZoom(int zoomLevel);
	};
	
	List<ZoomListener> zoomListeners = new ArrayList<ZoomListener>();
	
	private static final String TAG = "maps.StrokesMapView";
	
	public StrokesMapView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public StrokesMapView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public StrokesMapView(Context context, String apiKey) {
		super(context, apiKey);
	}

	int oldZoomLevel = -1;

	@Override
	public void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		if (getZoomLevel() != oldZoomLevel) {
			// Log.v(TAG, "old vs. new zoom: " + oldZoomLevel + " -> " + getZoomLevel());
			
			for (ZoomListener zoomListener: zoomListeners)
				zoomListener.onZoom(getZoomLevel());
		
			oldZoomLevel = getZoomLevel();
		}
	}
	
	public void addZoomListener(ZoomListener zoomListener) {
		zoomListeners.add(zoomListener);
	}
}