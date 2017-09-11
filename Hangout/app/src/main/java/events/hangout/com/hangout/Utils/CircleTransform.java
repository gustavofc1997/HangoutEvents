package events.hangout.com.hangout.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

public class CircleTransform implements Transformation {

	private int borderColor;
	private float strokeWidth;

	public CircleTransform(int borderColor, float strokeWidth) {
		this.borderColor = borderColor;
		this.strokeWidth = strokeWidth;
	}

	@Override
	public Bitmap transform(Bitmap source) {
		int size = Math.min(source.getWidth(), source.getHeight());

		int x = (source.getWidth() - size) / 2;
		int y = (source.getHeight() - size) / 2;

		Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
		if (squaredBitmap != source) {
			source.recycle();
		}

		Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

		float r = size / 2f;

		// draw image
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint();
		BitmapShader shader = new BitmapShader(squaredBitmap,
				BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
		paint.setShader(shader);
		paint.setAntiAlias(true);
		canvas.drawCircle(r, r, r, paint);

		// draw white border
		Paint border = new Paint();
		border.setAntiAlias(true);
		border.setFilterBitmap(false);
		border.setColor(borderColor);
		border.setStyle(Paint.Style.STROKE);
		border.setStrokeWidth(strokeWidth);
		canvas.drawCircle(r, r, r -(strokeWidth/2) , border);

		squaredBitmap.recycle();
		return bitmap;
	}

	@Override
	public String key() {
		return "circle";
	}
}
