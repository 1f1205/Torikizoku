package com.Ichif1205.torikizoku.enemy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.Ichif1205.torikizoku.MainSurfaceView;
import com.Ichif1205.torikizoku.R;

/**
 * BaseEnemyクラス.
 * 
 * @author wkodate
 * 
 */
public abstract class BaseEnemy  {

    /**
     * x座標.
     */
    protected int posX;

    /**
     * y座標.
     */
    protected int posY;

    /**
     * x方向の速度.
     */
    protected int dx;

    /**
     * x方向の速度.
     */
    protected int dy;

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
    public static final int DEFAULT_ENEMY_DX = 3;

    /**
     * デフォルトの幅.
     */
    public static final int DEFAULT_ENEMY_WIDTH = 27;

    /**
     * デフォルトの高さ.
     */
    public static final int DEFAULT_ENEMY_HEIGHT = 27;

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
    public BaseEnemy(final Resources res, final int x, final int y) {
	// TODO 変更がありそうなら引数に追加
	dx = DEFAULT_ENEMY_DX;
	width = DEFAULT_ENEMY_WIDTH;
	height = DEFAULT_ENEMY_HEIGHT;
	posX = x;
	posY = y;
	mBitmap = BitmapFactory.decodeResource(res, R.drawable.mario);
    }

    /**
     * Bitmapを作成して返す.
     * 
     * @return Enemyのbitmap
     */
    public final Bitmap createBitmap() {
	return Bitmap.createScaledBitmap(mBitmap, width, height, true);
    }

    /**
     * Enemyの描画.
     * 
     * @param canvas
     *            2次元描画を行うクラス.
     * @param paint
     *            色やスタイルの情報を持つクラス.
     */
    public final void drawEnemy(final Canvas canvas, final Paint paint) {
	canvas.drawBitmap(mBitmap, posX, posY, paint);
	paint.setStyle(Paint.Style.FILL_AND_STROKE);
	updatePosition();
    }

    /**
     * 画像を取得.
     * 
     * @return 画像のID.
     */
    protected abstract int getEnemyResource();

    /**
     * Enemyの位置を更新.
     */
    public abstract void updatePosition();

}