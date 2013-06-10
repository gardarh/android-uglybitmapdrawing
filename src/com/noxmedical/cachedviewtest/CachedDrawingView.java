package com.noxmedical.cachedviewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.view.View;

public class CachedDrawingView extends View {
	private boolean initialized = false;
	private static final Paint linePaint = new Paint();
	private Bitmap cachedBitmap = null;
	private Canvas cachedCanvas = null;
	private static final float[][] COORDS = new float[][] {new float[] {0.0000f,86.5500f,0.0000f,21.9000f},new float[] {0.0000f,21.9000f,1.0000f,90.5500f},new float[] {1.0000f,90.5500f,1.0000f,5.6500f},new float[] {1.0000f,5.6500f,2.0000f,99.8000f},new float[] {2.0000f,99.8000f,2.0000f,5.3000f},new float[] {2.0000f,5.3000f,3.0000f,89.9500f},new float[] {3.0000f,89.9500f,3.0000f,23.9000f},new float[] {3.0000f,23.9000f,4.0000f,95.0000f},new float[] {4.0000f,95.0000f,4.0000f,21.9000f},new float[] {4.0000f,21.9000f,5.0000f,98.0000f},new float[] {5.0000f,98.0000f,5.0000f,10.4500f},new float[] {5.0000f,10.4500f,6.0000f,96.8000f},new float[] {6.0000f,96.8000f,6.0000f,24.5000f},new float[] {6.0000f,24.5000f,7.0000f,98.8000f},new float[] {7.0000f,98.8000f,7.0000f,31.2500f},new float[] {7.0000f,31.2500f,8.0000f,87.2500f},new float[] {8.0000f,87.2500f,8.0000f,21.8500f},new float[] {8.0000f,21.8500f,9.0000f,92.3500f},new float[] {9.0000f,92.3500f,9.0000f,11.8000f},new float[] {9.0000f,11.8000f,10.0000f,91.6500f},new float[] {10.0000f,91.6500f,10.0000f,6.6500f},new float[] {10.0000f,6.6500f,11.0000f,86.2000f},new float[] {11.0000f,86.2000f,11.0000f,1.7500f},new float[] {11.0000f,1.7500f,12.0000f,64.0500f},new float[] {12.0000f,64.0500f,12.0000f,27.0500f},new float[] {12.0000f,27.0500f,13.0000f,81.7000f},new float[] {13.0000f,81.7000f,13.0000f,4.2500f},new float[] {13.0000f,4.2500f,14.0000f,87.5500f},new float[] {14.0000f,87.5500f,14.0000f,3.8500f},new float[] {14.0000f,3.8500f,15.0000f,82.0500f}};
	
	public CachedDrawingView(Context context) {
		super(context);
		initView(context);
	}

	public CachedDrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public CachedDrawingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}
	private void initView(Context ctx) {
		if(!initialized) {
			initialized = true;
			linePaint.setColor(Color.BLACK);
		}
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		if(cachedBitmap == null) {
			cachedBitmap = Bitmap.createBitmap(getWidth(), 200, Config.ARGB_8888);
			// cachedBitmap.setHasAlpha(false);
			// cachedBitmap.eraseColor(Color.WHITE);
			cachedCanvas = new Canvas(cachedBitmap);
		}
		
		for(int i = 0; i < COORDS.length; i++) {
			float[] curCoords = COORDS[i];
			canvas.drawLine(curCoords[0], curCoords[1], curCoords[2], curCoords[3], linePaint);
			cachedCanvas.drawLine(curCoords[0], curCoords[1], curCoords[2], curCoords[3], linePaint);
		}
		canvas.drawBitmap(cachedBitmap, 0, 120, null);
	}
}
