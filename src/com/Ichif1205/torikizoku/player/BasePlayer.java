package com.Ichif1205.torikizoku.player;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.Ichif1205.torikizoku.R;

/**
 * BasePlayerクラス.
 * 
 * @author wkodate
 * 
 */
public abstract class BasePlayer implements OnTouchListener {

    /**
     * x座標.
     */
    public int posX;

    /**
     * y座標.
     */
    public int posY;

    /**
     * x方向の速度.
     */
    public int dx;

    /**
     * ビットマップクラス.
     */
    private Bitmap mBitmap;

    /**
     * 幅.
     */
    private int width;

    /**
     * 高さ.
     */
    private int height;

    /**
     * デフォルトのx方向速度.
     */
    public static final int DEFAULT_PLYER_DX = -6;

    /**
     * デフォルトの幅.
     */
    public static final int DEFAULT_PLYER_WIDTH = 27;

    /**
     * デフォルトの高さ.
     */
    public static final int DEFAULT_PLYER_HEIGHT = 27;

    /**
     * コンストラクタ.
     * 
     * @param res
     *            リソース.
     * @param x
     *            x座標.
     * @param y
     *            z座標.
     */
    public BasePlayer(final Resources res, final int x, final int y) {
	// TODO 変更がありそうなら引数に追加
	dx = DEFAULT_PLYER_DX;
	width = DEFAULT_PLYER_WIDTH;
	height = DEFAULT_PLYER_HEIGHT;
	posX = x;
	posY = y;
	mBitmap = BitmapFactory.decodeResource(res, R.drawable.goomba);
    }

    /**
     * Bitmapを作成して返す.
     * 
     * @return Playerのbitmap
     */
    public final Bitmap createBitmap() {
	return Bitmap.createScaledBitmap(mBitmap, width, height, true);
    }

    /**
     * Playerの描画.
     * 
     * @param canvas
     *            2次元描画を行うクラス.
     * @param paint
     *            色やスタイルの情報を持つクラス.
     */
    public final void drawPlayer(final Canvas canvas, final Paint paint) {
	canvas.drawBitmap(mBitmap, posX, posY, paint);
	paint.setStyle(Paint.Style.FILL_AND_STROKE);
	updatePosition();
    }

    @Override
    public final boolean onTouch(final View v, final MotionEvent event) {
	if (event.getAction() == MotionEvent.ACTION_UP) {
	    upAction();
	} else if (event.getAction() == MotionEvent.ACTION_DOWN) {
	    downAction();
	} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
	    moveAction();
	} else if (event.getAction() == MotionEvent.ACTION_CANCEL) {
	    cancelAction();
	}

	return true;
    }

    /**
     * 画像を取得.
     * 
     * @return 画像のID.
     */
    protected abstract int getPlayerResource();

    /**
     * Playerの位置を更新.
     */
    public abstract void updatePosition();

    /**
     * 指を離した時の処理.
     */
    public abstract void upAction();

    /**
     * 指を接触した時の処理.
     */
    public abstract void downAction();

    /**
     * 指を動かした時の処理.
     */
    public abstract void moveAction();

    /**
     * upとdownが同時に発生した場合の処理.
     */
    public abstract void cancelAction();
}